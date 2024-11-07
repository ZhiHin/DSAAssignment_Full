/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import adt.*;
import entity.Programme;

/**
 *
 * @author Tan Guan Wei
 */
public class ProgrammeInitializer {

    private ProgrammeDAO programmeDAO = new ProgrammeDAO();

    public SortedArrayList<Programme> initializeProgramme() {
        SortedArrayList<Programme> pList = new SortedArrayList<>();
        pList.add(new Programme("RSW", "Degree in Software Engineering"));
        pList.add(new Programme("DCS", "Diploma in Computer Science"));
        pList.add(new Programme("ACC", "Degree in Accounting"));
        pList.add(new Programme("BEANS", "Degree in Beantology"));
        programmeDAO.saveToFile(pList);
        return pList;
    }

    public static void main(String[] args) {
        ProgrammeInitializer p = new ProgrammeInitializer();
        p.initializeProgramme();
        
    }
}
