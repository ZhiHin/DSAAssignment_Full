/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author zhinf
 */
public abstract class Tutor implements Comparable<Tutor>, Serializable{
    private String id;
    private String tutorName;
    private int age;
    private String gender;
    private String email;
    private String contactNo;
    private int semester;
    private String faculty;
    private String course;
    private String tutorType;
    
    public abstract double salaryPay();

    public Tutor() {
    }

    public Tutor(String ID) {
        this.id = ID;
    }
    
    public Tutor(String ID, String tutorName, int age, String gender, String email, String contactNo) {
        this.id = ID;
        this.tutorName = tutorName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.contactNo = contactNo;
    }

    public Tutor(int semester, String faculty, String course) {
        this.semester = semester;
        this.faculty = faculty;
        this.course = course;
    }

    public Tutor(String id, String tutorName, int age, String gender, String email, String contactNo, int semester, String faculty, String course) {
        this.id = id;
        this.tutorName = tutorName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.contactNo = contactNo;
        this.semester = semester;
        this.faculty = faculty;
        this.course = course;
    }

    public String getID() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }   

    public String getTutorType() {
        return tutorType;
    }

    public void setTutorType(String tutorType) {
        this.tutorType = tutorType;
    }
    
    
    @Override
    public String toString() {
        if(semester > 0 && faculty != null && course != null){
            return String.format("%-8s %-20s %-4d %-8s %-30s %-15s %-10d %-10s %-20s", id, tutorName, age, gender, email, contactNo, semester, faculty, course);
        }
        return String.format("%-8s %-20s %-4d %-8s %-30s %-15s %-10s %-10s %-20s", id, tutorName, age, gender, email, contactNo, "", "", "");
    }

    @Override
    public int compareTo(Tutor o) {      
        return this.id.compareTo(o.id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tutor other = (Tutor) obj;
        return Objects.equals(this.id, other.id);
    }  
}
