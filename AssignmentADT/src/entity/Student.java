/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author tkair
 */
public class Student {
    private String studentId;
    private String name;
    private String gender;
    private double cgpa;
    private String tutorialGroupID;

    public Student(String studentId, String name, String gender,double cgpa, String tutorialGroupID) {
        this.studentId = studentId;
        this.name = name;
        this.cgpa = cgpa;
        this.gender = gender;
        this.tutorialGroupID = tutorialGroupID;
    }

    public Student(String studentId, String name, String gender, double cgpa) {
        this.studentId = studentId;
        this.name = name;
        this.gender = gender;
        this.cgpa = cgpa;
    }

    public Student(String studentId, String name, String tutorialGroupID) {
        this.studentId = studentId;
        this.name = name;
        this.tutorialGroupID = tutorialGroupID;
    }

    public Student(String studentId) {
        this.studentId = studentId;
    }

    public Student() {
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public void setTutorialGroupID(String tutorialGroupID) {
        this.tutorialGroupID = tutorialGroupID;
    }

    public String getGender() {
        return gender;
    }
    
    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public double getCgpa() {
        return cgpa;
    }

    public String getTutorialGroupID() {
        return tutorialGroupID;
    }

    @Override
    public String toString() {
        return String.format("%-11s %-25s %-8s %-5.2f %-15s\n", studentId,name,gender,cgpa,tutorialGroupID);
    }
    
    
    
}
