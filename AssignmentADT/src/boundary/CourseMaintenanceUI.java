/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import entity.Course;
import entity.Program;
import java.util.Scanner;
import adt.SortedArrayListInterface;

/**
 *
 * @author Dickie Wong Wei Hao
 */
public class CourseMaintenanceUI {

    /**
     * ******************************* DISPLAY MENU
     * ***********************************
     */
    Scanner scanner = new Scanner(System.in);

    public int getMenuChoice() {
        System.out.println("\n\n====================MAIN MENU====================");
        System.out.println("=================================================");
        System.out.println(" [1] Add new course");
        System.out.println(" [2] List all courses");
        System.out.println(" [3] Remove a courses");
        System.out.println(" [4] Find a courses");
        System.out.println(" [5] Ammend a courses");
        System.out.println(" [6] Add Programme to a course");
        System.out.println(" [7] Remove Programme from a course");
        System.out.println(" [8] Generate Report");
        System.out.println(" [9] Clear all courses");
        System.out.println(" [0] Quit");
        System.out.println("=================================================\n");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;
    }

    /**
     * ******************************* ADD COURSE
     * ***********************************
     */
    public void printCourseAdded(String courseID) {
        System.out.println("Course with ID " + courseID + " has been added.");
    }

    public void printCourseIDAlreadyExists(String courseID) {
        System.out.println("Error: Course with ID " + courseID + " already exists.");
    }

    /**
     * ******************************* LIST ALL COURSE
     * ***********************************
     */
    public void listAllCourses(String outputStr) {

        System.out.println("\n\n\nList of Courses:\n" + outputStr);

        System.out.printf("\n\n\n");
    }

    /**
     * ******************************* REMOVE COURSE
     * ***********************************
     */
    public int removeMenu() {
        System.out.println("1. Remove By Index");
        System.out.println("2. Remove By ID");
        System.out.println("Please select your preferred removal method:");
        int removalMethod = scanner.nextInt();
        scanner.nextLine();

        return removalMethod;

    }

    public void printNoCoursesToRemove() {
        System.out.println("\nNo courses to remove. The course list is empty.");
    }

    public void printCourseRemoved(int index, Course removedCourse) {
        System.out.println("Course at index " + index + " has been removed:");
        System.out.println(removedCourse);
    }

    public void printFailedToRemoveCourse(int index) {
        System.out.println("Failed to remove course at index " + index + ".");
    }

    public void printCourseRemoved(String courseID, Course removedCourse) {
        System.out.println("Course with courseID " + courseID + " has been removed.");
        System.out.println(removedCourse);
    }

    public void printFailedToRemoveCourse(String courseID) {
        System.out.println("Failed to remove course with courseID " + courseID + ".");
    }

    public void printInvalidIndex() {
        System.out.println("Invalid index. No course removed.");
    }

    /**
     * ******************************* FIND COURSE
     * ***********************************
     */
    public void printNoCoursesToSearch() {
        System.out.println("No courses to search. The course list is empty.");
    }

    public void printCourseFound(int index, Course foundCourse) {
        System.out.println("\nCourse Found at Index " + index + ":\n");
        System.out.printf("Course ID:     %-10s%n", foundCourse.getCourseID());
        System.out.printf("Course Name:   %-10s%n", foundCourse.getCourseName());
        System.out.printf("Credit Hours:  %-10d%n", foundCourse.getCreditHours());
    }

    public void printCourseNotFound(String findID) {
        System.out.println("No course with courseID " + findID + " found.");
    }

    public int getFindCourseOption() {
        System.out.println("Select method to find: ");
        System.out.println("1. Find Course ID");
        System.out.println("2. Find Course ID (Detailed)");
        System.out.println("3. Find Course Name");
        System.out.println("4. Find Credit Hour");
        System.out.println("0. Cancel Find Course");
        System.out.print("Select an option to find a course: ");
        return scanner.nextInt();
    }

    public String inputSearchID() {
        System.out.print("Enter the ID to search for a course: ");
        return scanner.next().toUpperCase();
    }

    public String inputSearchLetter() {
        System.out.print("Enter the letter to search for a course: ");
        return scanner.next().toUpperCase();
    }

    public int inputSearchCreditHour() {
        System.out.print("Enter the number of credit hours to search for a course: ");
        return scanner.nextInt();
    }

    public void printMatchingCoursesFound() {
        System.out.println("\nMatching Courses:");
    }

