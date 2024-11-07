/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import entity.FilterOption;
import entity.Student;
import entity.TutorialGroup;
import static entity.TutorialGroup.numberOfGroup;
import adt.HashMap;
import adt.HashMapInterface;
import java.util.Scanner;
import boundary.TutorialGroupMaintenanceUI;
import utility.messageUI;

/**
 *
 * @author tkair
 */
public class TutorialGroupMaintenance {

    Scanner scanner = new Scanner(System.in);
    TutorialGroupMaintenanceUI tutoGroupUI = new TutorialGroupMaintenanceUI();
    messageUI messageUI = new messageUI();
    HashMapInterface<String, TutorialGroup> tutoGroupList = new HashMap<>();
    TutorialGroup tutorialGroupTemp;
    String studentIdInput = null;
    HashMap.Entry<String, TutorialGroup>[] entries = null;

    public static void main(String[] args) {
        TutorialGroupMaintenance tutoGroupMain = new TutorialGroupMaintenance();
        tutoGroupMain.runMaintenance();
    }

    public void runMaintenance() {
        Scanner scanner = new Scanner(System.in);
        initializeData();

        
        while (true) {
            studentIdInput = null;
            tutorialGroupTemp = null;
            entries = null;
            int choice = tutoGroupUI.getMenuChoice();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2: {
                    removeStudent();
                }
                break;
                case 3: {
                    changeTutorialGroup();
                }
                break;

                case 4: {
                    listAllStudent();
                }
                break;
                case 5: {
                    generateReport();

                }
                break;
                case 6:
                    findStudent();
                    break;
                case 7: {
                    filterStudent();
                }
                break;
                case 8:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        }

    }

