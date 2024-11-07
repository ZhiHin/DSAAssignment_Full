package control;

import adt.*;
import boundary.TutorManagementUI;
import dao.*;
import entity.FullTimeTutor;
import entity.PartTimeTutor;
import entity.Tutor;
import java.util.Iterator;
import utility.Validation;

/**
 *
 * @author zhinf
 */
public class TutorManagement {

    private ListInterface<Tutor> tList = new ArrayList<>();
    private TutorDAO tutorDAO = new TutorDAO();
    private TutorManagementUI tutorUI = new TutorManagementUI();

    public TutorManagement() {
        tList = tutorDAO.retrieveFromFile();
    }

    public void runTutorManagement() {
        int choice = 0;
        do {
            choice = tutorUI.getMenuChoice();
            switch (choice) {
                case 0:
                    Validation.displayExitMessage();
                    break;
                case 1:
                    addNewTutor();
                    break;
                case 2:
                    displayTutors();
                    break;
                case 3:
                    removeTutorById();
                    break;
                case 4:
                    findTutor();
                    break;
                case 5:
                    ChangeTutorID();
                    break;
                case 6:
                    editTutor();
                    break;
                case 7:
                    filterTutors();
                    break;
                case 8:
                    generateReports();
                    break;
                default:
                    Validation.displayInvalidChoiceMessage();
            }
        } while (choice != 0);
    }

    public String getAllTutors() {
        String outputStr = "";
        for (int i = 1; i <= tList.getNumberOfEntries(); i++) {
            outputStr += tList.getEntry(i) + "\n";
        }
        return outputStr;
    }

    public String getAllFullTimeTutors() {
        String outputStr = "";
        for (int i = 1; i <= tList.getNumberOfEntries(); i++) {
            Tutor tutor = tList.getEntry(i);
            if (tutor instanceof FullTimeTutor) {
                outputStr += tutor + "\n";
            }
        }
        return outputStr;
    }

    public String getAllPartTimeTutors() {
        String outputStr = "";
        for (int i = 1; i <= tList.getNumberOfEntries(); i++) {
            Tutor tutor = tList.getEntry(i);
            if (tutor instanceof PartTimeTutor) {
                outputStr += tutor + "\n";
            }
        }
        return outputStr;
    }

    public void displayAllTutors() {
        tutorUI.listPtTutor(getAllPartTimeTutors());
        tutorUI.listFtTutor(getAllFullTimeTutors());
    }

    public void displayTutors() {
        int typeSelected = 0;
        do {
            typeSelected = tutorUI.getTutorTypeChoice();
            switch (typeSelected) {
                case 0:
                    Validation.displayExitMessage();
                    break;
                case 1:
                    tutorUI.listPtTutor(getAllPartTimeTutors());
                    break;
                case 2:
                    tutorUI.listFtTutor(getAllFullTimeTutors());
                    break;
                case 3:
                    displayAllTutors();
                    break;
                default:
                    Validation.displayInvalidChoiceMessage();
            }
        } while (typeSelected != 0);
    }

