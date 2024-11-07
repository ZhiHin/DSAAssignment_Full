/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.SortedArrayList;
import boundary.CourseMaintenanceUI;
import dao.CourseDAO;
import entity.Course;
import entity.Program;
import utility.MsgUI;
import adt.SortedArrayListInterface;

/**
 *
 * @author Dickie Wong Wei Hao
 */
public class CourseMaintenance {

    private CourseMaintenanceUI courseUI = new CourseMaintenanceUI();
    SortedArrayListInterface<Course> course = new SortedArrayList<>();
    private CourseDAO courseDAO = new CourseDAO();

    public CourseMaintenance() {
        course = courseDAO.retrieveFromFile();
    }

    public static void main(String[] args) {

        CourseMaintenance CourseMaintenance = new CourseMaintenance();
        CourseMaintenance.runCourseMaintenance();

    }

    public void runCourseMaintenance() {
        int choice;
        do {
            choice = courseUI.getMenuChoice();
            switch (choice) {
                case 0:

                    break;
                case 1:
                    addNewCourse();
                    displayCourses();
                    break;
                case 2:
                    displayCourses();
                    break;
                case 3:
                    removeCourse();

                    break;
                case 4:
                    findCourse();

                    break;
                case 5:
                    amendCourse();
                    break;
                case 6:
                    assignProgramsToCourse();
                    displayCourses();
                    break;
                case 7:
                    removeProgramToCourse();
                    displayCourses();
                    break;
                case 8:
                    generateReport();
                    break;

                case 9:
                    course.clear();
                    courseDAO.clearFile();
                    break;
                default:
                    MsgUI.InvalidChoice();
            }
        } while (choice != 0);

        MsgUI.displayExitMessage();
    }

    public void addNewCourse() {
        Course newCourse = courseUI.inputCourseDetails();

        if (course.contains(newCourse)) {
            courseUI.printCourseIDAlreadyExists(newCourse.getCourseID());
        } else {
            course.add(newCourse);
            courseDAO.saveToFile(course);
            courseUI.printCourseAdded(newCourse.getCourseID());
        }
    }

    public String getAllCourses() {
        String outputStr = "";
        for (int i = 1; i <= course.getNumberOfEntries(); i++) {
            outputStr += course.getEntry(i);
        }
        return outputStr;
    }

    public void displayCourses() {
        if (course.isEmpty()) {
            courseUI.printCourseTableEmpty();
            return;
        }
        courseUI.listAllCourses(getAllCourses());
    }

    public void removeCourse() {
        int removalMethod = courseUI.removeMenu();

        switch (removalMethod) {
            case 1:
                // Remove By Index
                if (course.isEmpty()) {
                    courseUI.printNoCoursesToRemove();
                    return;
                }
                int indexToRemove = courseUI.inputIndex();
                removeByIndex(indexToRemove);
                break;
            case 2:
                // Remove By ID
                if (course.isEmpty()) {
                    courseUI.printNoCoursesToRemove();
                    return;
                }
                String courseID = courseUI.inputCourseID();
                removeByID(courseID);

                break;
            default:
                MsgUI.InvalidChoice();

        }

    }

    public void removeByIndex(int indexToRemove) {

        if (indexToRemove >= 1 && indexToRemove <= course.getNumberOfEntries()) {
            Course removedCourse = course.remove(indexToRemove);
            courseDAO.saveToFile(course);
            if (removedCourse != null) {
                courseUI.printCourseRemoved(indexToRemove, removedCourse);
                courseUI.listAllCourses(getAllCourses());
            } else {
                courseUI.printFailedToRemoveCourse(indexToRemove);
            }
        } else {
            courseUI.printInvalidIndex();
        }
    }

    public void removeByID(String courseID) {

        int index = course.indexOf(new Course(courseID, null, 0));

        if (index != -1) {
            Course removedCourse = course.remove(index);
            courseUI.printCourseRemoved(courseID, removedCourse);
            courseDAO.saveToFile(course);
            courseUI.listAllCourses(getAllCourses());
        } else {
            courseUI.printFailedToRemoveCourse(courseID);
        }
    }

    public void findCourse() {
        if (!course.isEmpty()) {
            int option = courseUI.getFindCourseOption();

            switch (option) {
                case 1:
                    findCourseByID();
                    break;
                case 2:
                    findCourseDetailed();
                    break;
                case 3:
                    findCourseByName();
                    break;
                case 4:
                    findCourseByCreditHour();
                    break;
                case 0:
                    courseUI.printFindCourseCancelled();
                    break;
                default:
                    courseUI.printInvalidInput();
            }
        } else {
            courseUI.printEmptyCourseList();
        }
    }