    private void initializeData() {
        //Initialize data
        tutoGroupList.add("G" + (numberOfGroup + 1), new TutorialGroup());
        tutoGroupList.add("G" + (numberOfGroup + 1), new TutorialGroup());
        tutoGroupList.add("G" + (numberOfGroup + 1), new TutorialGroup());
        tutoGroupList.add("G" + (numberOfGroup + 1), new TutorialGroup());

        TutorialGroup tutorialGroupTemp1 = tutoGroupList.getValue("G1");
        tutorialGroupTemp1.addStudent(new Student("2203901", "Olivia", "Female", 3.8, tutorialGroupTemp1.getGroupId()));
        tutorialGroupTemp1.addStudent(new Student("2203902", "Liam", "Male", 3.9, tutorialGroupTemp1.getGroupId()));
        tutorialGroupTemp1.addStudent(new Student("2203903", "Ava", "Female", 3.5, tutorialGroupTemp1.getGroupId()));
        tutorialGroupTemp1.addStudent(new Student("2203904", "Noah", "Male", 3.7, tutorialGroupTemp1.getGroupId()));
        tutorialGroupTemp1.addStudent(new Student("2203905", "Isabella", "Female", 3.6, tutorialGroupTemp1.getGroupId()));
        tutorialGroupTemp1.addStudent(new Student("2203906", "James", "Male", 3.8, tutorialGroupTemp1.getGroupId()));
        tutorialGroupTemp1.addStudent(new Student("2203907", "Charlotte", "Female", 3.9, tutorialGroupTemp1.getGroupId()));
        tutorialGroupTemp1.addStudent(new Student("2203908", "Benjamin", "Male", 3.7, tutorialGroupTemp1.getGroupId()));
        tutorialGroupTemp1.addStudent(new Student("2203909", "Mia", "Female", 3.5, tutorialGroupTemp1.getGroupId()));
        tutorialGroupTemp1.addStudent(new Student("2203910", "Elijah", "Male", 3.6, tutorialGroupTemp1.getGroupId()));

        TutorialGroup tutorialGroupTemp2 = tutoGroupList.getValue("G2");
        tutorialGroupTemp2.addStudent(new Student("2103971", "Aiden", "Male", 3.7, tutorialGroupTemp2.getGroupId()));
        tutorialGroupTemp2.addStudent(new Student("2103962", "Sophia", "Female", 3.3, tutorialGroupTemp2.getGroupId()));
        tutorialGroupTemp2.addStudent(new Student("2103923", "Jackson", "Male", 2.9, tutorialGroupTemp2.getGroupId()));
        tutorialGroupTemp2.addStudent(new Student("2103914", "Mia", "Female", 3.5, tutorialGroupTemp2.getGroupId()));
        tutorialGroupTemp2.addStudent(new Student("2103905", "Liam", "Male", 2.2, tutorialGroupTemp2.getGroupId()));
        tutorialGroupTemp2.addStudent(new Student("2103956", "Isabella", "Female", 3.6, tutorialGroupTemp2.getGroupId()));
        tutorialGroupTemp2.addStudent(new Student("2103947", "Lucas", "Male", 2.8, tutorialGroupTemp2.getGroupId()));
        tutorialGroupTemp2.addStudent(new Student("2103938", "Ava", "Female", 3.4, tutorialGroupTemp2.getGroupId()));
        tutorialGroupTemp2.addStudent(new Student("2103999", "Henry", "Male", 3.5, tutorialGroupTemp2.getGroupId()));
        tutorialGroupTemp2.addStudent(new Student("2103980", "Charlotte", "Female", 3.7, tutorialGroupTemp2.getGroupId()));
        tutorialGroupTemp2.addStudent(new Student("2103951", "Liam", "Male", 3.1, tutorialGroupTemp2.getGroupId()));
        tutorialGroupTemp2.addStudent(new Student("2103922", "Olivia", "Female", 3.9, tutorialGroupTemp2.getGroupId()));
        tutorialGroupTemp2.addStudent(new Student("2103913", "Emma", "Female", 3.3, tutorialGroupTemp2.getGroupId()));

        TutorialGroup tutorialGroupTemp3 = tutoGroupList.getValue("G3");
        tutorialGroupTemp3.addStudent(new Student("2103895", "Ella", "Female", 2.6, tutorialGroupTemp3.getGroupId()));
        tutorialGroupTemp3.addStudent(new Student("2103896", "Liam", "Male", 3.8, tutorialGroupTemp3.getGroupId()));
        tutorialGroupTemp3.addStudent(new Student("2103897", "Olivia", "Female", 3.7, tutorialGroupTemp3.getGroupId()));
        tutorialGroupTemp3.addStudent(new Student("2103898", "Noah", "Male", 3.5, tutorialGroupTemp3.getGroupId()));
        tutorialGroupTemp3.addStudent(new Student("2103899", "Ava", "Female", 3.9, tutorialGroupTemp3.getGroupId()));
        tutorialGroupTemp3.addStudent(new Student("2103900", "William", "Male", 2.6, tutorialGroupTemp3.getGroupId()));
        tutorialGroupTemp3.addStudent(new Student("2103901", "Sophia", "Female", 3.4, tutorialGroupTemp3.getGroupId()));
        tutorialGroupTemp3.addStudent(new Student("2103902", "James", "Male", 3.7, tutorialGroupTemp3.getGroupId()));
        tutorialGroupTemp3.addStudent(new Student("2103903", "Emma", "Female", 3.5, tutorialGroupTemp3.getGroupId()));
        tutorialGroupTemp3.addStudent(new Student("2103904", "Benjamin", "Male", 3.8, tutorialGroupTemp3.getGroupId()));
        tutorialGroupTemp3.addStudent(new Student("2103905", "Isabella", "Female", 3.6, tutorialGroupTemp3.getGroupId()));
        tutorialGroupTemp3.addStudent(new Student("2103906", "Lucas", "Male", 4.0, tutorialGroupTemp3.getGroupId()));
        tutorialGroupTemp3.addStudent(new Student("2103907", "Mia", "Female", 3.7, tutorialGroupTemp3.getGroupId()));
        tutorialGroupTemp3.addStudent(new Student("2103908", "Henry", "Male", 2.5, tutorialGroupTemp3.getGroupId()));
        tutorialGroupTemp3.addStudent(new Student("2103909", "Charlotte", "Female", 3.2, tutorialGroupTemp3.getGroupId()));
        tutorialGroupTemp3.addStudent(new Student("2103910", "Daniel", "Male", 3.9, tutorialGroupTemp3.getGroupId()));
        tutorialGroupTemp3.addStudent(new Student("2103911", "Lily", "Female", 2.8, tutorialGroupTemp3.getGroupId()));
        tutorialGroupTemp3.addStudent(new Student("2103912", "Alexander", "Male", 3.3, tutorialGroupTemp3.getGroupId()));

        TutorialGroup tutorialGroupTemp4 = tutoGroupList.getValue("G4");
        tutorialGroupTemp4.addStudent(new Student("2201001", "Alice", "Female", 3.6, tutorialGroupTemp4.getGroupId()));
        tutorialGroupTemp4.addStudent(new Student("2202002", "Bob", "Male", 3.5, tutorialGroupTemp4.getGroupId()));
        tutorialGroupTemp4.addStudent(new Student("2203003", "Catherine", "Female", 3.9, tutorialGroupTemp4.getGroupId()));
        tutorialGroupTemp4.addStudent(new Student("2204004", "David", "Male", 3.7, tutorialGroupTemp4.getGroupId()));
        tutorialGroupTemp4.addStudent(new Student("2205005", "Emily", "Female", 2.8, tutorialGroupTemp4.getGroupId()));
        tutorialGroupTemp4.addStudent(new Student("2206006", "Fiona", "Female", 3.4, tutorialGroupTemp4.getGroupId()));
        tutorialGroupTemp4.addStudent(new Student("2207007", "George", "Male", 2.3, tutorialGroupTemp4.getGroupId()));
        tutorialGroupTemp4.addStudent(new Student("2208008", "Hannah", "Female", 3.6, tutorialGroupTemp4.getGroupId()));
        tutorialGroupTemp4.addStudent(new Student("2209009", "Ian", "Male", 3.5, tutorialGroupTemp4.getGroupId()));
        tutorialGroupTemp4.addStudent(new Student("2210010", "Jessica", "Female", 3.9, tutorialGroupTemp4.getGroupId()));
    }

