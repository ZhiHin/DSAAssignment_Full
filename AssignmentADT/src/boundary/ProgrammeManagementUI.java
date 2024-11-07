/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import adt.SortedArrayListInterface;
import entity.Programme;
import java.util.Scanner;

/**
 *
 * @author Tan Guan Wei
 */
//Manages the input and output of the system
public class ProgrammeManagementUI {

    Scanner scanner = new Scanner(System.in);

    //used for menus with index
    public int getChoice() {
        int choice = scanner.nextInt();
        System.out.println("");
        scanner.nextLine();
        return choice;
    }

    public void showProgrammeMenu() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("                                MENU ");
        System.out.println("----------------------------------------------------------------");
        System.out.println("1. Add a new programme");
        System.out.println("2. Remove a programme");
        System.out.println("3. Find a programme");
        System.out.println("4. Amend programme details");
        System.out.println("5. List all programmes");
        System.out.println("6. Add a tutorial group to a programme");
        System.out.println("7. List all tutorial groups for a programme");
        System.out.println("8. Generate report");
        System.out.printf("Enter your choice (0 to exit the program): ");
    }

    //Add Function
    public String inputProgrammeName() {
        System.out.printf("Enter the programme name: ");
        String name = scanner.nextLine();
        return name;
    }

    public String inputProgrammeID() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("                              ADD");
        System.out.println("----------------------------------------------------------------");
        System.out.printf("Enter the programme id: ");
        String id = scanner.nextLine();
        return id;
    }

    public Programme inputProgrammeDetails() {
        String id = inputProgrammeID();
        String name = inputProgrammeName();
        return new Programme(id, name);
    }

    //Remove Function
    public String inputRemoveDetails() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("                              REMOVE");
        System.out.println("----------------------------------------------------------------");
        System.out.printf("Enter the programme id: ");
        String id = scanner.nextLine();
        System.out.println("");
        return id;
    }

    public void removeMsg(String id) {
        System.out.printf("Course " + id + " has been successfully removed.\n");
    }

    //Find Function
    public String inputFindProgramme() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("                         FIND PROGRAM");
        System.out.println("----------------------------------------------------------------");
        System.out.printf("Enter the programme id: ");
        String id = scanner.nextLine();
        return id;
    }

    public void displayFoundProgramme(Programme foundProgramme) {
        System.out.printf("Programme ID: %s\n", foundProgramme.getId());
        System.out.printf("Programme Name: %s\n", foundProgramme.getName());
        System.out.printf("Tutorial Groups of %s: %s\n\n", foundProgramme.getId(), foundProgramme.displayTutorialGroups());
    }

    //Edit Programme Function
    public String inputEditProgramme() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("                         EDIT PROGRAM");
        System.out.println("----------------------------------------------------------------");
        System.out.printf("Enter the programme id: ");
        String id = scanner.nextLine();
        return id;
    }

    public void displayEditMenu() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("                         EDIT PROGRAM");
        System.out.println("----------------------------------------------------------------");
        System.out.println("What would you like to edit");
        System.out.printf("1.Name\n");
        System.out.printf("2.Exit\n");
        System.out.printf("Enter your choice:  ");
    }

    public String editProgrammeName() {
        System.out.printf("Enter the new programme name: ");
        String name = scanner.nextLine();
        System.out.println("");
        return name;
    }

    //List All Function
    public void displayProgrammes(Programme programme) {
        System.out.printf("Programme ID: %s\n", programme.getId());
        System.out.printf("Programme Name: %s\n", programme.getName());
        System.out.println("");
    }

    //Add Tutorial Group Function
    public String inputProgIdTutorialGroup() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("                           ADD TUTORIAL GROUP ");
        System.out.println("----------------------------------------------------------------");
        System.out.printf("Enter the programme id: ");
        String id = scanner.nextLine();
        System.out.println("");
        return id;
    }

    public String inputAddTutorialGroup() {
        System.out.printf("Enter the tutorial group's code: ");
        String tutCode = scanner.nextLine();
        System.out.println("");
        return tutCode;
    }

    //Display tutorial groups
    public String inputProgIdTutorialGroup2() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("                        LIST TUTORIAL GROUPS");
        System.out.println("----------------------------------------------------------------");
        System.out.printf("Enter the programme id: ");
        String id = scanner.nextLine();
        System.out.println("");
        return id;
    }

    public void displayTutorialGroupsInProgramme(String programmeName) {

        System.out.println("----------------------------------------------------------------");
        System.out.printf("              Tutorial Groups of %s: \n", programmeName);
        System.out.println("----------------------------------------------------------------");

    }

    //Generate Report
    public void generateProgrammeReport(SortedArrayListInterface<Programme> programmeList) {
        System.out.println("Program Code  |  Name                                              |  Number of Tutorial Groups");
        System.out.println("------------------------------------------------------------------------------------------------");
        for (int i = 0; i < programmeList.getNumberOfEntries(); i++) {
            System.out.printf("%-14s|  %-50s|  %d%n\n", programmeList.getEntry(i).getId(), programmeList.getEntry(i).getName(), programmeList.getEntry(i).getTutorialList().getNumberOfEntries());
        }
    }
}