    public void findCourseDetailed() {
        if (course.isEmpty()) {
            courseUI.printNoCoursesToSearch();
            return;
        }

        String findID = courseUI.inputSearchID().toUpperCase();
        Course courseToFind = new Course(findID, null, 0);
        boolean isFound = course.find(courseToFind);

        if (isFound) {
            int index = course.indexOf(courseToFind);
            Course foundCourse = course.getEntry(index);

            if (foundCourse != null) {
                courseUI.printCourseFound(index, foundCourse);

                // Check if the course has programs
                if (!foundCourse.getPrograms().isEmpty()) {
                   displayProgramsInCourse(foundCourse.getCourseName(), foundCourse.getPrograms());
                }
            } else {
                courseUI.printCourseNotFound(findID);
            }
        } else {
            courseUI.printCourseNotFound(findID);
        }
    }

    private void findCourseByID() {
        String searchID = courseUI.inputSearchID().toUpperCase(); 
        boolean found = false;

        for (int i = 1; i <= course.getNumberOfEntries(); i++) {
            Course courseEntry = course.getEntry(i);
            if (courseEntry != null && courseEntry.getCourseID().toUpperCase().startsWith(searchID)) {
                if (!found) {
                    courseUI.printMatchingCoursesFound();
                    found = true;
                }
                courseUI.printMatchingCourse(courseEntry);
            }
        }

        if (!found) {
            courseUI.printNoMatchingCourses();
        }

        courseUI.printMatchingCoursesFooter();
    }

    private void findCourseByName() {
        String searchLetter = courseUI.inputSearchLetter().toUpperCase(); 
        boolean found = false;

        for (int i = 1; i <= course.getNumberOfEntries(); i++) {
            Course courseEntry = course.getEntry(i);
            if (courseEntry != null && courseEntry.getCourseName().toUpperCase().startsWith(searchLetter)) { 
                if (!found) {
                    courseUI.printMatchingCoursesFound();
                    found = true;
                }
                courseUI.printMatchingCourse(courseEntry);
            }
        }

        if (!found) {
            courseUI.printNoMatchingCourses();
        }

        courseUI.printMatchingCoursesFooter();
    }

    private void findCourseByCreditHour() {
        int searchCreditHour = courseUI.inputSearchCreditHour();
        boolean found = false;

        for (int i = 1; i <= course.getNumberOfEntries(); i++) {
            Course courseEntry = course.getEntry(i);
            if (courseEntry.getCreditHours() == searchCreditHour) {
                if (!found) {
                    courseUI.printMatchingCoursesFound();
                    found = true;
                }
                courseUI.printMatchingCourse(courseEntry);
            }
        }

        if (!found) {
            courseUI.printNoMatchingCourses();
        }

        courseUI.printMatchingCoursesFooter();
    }

    public void amendCourse() {
        if (course.isEmpty()) {
            courseUI.printNoCoursesToAmend();
            return;
        }

        String amendID = courseUI.inputCourseID(); // Ask the user for the course ID to amend
        int index = -1;

        // Check if the course exists in the list
        for (int i = 1; i <= course.getNumberOfEntries(); i++) {
            Course existingCourse = course.getEntry(i);
            if (existingCourse != null && existingCourse.getCourseID().equals(amendID)) {
                index = i;
                break;
            }
        }

        if (index != -1) {

            String newCourseName = null;
            int newCreditHours = 0;

            // Display the amendment menu
            int amendChoice;
            do {
                amendChoice = courseUI.getAmendMenuChoice();
                switch (amendChoice) {
                    case 1:
                        newCourseName = courseUI.inputCourseName();
                        break;
                    case 2:
                        newCreditHours = courseUI.inputCreditHours();
                        break;
                    case 3:
                        // Amend Programs
                        clearProgramsForCourse(index);
                        assignProgramsToCourse(course.getEntry(index));
                        break;
                    case 0:
                        break;
                    default:
                        MsgUI.InvalidChoice();
                }
            } while (amendChoice != 0);

            // Update the course with the amended details
            Course existingCourse = course.getEntry(index);
            if (newCourseName != null) {
                existingCourse.setCourseName(newCourseName);
            }
            if (newCreditHours != 0) {
                existingCourse.setCreditHours(newCreditHours);
            }
            courseDAO.saveToFile(course);

            courseUI.printCourseAmended(index, existingCourse);

            if (!existingCourse.getPrograms().isEmpty()) {
               displayProgramsInCourse(existingCourse.getCourseName(), existingCourse.getPrograms());
            }
        } else {
            // Course with the specified ID not found
            courseUI.printCourseNotFound(amendID);
        }
    }

    private void clearProgramsForCourse(int courseIndex) {
        Course courseToClear = course.getEntry(courseIndex);
        courseToClear.getPrograms().clear(); // Clears the programs for the specified course
    }