    private void findStudent() {
        System.out.print("Enter Student ID: ");
        String studentIdInput = scanner.nextLine();
        Student studentFound = findStudentByStudentId(studentIdInput);
        if (studentFound != null) {
            System.out.println("Student Found!\n");
            System.out.printf("%-11s %-25s %-8s %-5s %-15s\n", "Student ID", "Name", "Gender", "CGPA", "Tutorial Group");
            System.out.println("----------  ------------------------- -------- ----- -------------");
            System.out.println(studentFound);
        } else {
            System.out.println("Student Not Found!");
        }
        messageUI.pressToContinue();
    }

    private void changeTutorialGroup() {
        System.out.println("Enter Student ID: ");
        String studentIdInput = scanner.nextLine();
        Student studentFound = findStudentByStudentId(studentIdInput);

        System.out.printf("%-11s %-25s %-8s %-5s %-15s\n", "Student ID", "Name", "Gender", "CGPA", "Tutorial Group");
        System.out.println("----------  ------------------------- -------- ----- -------------");
        System.out.println(studentFound);
        System.out.println("");

        String groupIdInput = inputTutorialGroupId();
        TutorialGroup tutorialGroupCurrent = tutoGroupList.getValue(studentFound.getTutorialGroupID());
        TutorialGroup tutorialGroupChangeTo = tutoGroupList.getValue(groupIdInput);

        if (tutorialGroupChangeTo.addStudent(studentFound) && tutorialGroupCurrent.removeStudent(studentIdInput)) {
            System.out.println("Student added successfully");
        } else {
            System.out.println("Failed to add the student. Please check the Group ID.");
        }
        messageUI.pressToContinue();
    }

    private Student findStudentByStudentId(String studentIdInput1) {
        entries = tutoGroupList.getEntries();
        HashMap.Entry<String, Student>[] entriesStudent;

        for (HashMap.Entry<String, TutorialGroup> entry : entries) {
            tutorialGroupTemp = entry.getValue();

            if (!tutorialGroupTemp.getStudentList().isEmpty()) {
                entriesStudent = tutorialGroupTemp.getStudentList().getEntries();

                for (HashMap.Entry<String, Student> entryStudent : entriesStudent) {
                    Student student = entryStudent.getValue();

                    if (student.getStudentId().equals(studentIdInput1)) {
                        return student;
                    }
                }
            }
        }
        return null;
    }

    private void listAllStudent() {
        System.out.println("===================================================================");
        System.out.println("                              Student List");
        System.out.println("===================================================================");
        if (tutoGroupList.getSize() != 0) {
            entries = tutoGroupList.getEntries();

            HashMap.Entry<String, Student>[] entriesStudent;

            for (HashMap.Entry<String, TutorialGroup> entry : entries) {//Loop Tutorial List
                tutorialGroupTemp = entry.getValue();

                System.out.println("===================================================================");
                System.out.print(tutorialGroupTemp);
                System.out.println("===================================================================");
                System.out.printf("%-11s %-25s %-8s %-5s %-15s\n", "Student ID", "Name", "Gender", "CGPA", "Tutorial Group");
                System.out.println("----------  ------------------------- -------- ----- -------------");
                if (tutorialGroupTemp.getStudentList().getSize() != 0) {
                    entriesStudent = tutorialGroupTemp.getStudentList().getEntries();
                    for (HashMap.Entry<String, Student> entryStudent : entriesStudent) {//Loop Student List
                        System.out.print(entryStudent.getValue());
                    }
                } else {
                    System.out.println("No Student Exists In This Tutorial Group");
                }
                System.out.println("");
            }

        } else {
            System.out.println("No Tutorial Created!");
        }
        messageUI.pressToContinue();

    }