    public void addNewTutor() {
        int tutorType = 0;
        tutorType = tutorUI.getTutorTypeChoice();

        if (tutorType == 1) {// partTime
            PartTimeTutor newTutor = (PartTimeTutor) tutorUI.inputPTtutorDetails();

            // Check for duplicates by comparing IDs
            for (int i = 1; i <= tList.getNumberOfEntries(); i++) {
                Tutor existingTutor = tList.getEntry(i);
                if (existingTutor.getID().equals(newTutor.getID())) {
                    System.out.println("Tutor with ID " + newTutor.getID() + " already exists.");
                    String userResponse = tutorUI.inputRespond();
                    if (userResponse.equalsIgnoreCase("yes")) {
                        addNewTutor(); // Re-enter tutor details
                        tutorDAO.saveToFile(tList);
                    }
                    return;
                }
            }
            tList.add(newTutor);
            tutorDAO.saveToFile(tList);

            String additionalInfoResponse = tutorUI.inputAdditionalRespond();
            if (additionalInfoResponse.equalsIgnoreCase("yes")) {
                newTutor.setSemester(tutorUI.inputSemester());
                newTutor.setFaculty(tutorUI.inputFaculty());
                newTutor.setCourse(tutorUI.inputCourse());
                
                tutorDAO.saveToFile(tList);
                System.out.println("Tutor with ID " + newTutor.getID() + " added successfully.");
            }
        } else if (tutorType == 2) {// fullTime
            FullTimeTutor newTutor = (FullTimeTutor) tutorUI.inputFTtutorDetails(); // You'll need a method to input full-time tutor details

            for (int i = 1; i <= tList.getNumberOfEntries(); i++) {
                Tutor existingTutor = tList.getEntry(i);
                if (existingTutor.getID().equals(newTutor.getID())) {
                    System.out.println("Tutor with ID " + newTutor.getID() + " already exists.");
                    String userResponse = tutorUI.inputRespond();
                    if (userResponse.equalsIgnoreCase("yes")) {
                        addNewTutor();
                        tutorDAO.saveToFile(tList);
                    }
                    return;
                }
            }
            tList.add(newTutor);
            tutorDAO.saveToFile(tList);

            // Ask the user if they want to input additional information
            String additionalInfoResponse = tutorUI.inputAdditionalRespond();
            if (additionalInfoResponse.equalsIgnoreCase("yes")) {
                newTutor.setSemester(tutorUI.inputSemester());
                newTutor.setFaculty(tutorUI.inputFaculty());
                newTutor.setCourse(tutorUI.inputCourse());

                tutorDAO.saveToFile(tList);
                System.out.println("Tutor with ID " + newTutor.getID() + " added successfully.");
            }
        } else {
            Validation.displayInvalidChoiceMessage();
        }
        displayAllTutors();
    }

    public void removeTutorById() {
        displayAllTutors();

        String tutorId = tutorUI.inputTutorID();

        if (tList.isEmpty()) {
            System.out.println("Tutor list is empty.");
            return;
        }
        for (int position = 1; position <= tList.getNumberOfEntries(); position++) {
            Tutor tutor = tList.getEntry(position);
            if (tutor.getID().equals(tutorId)) {

                tList.remove(position);
                System.out.println("Tutor with ID " + tutorId + " has been removed from position " + position + ".");
                //save the updated list to a file here
                tutorDAO.saveToFile(tList);

                // Check if the list is empty after removal
                if (tList.isEmpty()) {
                    System.out.println("No more tutors in the list.");
                } else {
                    // Display the remaining tutor data
                    System.out.println("\nRemove successful!!!");
                    displayAllTutors();
                }
                return;
            }
        }
        System.out.println("No tutor with ID " + tutorId + " found.");
    }

    public void findTutor() {
        String criteria = tutorUI.inputFindTutor();

        // Flags to track if any matching tutors were found
        boolean foundFullTime = false;
        boolean foundPartTime = false;

        for (int position = 1; position <= tList.getNumberOfEntries(); position++) {
            Tutor tutor = tList.getEntry(position);
            // Check if the tutor matches the criteria based on ID, name, email, or contact number
            if (tutor.getID().equals(criteria)
                    || tutor.getTutorName().equalsIgnoreCase(criteria)
                    || tutor.getEmail().equalsIgnoreCase(criteria)
                    || tutor.getContactNo().equals(criteria)) {

                if (tutor instanceof FullTimeTutor) {
                    foundFullTime = true;
                    System.out.println("Full-Time Tutor matching criteria " + criteria + " found:");
                    tutorUI.listFtTutor("");
                    System.out.println(tutor);
                } else if (tutor instanceof PartTimeTutor) {
                    foundPartTime = true;
                    System.out.println("Part-Time Tutor matching criteria " + criteria + " found:");
                    tutorUI.listPtTutor("");
                    System.out.println(tutor);
                }
            }
        }
        if (!foundFullTime && !foundPartTime) {
            System.out.println("No tutors matching criteria " + criteria + " found.");
        }
    }