    public void assignProgramsToCourse() {
        if (course.isEmpty()) {
            courseUI.printNoCoursesToAssignPrograms();
            return;
        }

        String courseID = courseUI.inputCourseID();
        int index = course.indexOf(new Course(courseID, null, 0));

        if (index != -1) {
            Course courseToAssign = course.getEntry(index);

            courseUI.printAssignProgramsHeader(courseToAssign.getCourseName());

            SortedArrayListInterface<Program> assignedPrograms = courseToAssign.getPrograms();

            while (true) {
                int choice = courseUI.getProgramAssignmentChoice();

                switch (choice) {
                    case 1:
                        assignProgramToCourse(courseToAssign, assignedPrograms, "Software Engineers", "RSW");
                        break;
                    case 2:
                        assignProgramToCourse(courseToAssign, assignedPrograms, "Data Science", "DS");
                        break;
                    case 3:
                        assignProgramToCourse(courseToAssign, assignedPrograms, "Interactive Software Technology", "IST");
                        break;
                    case 4:
                        assignProgramToCourse(courseToAssign, assignedPrograms, "Network Engineering", "NE");
                        break;
                    case 5:
                        assignProgramToCourse(courseToAssign, assignedPrograms, "Computer Information Systems", "CIS");
                        break;
                    case 0:
                        courseUI.printAssignmentComplete();
                        courseDAO.saveToFile(course);
                        return;
                    default:
                        MsgUI.InvalidChoice();
                }
            }
        } else {
            courseUI.printCourseNotFound(courseID);
        }
    }

    public void assignProgramsToCourse(Course courseToAssign) {
        if (courseToAssign == null) {
            courseUI.printNoCoursesToAssignPrograms();
            return;
        }

        courseUI.printAssignProgramsHeader(courseToAssign.getCourseName());

        SortedArrayListInterface<Program> assignedPrograms = courseToAssign.getPrograms();

        while (true) {
            int choice = courseUI.getProgramAssignmentChoice();

            switch (choice) {
                case 1:
                    assignProgramToCourse(courseToAssign, assignedPrograms, "Software Engineers", "RSW");
                    break;
                case 2:
                    assignProgramToCourse(courseToAssign, assignedPrograms, "Data Science", "DS");
                    break;
                case 3:
                    assignProgramToCourse(courseToAssign, assignedPrograms, "Interactive Software Technology", "IST");
                    break;
                case 4:
                    assignProgramToCourse(courseToAssign, assignedPrograms, "Network Engineering", "NE");
                    break;
                case 5:
                    assignProgramToCourse(courseToAssign, assignedPrograms, "Computer Information Systems", "CIS");
                    break;
                case 0:
                    courseUI.printAssignmentComplete();
                    courseDAO.saveToFile(course);
                    return;
                case -1:
                default:
                    MsgUI.InvalidChoice();
            }
        }
    }

    private void assignProgramToCourse(Course course, SortedArrayListInterface<Program> assignedPrograms, String programName, String programID) {
        if (!isProgramAssigned(assignedPrograms, programName)) {
            Program program = new Program(programID, programName);
            course.addProgram(program);
            courseUI.printProgramAssigned(programName);
        } else {
            courseUI.printProgramAlreadyAssigned(programName);
        }
    }

    private boolean isProgramAssigned(SortedArrayListInterface<Program> assignedPrograms, String programName) {
        for (int i = 1; i <= assignedPrograms.getNumberOfEntries(); i++) {
            Program program = assignedPrograms.getEntry(i);
            if (program != null && program.getProgramName().equalsIgnoreCase(programName)) {
                return true;
            }
        }
        return false;
    }

    public void removeProgramToCourse() {
        if (course.isEmpty()) {
            courseUI.printNoCoursesToRemovePrograms();
            return;
        }

        String courseID = courseUI.inputCourseID();
        int index = course.indexOf(new Course(courseID, null, 0));

        if (index != -1) {
            Course courseToRemoveFrom = course.getEntry(index);

            while (true) {
                if (courseToRemoveFrom.getPrograms().isEmpty()) {
                    courseUI.printNoProgramsInCourse(courseToRemoveFrom.getCourseName());
                    break;
                }

               displayProgramsInCourse(courseToRemoveFrom.getCourseName(), courseToRemoveFrom.getPrograms());

                int programNumber = courseUI.getProgramRemovalChoice(courseToRemoveFrom.getPrograms().getNumberOfEntries());

                if (programNumber == 0) {
                    // Exit the loop and return to the main menu
                    break;
                }

                Program removedProgram = removeProgramFromCourse(courseToRemoveFrom, programNumber);

                if (removedProgram != null) {
                    courseUI.printProgramRemoved(removedProgram.getProgramName(), courseToRemoveFrom.getCourseName());
                } else {
                    courseUI.printInvalidProgramNumber();
                }
            }

            // Save changes to the file after removing programs
            courseDAO.saveToFile(course);
        } else {
            courseUI.printCourseNotFound(courseID);
        }
    }

