/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author tkair
 */
public class FilterOption {

    private String studentIdInput;
    private String studentNameInput;
    private String genderInput;
    private String groupIdInput;
    private double cgpaMinInput;
    private double cgpaMaxInput;

    public FilterOption(String studentIdInput, String studentNameInput, String genderInput, String groupIdInput, double cgpaMinInput, double cgpaMaxInput) {
        this.studentIdInput = studentIdInput;
        this.studentNameInput = studentNameInput;
        this.genderInput = genderInput;
        this.groupIdInput = groupIdInput;
        this.cgpaMinInput = cgpaMinInput;
        this.cgpaMaxInput = cgpaMaxInput;
    }

    public FilterOption() {
        this.studentIdInput = null;
        this.studentNameInput = null;
        this.genderInput = null;
        this.groupIdInput = null;
        this.cgpaMinInput = 0;
        this.cgpaMaxInput = 0;
    }

    public void setStudentIdInput(String studentIdInput) {
        this.studentIdInput = studentIdInput;
    }

    public void setStudentNameInput(String studentNameInput) {
        this.studentNameInput = studentNameInput;
    }

    public void setGenderInput(String genderInput) {
        this.genderInput = genderInput;
    }

    public void setGroupIdInput(String groupIdInput) {
        this.groupIdInput = groupIdInput;
    }

    public void setCgpaMinInput(double cgpaMinInput) {
        this.cgpaMinInput = cgpaMinInput;
    }

    public void setCgpaMaxInput(double cgpaMaxInput) {
        this.cgpaMaxInput = cgpaMaxInput;
    }

    public String getStudentIdInput() {
        return studentIdInput;
    }

    public String getStudentNameInput() {
        return studentNameInput;
    }

    public String getGenderInput() {
        return genderInput;
    }

    public String getGroupIdInput() {
        return groupIdInput;
    }

    public double getCgpaMinInput() {
        return cgpaMinInput;
    }

    public double getCgpaMaxInput() {
        return cgpaMaxInput;
    }

    @Override
    public String toString() {
        String outStr = "";
        if (studentIdInput != null) {
            outStr += String.format("%-15s: %s\n", "Student ID",studentIdInput);
        }
        if (studentNameInput != null) {
            outStr += String.format("%-15s: %s\n","Student Name", studentNameInput);
        }
        if (genderInput != null) {
            outStr += String.format("%-15s: %s\n","Gender ", genderInput);
        }
        if (groupIdInput != null) {
            outStr += String.format("%-15s: %s\n","Group ID", groupIdInput);
        }
        if (cgpaMinInput != 0) {
            outStr += String.format("%-15s: %.2f\n","Minimum CGPA", cgpaMinInput);
        }
        if (cgpaMaxInput != 0) {
            outStr += String.format("%-15s: %.2f\n","Maximum CGPA", cgpaMaxInput);
        }
        return outStr;

    }

}
