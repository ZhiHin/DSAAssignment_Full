/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author Dickie Wong Wei Hao
 */
public class Program implements Serializable, Comparable<Program>{
        private String programID;
    private String programName;

    public Program(String programID, String programName) {
        this.programID = programID;
        this.programName = programName;
    }

    public String getProgramID() {
        return programID;
    }

    public void setProgramID(String programID) {
        this.programID = programID;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }
    
     @Override
    public String toString() {
             return ", " + programID;
    }

@Override
public int compareTo(Program program) {
    return this.programName.compareTo(program.programName);
}
    
}