    public void ChangeTutorID() {
        // Get user input for the Tutor ID to amend
        String tutorIdToAmend = tutorUI.inputTutorID();

        // Find the index of the tutor with the given ID
        int indexToAmend = -1;
        for (int i = 1; i <= tList.getNumberOfEntries(); i++) {
            Tutor tutor = tList.getEntry(i);
            if (tutor != null && tutor.getID().equals(tutorIdToAmend)) {
                indexToAmend = i;
                break;
            }
        }

        if (indexToAmend != -1) {
            String newTutorID = tutorUI.inputNewTutorID();
            
            // Check for duplicates by comparing IDs
            for (int i = 1; i <= tList.getNumberOfEntries(); i++) {
                Tutor existingTutor = tList.getEntry(i);
                if (existingTutor.getID().equals(newTutorID)) {
                    System.out.println("Tutor with ID " + newTutorID + " already exists.");
                    String userResponse = tutorUI.inputIDRespond();
                    if (userResponse.equalsIgnoreCase("yes")) {
                        ChangeTutorID(); // Re-enter tutor ID
                        tutorDAO.saveToFile(tList);
                    }
                    return;
                }
            }

            // Remove the old tutor
            Tutor oldTutor = tList.remove(indexToAmend);

            // Set the new Tutor ID
            oldTutor.setId(newTutorID);

            // Reinsert the tutor into its correct position
            int newIndex = -1;
            for (int i = 1; i <= tList.getNumberOfEntries(); i++) {
                if (newTutorID.compareTo(tList.getEntry(i).getID()) < 0) {
                    newIndex = i;
                    break;
                }
            }
            if (newIndex == -1) {
                tList.add(oldTutor); 
            } else {
                tList.add(newIndex, oldTutor); 
            }
            tutorDAO.saveToFile(tList);
            System.out.println("Tutor with ID " + tutorIdToAmend + " has been successfully renamed to " + newTutorID);
        } else {
            System.out.println("Tutor with ID " + tutorIdToAmend + " not found.");
        }
    }

