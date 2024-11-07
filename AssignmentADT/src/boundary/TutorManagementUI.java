/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import entity.FullTimeTutor;
import entity.PartTimeTutor;
import entity.Tutor;
import java.util.Scanner;

/**
 *
 * @author zhinf
 */
public class TutorManagementUI {

    Scanner scanner = new Scanner(System.in);

    public int getMenuChoice() {
        System.out.println("\nTUTOR MANAGEMENT MENU");
        System.out.println("1. Add a new Tutor");
        System.out.println("2. List Tutor");
        System.out.println("3. Remove Tutor");
        System.out.println("4. Find Tutor");
        System.out.println("5. Change Tutor ID");
        System.out.println("6. Edit Tutor");
        System.out.println("7. Filter Tutor");
        System.out.println("8. Generate Report");
        System.out.println("0. Quit");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.println();
        return choice;
    }
    
    public int getTutorTypeChoice(){
        System.out.println("\nSelect Tutor Type: ");
        System.out.println("1. Part Time");
        System.out.println("2. Full Time");
        System.out.println("3. Both");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
        int tutorTypeChoice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return tutorTypeChoice;
    }
    
    public int getListChoice(){
        System.out.println("\nLIST MENU");
        System.out.println("1. Tutor Details");
        System.out.println("2. Tutor Salary Details");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
        int listChoice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return listChoice;
    }

    public int getPtEditChoice() {
        System.out.println("\nEdit Tutor MENU");
        System.out.println("1. Edit Name");
        System.out.println("2. Edit Age");
        System.out.println("3. Edit Gender");
        System.out.println("4. Edit Email");
        System.out.println("5. Edit Contact Number");
        System.out.println("6. Edit Semester");
        System.out.println("7. Edit Faculty");
        System.out.println("8. Edit Course");
        System.out.println("9. Edit Salary Per Hour");
        System.out.println("10. Edit Working Hours");
        System.out.println("11. Edit OverTime Pay Rate");
        System.out.println("12. Edit OverTime Hours");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
        int editChoice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return editChoice;
    }

    public int getFtEditChoice() {
        System.out.println("\nEdit Tutor MENU");
        System.out.println("1. Edit Name");
        System.out.println("2. Edit Age");
        System.out.println("3. Edit Gender");
        System.out.println("4. Edit Email");
        System.out.println("5. Edit Contact Number");
        System.out.println("6. Edit Semester");
        System.out.println("7. Edit Faculty");
        System.out.println("8. Edit Course");
        System.out.println("9. Edit Basic Salary");
        System.out.println("10. Edit Allowance");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
        int editChoice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return editChoice;
    }
    
    public int getFilterChoice() {
        System.out.println("\nFilter Tutor MENU");
        System.out.println("1. Age");
        System.out.println("2. Gender");
        System.out.println("3. Semaster");
        System.out.println("4. Faculty");
        System.out.println("5. Course");
        System.out.println("6. Tutor Type");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
        int filterChoice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return filterChoice;
    }

    public void listAllTutors(String outputStr) {
        System.out.println("\nList of Tutors: ");
        System.out.println(String.format("%-8s  %-20s  %-4s  %-8s  %-30s  %-15s  %-10s  %-10s  %-20s\n", "ID", "Tutor Name", "Age", "Gender", "Email", "Contact No", "Semester", "Faculty", "Course") + outputStr);
    }
    
    public void listFtTutor(String outputStr){
        System.out.println("\nList of FullTime Tutors: ");
        System.out.println(String.format("%-8s %-20s %-4s %-8s %-30s %-15s %-10s %-10s %-20s %-16s %-16s\n", "ID", "Tutor Name", "Age", "Gender", "Email", "Contact No", "Semester", "Faculty", "Course", "BasicSalary(RM)", "Allowance(RM)") + outputStr);       
    }
    
    public void listPtTutor(String outputStr){
        System.out.println("\nList of PartTime Tutors: ");
        System.out.println(String.format("%-8s %-20s %-4s %-8s %-30s %-15s %-10s %-10s %-20s %-16s %-16s %-16s %-12s\n", "ID", "Tutor Name", "Age", "Gender", "Email", "Contact No", "Semester", "Faculty", "Course", "HourlyPay(RM)", "WorkingHours(hr)", "OverTimeRate(RM)","OverTime(hr)") + outputStr);       
    }