    private String removeStudentInput() {
        String studentId;
        System.out.println("=======================================");
        System.out.println("             Remove Student");
        System.out.println("=======================================");
        System.out.print("Enter Student ID that want to be removed: ");
        studentId = scanner.nextLine();
        return studentId;
    }

    public void addStudent() {
        Student student = tutoGroupUI.addStudentUI();
        String groupId = inputTutorialGroupId();
        System.out.println("=======================================\n");

        tutorialGroupTemp = tutoGroupList.getValue(groupId);
        entries = tutoGroupList.getEntries();

        student.setTutorialGroupID(groupId);
        System.out.println(student);
        for (HashMap.Entry<String, TutorialGroup> entry : entries) {
            if (entry.getValue().getStudentList().contains(student.getStudentId())) {
                System.out.println("Failed to add the student. Duplicate Student");
                messageUI.pressToContinue();
                return;
            }
        }
        if (tutorialGroupTemp.addStudent(student)) {

            System.out.println("Student added successfully");
        } else {
            System.out.println("Failed to add the student. Please check the Group ID.");
        }
    }

    public void removeStudent() {
        studentIdInput = removeStudentInput();
        if (tutoGroupList.getSize() != 0) {
            entries = tutoGroupList.getEntries();

            for (HashMap.Entry<String, TutorialGroup> entry : entries) {//Loop Tutorial List
                tutorialGroupTemp = entry.getValue();
                if (tutorialGroupTemp.getStudentList().getSize() != 0) {

                    HashMap.Entry<String, Student>[] entriesStudent = tutorialGroupTemp.getStudentList().getEntries();
                    for (HashMap.Entry<String, Student> entryStudent : entriesStudent) {//Loop Student List

                        Student student = entryStudent.getValue();

                        if (student.getStudentId().equals(studentIdInput)) {//if studentId found
                            if (tutorialGroupTemp.removeStudent(studentIdInput)) {
                                System.out.println("Success to remove Student");
                            } else {
                                System.out.println("Failed to remove Student");
                            }

                        }

                    }
                }
            }
        }
    }

    private String inputTutorialGroupId() {
        System.out.println("=======================================");
        System.out.println("           Tutorial Group List");
        System.out.println("=======================================");
        System.out.printf("%-10s %-25s\n", "Group ID", "Tutorial Group Name");
        System.out.println("--------   -----------------------------");
        System.out.print(tutoGroupList);
        System.out.println("=======================================");
        System.out.print("Please enter the Tutorial Group ID to which you would like to add this student: ");
        String groupId = scanner.nextLine();
        return groupId;
    }

    private void filterStudent() {
        System.out.println("=====================================================================");
        System.out.println("                       Filter Student");
        System.out.println("=====================================================================");
        FilterOption filterOption = getFilterOptions();
        HashMapInterface<String, Student> filterStudentList = filter(filterOption);
        System.out.println("=====================================================================");
        System.out.println("                      Filter Student List");
        System.out.println("=====================================================================");
        System.out.printf("%-11s %-25s %-8s %-5s %-15s\n", "Student ID", "Name", "Gender", "CGPA", "Tutorial Group");
        System.out.println("----------  ------------------------- -------- ----- -------------");
        if (!filterStudentList.isEmpty()) {
            System.out.println(filterStudentList.toString());
        } else {
            System.out.println("No Student Found!");
        }
        messageUI.pressToContinue();

    }

