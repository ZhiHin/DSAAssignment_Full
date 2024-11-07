/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import entity.Student;
import java.util.Scanner;

/**
 *
 * @author tkair
 */
public class TutorialGroupMaintenanceUI {

    Scanner scanner = new Scanner(System.in);

    public Student addStudentUI() {
        System.out.println("=======================================");
        System.out.println("             Add Student");
        System.out.println("=======================================");

        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter Gender : ");
        String gender = scanner.nextLine();

        System.out.print("Enter CGPA: ");
        double cgpa = scanner.nextDouble();
        return new Student(studentId, studentName, gender, cgpa);
    }

    public int getFilterChoice() {
        int choiceFilter;
        System.out.println("Choose one filter: ");
        System.out.println("1. Student ID");
        System.out.println("2. Student Name");
        System.out.println("3. Gender");
        System.out.println("4. Tutorial Group");
        System.out.println("5. CGPA");
        System.out.println("6. Display");
        System.out.print("Enter your choice: ");
        choiceFilter = scanner.nextInt();
        return choiceFilter;
    }
    
    public int getMenuChoice() {
        System.out.println("=======================================");
        System.out.println("Tutorial Group Management Subsystem");
        System.out.println("=======================================");
        System.out.println("1. Add Student");
        System.out.println("2. Remove Student");
        System.out.println("3. Change Tutorial Group for Student");
        System.out.println("4. List All Students");
        System.out.println("5. Generate Report");
        System.out.println("6. Find Student");
        System.out.println("7. Filter");
        System.out.println("8. Exit");
        System.out.println("=======================================");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("=======================================");
        System.out.println("");
        return choice;
    }

}