    public void printTutorDetails(Tutor tutor) {
        System.out.println("Tutor Details");
        System.out.println("Tutor ID: " + tutor.getID());
        System.out.println("Tutor Name: " + tutor.getTutorName());
        System.out.println("Age: " + tutor.getAge());
        System.out.println("Email: " + tutor.getEmail());
        System.out.println("Contact Number: " + tutor.getContactNo());
    }

    public String inputTutorID() {
        System.out.print("Enter tutor ID: ");
        String id = scanner.nextLine();
        return id;
    }

    public String inputTutorName() {
        System.out.print("Enter tutor name: ");
        String name = scanner.nextLine();
        return name;
    }

    public int inputAge() {
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        return age;
    }
    
    public String inputGender() {
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();
        return gender;
    }

    public String inputEmail() {
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        return email;
    }

    public String inputContactNumber() {
        System.out.print("Enter Contact Number: ");
        String contactNo = scanner.nextLine();
        return contactNo;
    }
    
    public double inputSalaryPerHour() {
        System.out.print("Enter Salary Per Hour: ");
        double salaryPerHour = scanner.nextDouble();
        scanner.nextLine();
        return salaryPerHour;
    }
    
    public double inputWorkingHours() {
        System.out.print("Enter Working Hours: ");
        double workingHours = scanner.nextInt();
        scanner.nextLine();
        return workingHours;
    }
    
    public double inputOverTimeRate() {
        System.out.print("Enter OverTime Rate: ");
        double overTimeRate = scanner.nextDouble();
        scanner.nextLine();
        return overTimeRate;
    }
    
    public double inputOvertime() {
        System.out.print("Enter OverTime: ");
        double overTime = scanner.nextDouble();
        scanner.nextLine();
        return overTime;
    }
    
    public double inputBasicSalary() {
        System.out.print("Enter Basic Salary: ");
        double basicSalary = scanner.nextDouble();
        scanner.nextLine();
        return basicSalary;
    }
    
    public double inputAllowance() {
        System.out.print("Enter Allowance: ");
        double allowance = scanner.nextDouble();
        scanner.nextLine();
        return allowance;
    }
    
    public double inputNewBasicSalary() {
        System.out.print("Enter NEW Basic Salary: ");
        double newBasicSalary = scanner.nextDouble();
        scanner.nextLine();
        return newBasicSalary;
    }
    
    public double inputNewAllowance() {
        System.out.print("Enter NEW Allowance: ");
        double newAllowance = scanner.nextDouble();
        scanner.nextLine();
        return newAllowance;
    }

    public Tutor inputPTtutorDetails() {
        String id = inputTutorID();
        String tutorName = inputTutorName();
        int age = inputAge();
        String gender = inputGender();
        String email = inputEmail();
        String contactNo = inputContactNumber();
        double salaryPerHour = inputSalaryPerHour();
        double wokingHours = inputWorkingHours();
        double overTimeRate = inputOverTimeRate();
        double overTime = inputOvertime();
        System.out.println();
        return new PartTimeTutor(id, tutorName, age, gender, email, contactNo, salaryPerHour, wokingHours, overTimeRate, overTime);
    }
    
    public Tutor inputFTtutorDetails() {
        String id = inputTutorID();
        String tutorName = inputTutorName();
        int age = inputAge();
        String gender = inputGender();
        String email = inputEmail();
        String contactNo = inputContactNumber();
        double basicSalary = inputBasicSalary();
        double allowance = inputAllowance();
        System.out.println();
        return new FullTimeTutor(id, tutorName, age, gender, email, contactNo, basicSalary, allowance);
    }

    public String inputNewTutorID() {
        System.out.print("Enter NEW tutor ID: ");
        String newId = scanner.nextLine();
        return newId;
    }

    public String inputNewTutorName() {
        System.out.print("Enter NEw tutor name: ");
        String newName = scanner.nextLine();
        return newName;
    }

    public int inputNewAge() {
        System.out.print("Enter NEW Age: ");
        int newAge = scanner.nextInt();
        scanner.nextLine();
        return newAge;
    }
    
    public String inputNewGender() {
        System.out.print("Enter NEW Gender: ");
        String newGender = scanner.nextLine();
        return newGender;
    }

    public String inputNewEmail() {
        System.out.print("Enter NEW Email: ");
        String newEmail = scanner.nextLine();
        return newEmail;
    }