    private HashMapInterface<String, Student> filter(FilterOption filterOption) {
        String studentID = filterOption.getStudentIdInput();
        String studentName = filterOption.getStudentNameInput();
        String gender = filterOption.getGenderInput();
        String tutoGroupID = filterOption.getGroupIdInput();
        double cgpaMin = filterOption.getCgpaMinInput();
        double cgpaMax = filterOption.getCgpaMaxInput();

        entries = tutoGroupList.getEntries();
        HashMapInterface<String, Student> filterList = new HashMap<>();
        HashMap.Entry<String, Student>[] entriesStudent;
        for (HashMap.Entry<String, TutorialGroup> entry : entries) {
            tutorialGroupTemp = entry.getValue();
            if (!tutorialGroupTemp.getStudentList().isEmpty()) {
                entriesStudent = tutorialGroupTemp.getStudentList().getEntries();

                for (HashMap.Entry<String, Student> entryStudent : entriesStudent) {
                    Student student = entryStudent.getValue();
                    boolean studentIdMatch = (studentID == null || student.getStudentId().equals(studentID));
                    boolean studentNameMatch = (studentName == null || student.getName().equals(studentName));
                    boolean genderMatch = (gender == null || student.getGender().equals(gender));
                    boolean tutoGroupIdMatch = (tutoGroupID == null || student.getTutorialGroupID().equals(tutoGroupID));
                    boolean cgpaMinMatch = (cgpaMin == 0 || student.getCgpa() >= cgpaMin);
                    boolean cgpaMaxMatch = (cgpaMax == 0 || student.getCgpa() <= cgpaMax);

                    if (studentIdMatch && studentNameMatch && genderMatch && cgpaMinMatch && cgpaMaxMatch && tutoGroupIdMatch) {
                        filterList.add(student.getStudentId(), student);
                    }
                }

            }
        }
        return filterList;
    }

    private FilterOption getFilterOptions() {
        FilterOption filterOptions = new FilterOption();
        int choiceFilter;

        do {
            if (!filterOptions.toString().equals("")) {
                System.out.println("-------------------------");
                System.out.println("        Filter");
                System.out.println("-------------------------");
                System.out.println(filterOptions.toString());
            }
            choiceFilter = tutoGroupUI.getFilterChoice();
            switch (choiceFilter) {
                case 1: {
                    System.out.print("Enter Student ID : ");
                    filterOptions.setStudentIdInput(scanner.nextLine());
                }
                break;
                case 2: {
                    System.out.print("Enter Student Name : ");
                    filterOptions.setStudentNameInput(scanner.nextLine());

                }
                break;
                case 3: {
                    System.out.print("Enter Gender : ");
                    filterOptions.setGenderInput(scanner.nextLine());

                }
                break;
                case 4: {
                    System.out.print("Enter Tutorial Group (G1): ");
                    filterOptions.setGroupIdInput(scanner.nextLine());
                }
                break;
                case 5: {
                    System.out.print("Enter Minimum CGPA: ");
                    filterOptions.setCgpaMinInput(scanner.nextDouble());
                    scanner.nextLine();

                    System.out.print("Enter Maximum CGPA: ");
                    filterOptions.setCgpaMaxInput(scanner.nextDouble());
                    scanner.nextLine();
                    System.out.println("CGPA Minimum and Maximum Added!");
                }
                case 6:
                    break;
                default:
                    System.out.println("Wrong Input! Enter Again");
            }
        } while (choiceFilter != 6);
        return filterOptions;
    }

    private void generateReport() {
        System.out.println("==========================================================");
        System.out.println("                         Report");
        System.out.println("==========================================================");
        System.out.printf("%-30s: %d\n", "Total Tutorial Group", tutoGroupList.getSize());

        int totalStudent = 0;
        int totalMale = 0;
        int totalFemale = 0;
        int totalGoodStudent = 0;

        entries = tutoGroupList.getEntries();
        HashMap.Entry<String, Student>[] entriesStudent;

        for (HashMap.Entry<String, TutorialGroup> entry : entries) {
            tutorialGroupTemp = entry.getValue();
            if (!tutorialGroupTemp.getStudentList().isEmpty()) {
                totalStudent += tutorialGroupTemp.getStudentList().getSize();

                entriesStudent = tutorialGroupTemp.getStudentList().getEntries();

                for (HashMap.Entry<String, Student> entryStudent : entriesStudent) {
                    Student student = entryStudent.getValue();

                    if (student.getGender().equals("Male")) {
                        totalMale++;
                    } else {
                        totalFemale++;
                    }

                    if (student.getCgpa() > 3.75) {
                        totalGoodStudent++;
                    }

                }

            }
        }

        System.out.printf("%-30s: %d\n", "Total Students", totalStudent);
        System.out.println("==========================================================\n");
        System.out.print("Most of the students is ");
        if (totalMale > totalFemale) {
            System.out.println("Male");
            System.out.println(((totalMale / totalStudent) * 100) + "% of Students is male\nTotal of male students is " + totalMale);
        } else {
            System.out.println("Female");
            System.out.println(((totalFemale / totalStudent) * 100) + "% of Students is female\n Total of female students is " + totalMale);
        }
        System.out.println("\n==========================================================");
        System.out.println("There are total " + totalGoodStudent + " good students get CGPA higher than 3.75\n");
        messageUI.pressToContinue();

    }

}
