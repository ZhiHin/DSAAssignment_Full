/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import adt.*;
import boundary.ProgrammeManagementUI;
import dao.ProgrammeDAO;
import entity.Programme;
import adt.SortedArrayListInterface;


/**
 *
 * @author Tan Guan Wei
 */
public class ProgrammeManagement {

    private SortedArrayList<Programme> programmeList = new SortedArrayList<>();
    private ProgrammeDAO programmeDAO = new ProgrammeDAO();
    private ProgrammeManagementUI programmeUI = new ProgrammeManagementUI();

    public ProgrammeManagement() {
        programmeList = programmeDAO.retrieveFromFile();
    }

    public void runProgrammeMenu() {
        int choice = 0;
        do {
            programmeUI.showProgrammeMenu();

            choice = programmeUI.getChoice();
            switch (choice) {
                case 0:
                    System.out.println("Bye!");
                    break;
                case 1:
                    addNewProgramme();
                    break;
                case 2:
                    removeProgramme();
                    break;
                case 3:
                    findProgramme();
                    break;
                case 4:
                    editProgramme();
                    break;
                case 5:
                    listAllProgrammes();
                    break;
                case 6:
                    addTutorialGroup();
                    break;
                case 7:
                    displayTutorialGroups();
                    break;
                case 8:
                    generateReport();
                    break;
                default:
                    System.out.println("Invalid choice.");
                    System.out.println("");
                    break;
            }
        } while (choice != 0);
    }

    public void addNewProgramme() {
        boolean dupe = false;
        Programme newProgramme = programmeUI.inputProgrammeDetails();

        for (int i = 0; i < programmeList.getNumberOfEntries(); i++) {
            Programme prog = programmeList.getEntry2(i);

            if (prog.getId().equals(newProgramme.getId())) {
                dupe = true;
                System.out.println("This programme already exists in the system");
                System.out.println("");
                break;
            }
        }

        if (!dupe) {
            System.out.println("Programme has been succesfully added.");
            programmeList.add(newProgramme);
            programmeDAO.saveToFile(programmeList);
        }

    }

    public void removeProgramme() {
        boolean found = false;
        String removedProgrammeId = programmeUI.inputRemoveDetails();
        for (int i = 0; i < programmeList.getNumberOfEntries(); i++) {
            Programme prog = programmeList.getEntry2(i);

            if (prog.getId().equals(removedProgrammeId)) {
                programmeList.remove(prog);
                programmeUI.removeMsg(prog.getId());
                programmeDAO.saveToFile(programmeList);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Invalid Programme ID");
            System.out.println("");
        }
    }

    public void findProgramme() {
        String programmeId = programmeUI.inputFindProgramme();
        boolean found = false;
        for (int i = 0; i < programmeList.getNumberOfEntries(); i++) {
            Programme prog = programmeList.getEntry2(i);

            if (prog.getId().equals(programmeId)) {
                programmeUI.displayFoundProgramme(prog);
                found = true;
            }

        }
        if (!found) {
            System.out.println("Programme ID not found");
            System.out.println("");
        }
    }

    public void editProgramme() {
        String programmeId = programmeUI.inputEditProgramme();
        programmeUI.displayEditMenu();
        int choice = programmeUI.getChoice();
        switch (choice) {

            case 1:
                String newName = programmeUI.editProgrammeName();
                for (int i = 0; i < programmeList.getNumberOfEntries(); i++) {
                    Programme prog = programmeList.getEntry2(i);

                    if (prog.getId().equals(programmeId)) {
                        prog.setName(newName);
                        programmeDAO.saveToFile(programmeList);
                    }

                }
                break;
            case 2:
            case 0:
                System.out.println("Bye");
                break;
        }
    }

    public void listAllProgrammes() {
        if (!programmeList.isEmpty()) {
            System.out.println("----------------------------------------------------------------");
            System.out.println("                            PROGRAMMES ");
            System.out.println("----------------------------------------------------------------");
            for (int i = 0; i < programmeList.getNumberOfEntries(); i++) {
                programmeUI.displayProgrammes(programmeList.getEntry2(i));
            }
        } else {
            System.out.println("There are no programmes in the system");
        }
    }

    public void addTutorialGroup() {
        String programmeId = programmeUI.inputProgIdTutorialGroup();
        String tutorialCode = programmeUI.inputAddTutorialGroup();
        boolean found = false;
        boolean dupe = false;

        for (int i = 0; i < programmeList.getNumberOfEntries(); i++) {
            Programme prog = programmeList.getEntry2(i);

            if (prog.getId().equals(programmeId)) {
                found = true;
                for (int index = 0; index < prog.getTutorialList().getNumberOfEntries(); index++) {

                    if (prog.getTutorialList().getEntry2(index).equals(tutorialCode)) {
                        dupe = true;
                        System.out.println("Tutorial Group is already in the Programme");
                        System.out.println("");
                        break;
                    }
                }
                if (!dupe) {
                    prog.getTutorialList().add(tutorialCode);
                    programmeDAO.saveToFile(programmeList);
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("Programme Id does not exist");
        }
    }

    public void displayTutorialGroups() {
        String programmeId = programmeUI.inputProgIdTutorialGroup2();
        Programme programme = new Programme();
        boolean found = false;
        if (!programmeList.isEmpty()) {
            for (int i = 0; i < programmeList.getNumberOfEntries(); i++) {
                programme = programmeList.getEntry2(i);
                if (programme.getId().equals(programmeId)) {
                    found = true;
                    break;
                }
            }
        } else {
            System.out.println("No Programmes in the system.");
        }
        if (found) {
            programmeUI.displayTutorialGroupsInProgramme(programme.getName());
            for (int i = 0; i < programme.getTutorialList().getNumberOfEntries(); i++) {
                System.out.printf(programme.getTutorialList().getEntry2(i) + "\n\n");
            }
        } else {
            System.out.println("Invalid Programme ID");
        }

    }

    public void generateReport() {
        programmeUI.generateProgrammeReport(programmeList);
    }

    public static void main(String[] args) {
        ProgrammeManagement programmeManagement = new ProgrammeManagement();
        programmeManagement.runProgrammeMenu();
    }
}