    public void editTutor() {

        String tutorIdToEdit = tutorUI.inputTutorID();

        int indexToEdit = -1;
        for (int i = 0; i < tList.getNumberOfEntries(); i++) {
            Tutor tutor = tList.getEntry(i);
            if (tutor != null && tutor.getID().equals(tutorIdToEdit)) {
                indexToEdit = i;
                break;
            }
        }

        if (indexToEdit != -1) {
            Tutor existingTutor = tList.getEntry(indexToEdit);

            if (existingTutor instanceof PartTimeTutor) {
                PartTimeTutor partTimeTutor = (PartTimeTutor) existingTutor;

                int editChoice = 0;
                do {
                    editChoice = tutorUI.getPtEditChoice();
                    switch (editChoice) {
                        case 0:
                            Validation.displayExitMessage();
                            break;
                        case 1:
                            // Edit name
                            String newName = tutorUI.inputNewTutorName();
                            partTimeTutor.setTutorName(newName);
                            break;
                        case 2:
                            // Edit age
                            int newAge = tutorUI.inputNewAge();
                            partTimeTutor.setAge(newAge);
                            break;
                        case 3:
                            // Edit Gender
                            String newGender = tutorUI.inputNewGender();
                            partTimeTutor.setGender(newGender);
                            break;
                        case 4:
                            // Edit email
                            String newEmail = tutorUI.inputNewEmail();
                            partTimeTutor.setEmail(newEmail);
                            break;
                        case 5:
                            // Edit contact number
                            String newContactNo = tutorUI.inputNewContactNumber();
                            partTimeTutor.setContactNo(newContactNo);
                            break;
                        case 6:
                            // Edit semester
                            int newSemester = tutorUI.inputNewSemester();
                            partTimeTutor.setSemester(newSemester);
                            break;
                        case 7:
                            // Edit Faculty
                            String newFaculty = tutorUI.inputNewFaculty();
                            partTimeTutor.setContactNo(newFaculty);
                            break;
                        case 8:
                            // Edit Course
                            String newCourse = tutorUI.inputNewCourse();
                            partTimeTutor.setContactNo(newCourse);
                            break;
                        case 9:
                            // Edit salary per hour
                            double newSalaryPerHour = tutorUI.inputNewSalaryPerHour();
                            partTimeTutor.setSalaryPerHour(newSalaryPerHour);
                            break;
                        case 10:
                            // Edit working hours
                            int newWorkingHours = tutorUI.inputNewWorkingHours();
                            partTimeTutor.setWorkingHours(newWorkingHours);
                            break;
                        case 11:
                            // Edit overtime
                            double newOverTimePayRate = tutorUI.inputNewOverTimeRate();
                            partTimeTutor.setOverTimePayRate(newOverTimePayRate);
                            break;
                        case 12:
                            // Edit overtime hour
                            double newOveTime = tutorUI.inputNewOverTime();
                            partTimeTutor.setOverTime(newOveTime);
                            break;
                        default:
                            Validation.displayInvalidChoiceMessage();
                    }
                } while (editChoice != 0);

                // Use the replace method to update the entire part-time tutor object in the list
                tList.replace(indexToEdit, partTimeTutor);
                tutorDAO.saveToFile(tList);
            } else if (existingTutor instanceof FullTimeTutor) {
                FullTimeTutor fullTimeTutor = (FullTimeTutor) existingTutor;

                int editChoice = 0;
                do {
                    editChoice = tutorUI.getFtEditChoice();
                    switch (editChoice) {
                        case 0:
                            Validation.displayExitMessage();
                            break;
                        case 1:
                            // Edit name
                            String newName = tutorUI.inputNewTutorName();
                            fullTimeTutor.setTutorName(newName);
                            break;
                        case 2:
                            // Edit age
                            int newAge = tutorUI.inputNewAge();
                            fullTimeTutor.setAge(newAge);
                            break;
                        case 3:
                            // Edit Gender
                            String newGender = tutorUI.inputNewGender();
                            fullTimeTutor.setGender(newGender);
                            break;
                        case 4:
                            // Edit email
                            String newEmail = tutorUI.inputNewEmail();
                            fullTimeTutor.setEmail(newEmail);
                            break;
                        case 5:
                            // Edit contact number
                            String newContactNo = tutorUI.inputNewContactNumber();
                            fullTimeTutor.setContactNo(newContactNo);
                            break;
                        case 6:
                            // Edit semester
                            int newSemester = tutorUI.inputNewSemester();
                            fullTimeTutor.setSemester(newSemester);
                            break;
                        case 7:
                            // Edit Faculty
                            String newFaculty = tutorUI.inputNewFaculty();
                            fullTimeTutor.setContactNo(newFaculty);
                            break;
                        case 8:
                            // Edit Course
                            String newCourse = tutorUI.inputNewCourse();
                            fullTimeTutor.setContactNo(newCourse);
                            break;
                        case 9:
                            // Edit basic salary
                            double newBasicSalary = tutorUI.inputNewBasicSalary();
                            fullTimeTutor.setBasicSalary(newBasicSalary);
                            break;
                        case 10:
                            // Edit allowance
                            double newAllowance = tutorUI.inputNewAllowance();
                            fullTimeTutor.setAllowance(newAllowance);
                            break;
                        default:
                            Validation.displayInvalidChoiceMessage();
                    }
                } while (editChoice != 0);

                tList.replace(indexToEdit, fullTimeTutor);
                tutorDAO.saveToFile(tList);
            }
            System.out.println("Tutor with ID " + tutorIdToEdit + " details amended successfully.");
        } else {
            System.out.println("Tutor with ID " + tutorIdToEdit + " not found.");
        }
    }

    ListInterface<Tutor> filteredList = new ArrayList<>();

    public String getAllTutorsFilter() {
        String outputStr = "";
        for (int i = 1; i <= filteredList.getNumberOfEntries(); i++) {
            outputStr += filteredList.getEntry(i) + "\n";
        }
        return outputStr;
    }

    public String getAllFullTimeTutorsFilter() {
        String outputStr = "";
        for (int i = 1; i <= filteredList.getNumberOfEntries(); i++) {
            Tutor tutor = filteredList.getEntry(i);
            if (tutor instanceof FullTimeTutor) {
                outputStr += tutor + "\n";
            }
        }
        return outputStr;
    }

    public String getAllPartTimeTutorsFilter() {
        String outputStr = "";
        for (int i = 1; i <= filteredList.getNumberOfEntries(); i++) {
            Tutor tutor = filteredList.getEntry(i);
            if (tutor instanceof PartTimeTutor) {
                outputStr += tutor + "\n";
            }
        }
        return outputStr;
    }