    public String inputNewContactNumber() {
        System.out.print("Enter NEW Contact Number: ");
        String newContactNo = scanner.nextLine();
        return newContactNo;
    }
    
    public double inputNewSalaryPerHour() {
        System.out.print("Enter NEW Salary Per Hour: ");
        double newSalaryPerHour = scanner.nextDouble();
        scanner.nextLine();
        return newSalaryPerHour;
    }
    
    public int inputNewWorkingHours() {
        System.out.print("Enter NEW Working Hours: ");
        int NewWorkingHours = scanner.nextInt();
        scanner.nextLine();
        return NewWorkingHours;
    }
    
    public double inputNewOverTimeRate() {
        System.out.print("Enter NEW OverTime Rate: ");
        double NewOverTimeRate = scanner.nextDouble();
        scanner.nextLine();
        return NewOverTimeRate;
    }
    
    public double inputNewOverTime() {
        System.out.print("Enter NEW OverTime: ");
        double NewOverTime = scanner.nextDouble();
        scanner.nextLine();
        return NewOverTime;
    }

    public Tutor inputNewTutorDetails() {
        String newid = inputNewTutorID();
        String newtutorName = inputNewTutorName();
        int newage = inputNewAge();
        String newGender = inputNewGender();
        String newemail = inputNewEmail();
        String newcontactNo = inputNewContactNumber();
        double newSalaryPerHour = inputNewSalaryPerHour();
        double newWokingHours = inputNewWorkingHours();
        double newOverTimeRate = inputNewOverTimeRate();
        double newOverTime = inputNewOverTime();
        System.out.println();
        return new PartTimeTutor(newid, newtutorName, newage, newGender, newemail, newcontactNo, newSalaryPerHour, newWokingHours, newOverTimeRate, newOverTime);
    }

    public String inputFindTutor() {
        System.out.print("Enter the criteria to find a tutor: ");
        String criteria = scanner.nextLine();
        return criteria;
    }

    public String inputRespond() {
        System.out.println("Do you want to re-enter the details? (yes/no)");
        String respond = scanner.nextLine();
        return respond;
    }
    
    public String inputIDRespond() {
        System.out.println("Do you want to re-enter the ID? (yes/no)");
        String respond = scanner.nextLine();
        return respond;
    }

    public int inputMinAge() {
        System.out.print("Enter Minimum Age: ");
        int minAge = scanner.nextInt();
        scanner.nextLine();
        return minAge;
    }

    public int inputMaxAge() {
        System.out.print("Enter Maximum Age: ");
        int maxAge = scanner.nextInt();
        scanner.nextLine();
        return maxAge;
    }

    public int inputSemester() {
        System.out.print("Enter Semester: ");
        int semester = scanner.nextInt();
        scanner.nextLine();
        return semester;
    }

    public String inputFaculty() {
        System.out.print("Enter Faculty: ");
        String faculty = scanner.nextLine();
        return faculty;
    }

    public String inputCourse() {
        System.out.print("Enter Course: ");
        String Course = scanner.nextLine();
        return Course;
    }
    
//    public Tutor inputAdditionalDetails() {
//        int semester = inputSemester();
//        String faculty = inputFaculty();
//        String course = inputCourse();
//        System.out.println();
//        return new Tutor(semester, faculty, course);
//    }
    
    public String inputAdditionalRespond() {
        System.out.println("Do you want to enter additional Info? (yes/no)");
        String respond = scanner.nextLine();
        return respond;
    }
    
    public int inputNewSemester() {
        System.out.print("Enter NEW Semester: ");
        int newSemester = scanner.nextInt();
        scanner.nextLine();
        return newSemester;
    }

    public String inputNewFaculty() {
        System.out.print("Enter NEWFaculty: ");
        String newFaculty = scanner.nextLine();
        return newFaculty;
    }

    public String inputNewCourse() {
        System.out.print("Enter NEW Course: ");
        String newCourse = scanner.nextLine();
        return newCourse;
    }
    
    public String inputTutorType(){
        System.out.print("Enter Tutor Type: ");
        String tutorType = scanner.nextLine();
        return tutorType;
    }
    
    public void displaySalaryDetails(){
         System.out.println(String.format("%-8s %-20s %-16s %-20s %-16s", "ID", "Tutor Name", "Salary(RM)", "Allowance/OT(RM)", "Total(RM)"));       
    }
}