    public void printMatchingCourse(Course course) {
        // Print the details of a matching course
        System.out.println(course);
    }

    public void printNoMatchingCourses() {
        System.out.println("\nNo courses with the specified credit hours found.");
    }

    public void printMatchingCoursesFooter() {
        System.out.println("===================================================");
    }

    public void printFindCourseCancelled() {
        System.out.println("Find course has been cancelled.");
    }

    public void printInvalidInput() {
        System.out.println("Invalid input.");
    }

    public void printEmptyCourseList() {
        System.out.println("The course list is empty.");
    }

    /**
     * ******************************* AMMEND COURSE
     * ***********************************
     */
    public void printCourseAmended(int index, Course updatedCourse) {
        System.out.println("\nCourse at index " + index + " has been successfully amended to:\n");
        System.out.printf("Course ID:     %-10s%n", updatedCourse.getCourseID());
        System.out.printf("Course Name:   %-10s%n", updatedCourse.getCourseName());
        System.out.printf("Credit Hours:  %-10d%n", updatedCourse.getCreditHours());
    }

    public void printNoCoursesToAmend() {
        System.out.println("No courses to amend. The course list is empty.");
    }

    public int getAmendMenuChoice() {
        System.out.println("\n\nAmend Course Menu:");
        System.out.println("1. Change Course Name");
        System.out.println("2. Change Credit Hours");
        System.out.println("3. Reassign Programme");
        System.out.println("0. Exit ");
        System.out.print("Enter your choice: ");

        int choice;
        try {
            choice = scanner.nextInt();
        } catch (java.util.InputMismatchException e) {

            scanner.nextLine();     // Handle invalid input (non-integer)
            choice = -1;
        }
        scanner.nextLine();

        return choice;
    }

    /**
     * ******************************* ADD PROGRAMME
     * ***********************************
     */
    public void printNoCoursesToAssignPrograms() {
        System.out.println("No courses to assign programmes. The course list is empty.");
    }

    public void printAssignProgramsHeader(String courseName) {
        System.out.println("\n\nAssign Programmes to Course(" + courseName + ")");
        System.out.println("1. Software Engineers (RSW)");
        System.out.println("2. Data Science (DS)");
        System.out.println("3. Interactive Software Technology (IST)");
        System.out.println("4. Network Engineering (NE)");
        System.out.println("5. Computer Information Systems (CIS)");
        System.out.println("0. Done");
    }