    public void filterTutors() {
        int filterChoice = tutorUI.getFilterChoice();
        filteredList.clear();

        switch (filterChoice) {
            case 0:
                Validation.displayExitMessage();
                break;
            case 1:
                // Filter by Age
                int minAge = tutorUI.inputMinAge();
                int maxAge = tutorUI.inputMaxAge();

                for (int i = 1; i <= tList.getNumberOfEntries(); i++) {
                    Tutor tutor = tList.getEntry(i);
                    if (tutor.getAge() >= minAge && tutor.getAge() <= maxAge) {
                        filteredList.add(tutor);
                    }
                }
                break;
            case 2:
                // Filter by Gender
                String gender = tutorUI.inputGender();

                for (int i = 1; i <= tList.getNumberOfEntries(); i++) {
                    Tutor tutor = tList.getEntry(i);
                    if (tutor.getGender().equalsIgnoreCase(gender)) {
                        filteredList.add(tutor);
                    }
                }
                break;
            case 3:
                // Filter by Semester
                int semester = tutorUI.inputSemester();

                for (int i = 1; i <= tList.getNumberOfEntries(); i++) {
                    Tutor tutor = tList.getEntry(i);
                    if (tutor.getSemester() == semester) {
                        filteredList.add(tutor);
                    }
                }
                break;
            case 4:
                // Filter by Faculty
                String faculty = tutorUI.inputFaculty();

                for (int i = 1; i <= tList.getNumberOfEntries(); i++) {
                    Tutor tutor = tList.getEntry(i);
                    if (tutor.getFaculty().equalsIgnoreCase(faculty)) {
                        filteredList.add(tutor);
                    }
                }
                break;
            case 5:
                // Filter by Course
                String course = tutorUI.inputCourse();

                for (int i = 1; i <= tList.getNumberOfEntries(); i++) {
                    Tutor tutor = tList.getEntry(i);
                    if (tutor.getCourse().equalsIgnoreCase(course)) {
                        filteredList.add(tutor);
                    }
                }
                break;
            case 6:
                // Filter by Tutor Type
                int tutorType = tutorUI.getTutorTypeChoice();

                for (int i = 1; i <= tList.getNumberOfEntries(); i++) {
                    Tutor tutor = tList.getEntry(i);
                    if ((tutorType == 1 && tutor instanceof PartTimeTutor)
                            || (tutorType == 2 && tutor instanceof FullTimeTutor)) {
                        filteredList.add(tutor);
                    }
                }
                break;
            default:
                Validation.displayInvalidChoiceMessage();
                return;
        }

        // Display the filtered list
        if (filteredList.isEmpty()) {
            System.out.println("No tutors match the filter criteria.");
        } else {
            System.out.println("Filtered Tutor List:");
            tutorUI.listPtTutor(getAllPartTimeTutorsFilter());
            tutorUI.listFtTutor(getAllFullTimeTutorsFilter());
        }
    }

    public void generateReports() {

        double totalPayroll = 0.0;
        Iterator<Tutor> iterator = tList.getIterator();

        System.out.println("List of All Tutors:");
        displayAllTutors();

        System.out.println("\n\nList of Salary Details: ");
        tutorUI.displaySalaryDetails();

        while (iterator.hasNext()) {
            Tutor tutor = iterator.next();

            double tutorSalary = 0.0;
            if (tutor instanceof PartTimeTutor) {
                PartTimeTutor partTimeTutor = (PartTimeTutor) tutor;
                tutorSalary = partTimeTutor.salaryPay();
                System.out.println(String.format("%-8s %-20s %-16.2f %-20.2f %-16.2f", tutor.getID(), tutor.getTutorName(), partTimeTutor.normalSalary(), partTimeTutor.overTimePay(), tutorSalary));
            } else if (tutor instanceof FullTimeTutor) {
                FullTimeTutor fullTimeTutor = (FullTimeTutor) tutor;
                tutorSalary = fullTimeTutor.salaryPay();
                System.out.println(String.format("%-8s %-20s %-16.2f %-20.2f %-16.2f", tutor.getID(), tutor.getTutorName(), fullTimeTutor.getBasicSalary(), fullTimeTutor.getAllowance(), tutorSalary));
            }
            totalPayroll += tutorSalary;
        }

        int totalTutors = tList.getNumberOfEntries();
        System.out.println("\n\nTotal Number of Tutors: " + totalTutors);

        System.out.printf("Total Payroll: RM %.2f\n", totalPayroll);
    }

    public static void main(String[] args) {
        TutorManagement tutorManagement = new TutorManagement();
        tutorManagement.runTutorManagement();
    }
}

