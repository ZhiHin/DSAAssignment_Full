package entity;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import adt.SortedArrayList;
import java.io.Serializable;
import java.util.Objects;
import adt.SortedArrayListInterface;

/**
 *
 * @author Dickie Wong Wei Hao
 */
public class Course implements Serializable, Comparable<Course> {

    private String courseID;
    private String courseName;
    private int creditHours;
    private SortedArrayListInterface<Program> programs;

    public Course() {
    }

    public Course(String courseID, String courseName, int creditHours) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.programs = new SortedArrayList<>();
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.courseID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Course otherCourse = (Course) obj;
        return Objects.equals(courseID, otherCourse.courseID);
    }

    public void addProgram(Program program) {
        programs.add(program);
    }

    public void removeProgram(int index) {
        if (index >= 0 && index < programs.getNumberOfEntries()) {
            programs.remove(index);
        }
    }

    public SortedArrayListInterface<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(SortedArrayListInterface<Program> programs) {
        this.programs = programs;
    }

    @Override
    public String toString() {

        return "\nCourse {" + "CourseID = " + courseID + ", courseName = " + courseName + ", CreditHours = " + creditHours + programs + '}';
    }

    @Override
    public int compareTo(Course otherCourse) {
        return this.courseID.compareTo(otherCourse.courseID);
    }

}