    public int getProgramAssignmentChoice() {
        System.out.print("Enter your choice (0 to exit): ");
        String input = scanner.nextLine();

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void printProgramAssigned(String programName) {
        System.out.println("\n" + programName + " programme assigned to the course.");
    }

    public void printProgramAlreadyAssigned(String programName) {
        System.out.println("\n" + programName + " programme is already assigned to the course.");
    }

    public void printAssignmentComplete() {
        System.out.println("\nProgramme Assigned Successfully");
    }

    /**
     * ******************************* REMOVE PROGRAMME
     * ***********************************
     */
    public void printNoCoursesToRemovePrograms() {
        System.out.println("No courses to remove programmes. The course list is empty.");
    }

//    public void printProgramsInCourse(String courseName, SortedArrayListInterface<Program> programs) {
//        System.out.println("\nProgrammes in " + courseName + ":");
//        for (int i = 1; i <= programs.getNumberOfEntries(); i++) {
//            Program program = programs.getEntry(i);
//            System.out.println(i + ". " + program.getProgramName());
//        }
//    }
    public void printProgramsHeader(String courseName) {
        System.out.println("\nProgrammes in " + courseName + ":");
    }

    public void printProgram(int index, String programName) {
        System.out.println(index + ". " + programName);
    }

    public int getProgramRemovalChoice(int maxChoice) {
        int programNumber;
        while (true) {
            System.out.print("Enter the programme number to remove (Exit[0]/" + maxChoice + "): ");
            programNumber = scanner.nextInt();
            scanner.nextLine();

            if (programNumber >= 0 && programNumber <= maxChoice) {
                return programNumber;
            } else {
                System.out.println("Invalid programme number. Please try again.");
            }
        }
    }

    public void printInvalidProgramNumber() {
        System.out.println("Invalid programme number.");
    }

    public void printNoProgramsInCourse(String courseName) {
        System.out.println("No programmes in " + courseName);
    }

    public void printProgramRemoved(String programName, String courseName) {
        System.out.println(programName + " removed from " + courseName);
    }

    /**
     * ******************************* COURSE TABLE
     * ***********************************
     */
    public void printCourseTableHeader() {
        System.out.println("Course Table:");
        System.out.println("+-----------------+----------------------+-----------------+-----------------+-----------------+");
        System.out.println("|   Course ID     |    Course Name       |   Credit Hours  |             Programme             |");
        System.out.println("+-----------------+----------------------+-----------------+-----------------+-----------------+");
    }

    public void printCourseTableEmpty() {
        System.out.println("No Courses to display.");
    }

    public void printCourseTable(String courseID, String courseName, int creditHours, String programs) {

        System.out.printf("   %-12s      %-20s   %-12d      %-25s \n",
                courseID, courseName, creditHours, programs);

    }

    public void printCourseTableEnd() {
        System.out.println("+-----------------+----------------------+-----------------+-----------------------------------+");
    }

    public void printTotalCreditHours(int totalCreditHours) {
        System.out.println("\nTotal Credit Hours: " + totalCreditHours + "\n");
    }

    /**
     * ******************************* PROGRAMME WITH COURSE NO TABLE
     * ***********************************
     */
    public void printCoursesPerProgramEmpty() {
        System.out.println("No Prgramme to display.");
    }

    public void printCoursesPerProgramHeader() {
        System.out.println("\n\n\n+-----------------+-----------------+--------------------+");
        System.out.println("|          Programme Name           |  Number of Courses |");
        System.out.println("+-----------------+-----------------+--------------------+");
    }

    public void printCoursesPerProgram(String programName, int courseCount) {

        // Print program name and number of courses
        System.out.printf(" %-34s | %2d \n", programName, courseCount);

    }

    public void printCoursesPerProgramEnd() {
        System.out.println("+-----------------+-----------------+--------------------+");
    }

    /**
     * ******************************* COURSE WITH ASSIGNED PROGRAMME TABLE
     * ***********************************
     */
    public void printAssignedProgramsHeader() {
        System.out.println("+----------------------+------------------------------+");
        System.out.println("|      Course Name     |      Assigned Programmes     |");
        System.out.println("+----------------------+------------------------------+");
    }

    public void printAssignedProgramsEnd() {
        System.out.println("+----------------------+------------------------------+");
    }

    public void printAssignedPrograms(String courseName, SortedArrayListInterface<Program> programs) {
        // Print course name and assigned programs
        String formattedPrograms = programs.toString().replace(", ", "   ");
        System.out.printf(" %-20s  | %-20s \n", courseName, formattedPrograms);
    }

    /**
     * ******************************* INPUT UI
     * ***********************************
     */
    public String inputCourseID() {
        String courseID;
        do {
            System.out.print("\nEnter Course ID:    ");
            courseID = scanner.nextLine();
            courseID = courseID.toUpperCase();
            if (courseID == null || courseID.trim().isEmpty()) {
                System.out.println("Course ID cannot be empty or null.\n");
            } else {
                break;
            }
        } while (true);
        return courseID;
    }

    public int inputIndex() {
        int courseIndex = -1;
        do {
            System.out.print("\nEnter Index:    ");
            courseIndex = scanner.nextInt();
            if (courseIndex == -1) {
                System.out.println("Index cannot be empty or null.\n");
            } else {
                break;
            }
        } while (true);
        return courseIndex;
    }

    public String inputCourseName() {
        String courseName;
        do {
            System.out.print("\nEnter Course Name:  ");
            courseName = scanner.nextLine();
            if (courseName == null || courseName.trim().isEmpty()) {
                System.out.println("Course name cannot be empty or null.\n");
            } else {
                break;
            }
        } while (true);
        return courseName;
    }

    public int inputCreditHours() {
        int creditHrs;

        do {
            System.out.print("\nEnter Credit Hours: ");
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                System.out.println("Credit hours cannot be empty.");
                continue;
            }

            try {
                creditHrs = Integer.parseInt(input);

                if (creditHrs <= 0) {
                    System.out.println("Invalid credit hours. Please enter a positive integer.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer for credit hours.");
            }
        } while (true);

        return creditHrs;
    }

    public Course inputCourseDetails() {
        String courseID = inputCourseID();
        String courseName = inputCourseName();
        int creditHours = inputCreditHours();
        System.out.println();
        return new Course(courseID, courseName, creditHours);
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
}