    private Program removeProgramFromCourse(Course courseToRemoveFrom, int programNumber) {
        SortedArrayListInterface<Program> programs = courseToRemoveFrom.getPrograms();
        if (programNumber >= 1 && programNumber <= programs.getNumberOfEntries()) {
            return programs.remove(programNumber);
        }
        return null;
    }

      public void displayProgramsInCourse(String courseName, SortedArrayListInterface<Program> programs) {
       courseUI.printProgramsHeader(courseName);
        for (int i = 1; i <= programs.getNumberOfEntries(); i++) {
            Program program = programs.getEntry(i);
            courseUI.printProgram(i, program.getProgramName());
        }
    }
    
    public void generateReport() {
        if (course.isEmpty()) {
            courseUI.printCourseTableEmpty();
            return;
        }
        courseTable();

        calculateCreditHrs();
        assignedPrograms();
        generateCoursesPerProgramReport();
    }

    private int calculateTotalCreditHours() {
        int totalCreditHours = 0;
        for (int i = 1; i <= course.getNumberOfEntries(); i++) {
            Course nextCourse = course.getEntry(i);
            if (nextCourse != null) {
                totalCreditHours += nextCourse.getCreditHours();
            }
        }
        return totalCreditHours;
    }

    public void courseTable() {

        courseUI.printCourseTableHeader();

        for (int i = 1; i <= course.getNumberOfEntries(); i++) {
            Course nextCourse = course.getEntry(i);
            String programs = nextCourse.getPrograms().toString().replace(", ", "   ");
            if (nextCourse != null) {
                courseUI.printCourseTable(nextCourse.getCourseID(), nextCourse.getCourseName(), nextCourse.getCreditHours(), programs);
            }

        }
        courseUI.printCourseTableEnd();
    }

    public void calculateCreditHrs() {

        int totalCreditHours = calculateTotalCreditHours();
        courseUI.printTotalCreditHours(totalCreditHours);
    }

    public void assignedPrograms() {

        courseUI.printAssignedProgramsHeader();

        for (int i = 1; i <= course.getNumberOfEntries(); i++) {       // Print List of Programs with Assigned Courses
            Course nextCourse = course.getEntry(i);
            if (nextCourse != null) {
                courseUI.printAssignedPrograms(nextCourse.getCourseName(), nextCourse.getPrograms());
            }
        }
        courseUI.printAssignedProgramsEnd();
    }

    public void generateCoursesPerProgramReport() {

        courseUI.printCoursesPerProgramHeader();

        // Create a SortedArrayList to store the counted programs
        SortedArrayListInterface<String> countedPrograms = new SortedArrayList<>();

        for (int i = 1; i <= course.getNumberOfEntries(); i++) {         // Loop through courses
            Course nextCourse = course.getEntry(i);
            if (nextCourse != null) {
                SortedArrayListInterface<Program> programs = nextCourse.getPrograms();

                for (int j = 1; j <= programs.getNumberOfEntries(); j++) {               // Loop through programs in the course
                    Program program = programs.getEntry(j);
                    String programName = program.getProgramName();

                    if (!countedPrograms.contains(programName)) {      // Check if the program has already been counted
                        int courseCount = countCoursesForProgram(programName);
                        courseUI.printCoursesPerProgram(programName, courseCount);

                        countedPrograms.add(programName);     // Add the program to the SortedArrayList to avoid counting it again
                    }
                }
            }
        }

        courseUI.printCoursesPerProgramEnd();
    }

    private int countCoursesForProgram(String programNameToCount) {
        int courseCount = 0;
        for (int i = 1; i <= course.getNumberOfEntries(); i++) {
            Course nextCourse = course.getEntry(i);
            if (nextCourse != null) {
                SortedArrayListInterface<Program> programs = nextCourse.getPrograms();
                for (int j = 1; j <= programs.getNumberOfEntries(); j++) {
                    Program program = programs.getEntry(j);
                    if (program != null && programNameToCount.equals(program.getProgramName())) {
                        courseCount++;
                    }
                }
            }
        }
        return courseCount;
    }

    public void generateAssignedProgramsReport() {

        int totalCreditHours = calculateTotalCreditHours();
        courseUI.printTotalCreditHours(totalCreditHours);

        // Print List of Programs with Assigned Courses
        for (int i = 1; i <= course.getNumberOfEntries(); i++) {
            Course nextCourse = course.getEntry(i);
            if (nextCourse != null) {
               displayProgramsInCourse(nextCourse.getCourseName(), nextCourse.getPrograms());
            }
        }

    }

}
