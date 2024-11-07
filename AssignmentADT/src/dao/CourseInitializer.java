/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.SortedArrayList;
import adt.SortedArrayListInterface;
import entity.Course;
import entity.Program;

/**
 *
 * @author TARUC
 */
public class CourseInitializer {

    public static SortedArrayListInterface<Course> initializeCourses() {
        SortedArrayListInterface<Course> courses = new SortedArrayList<>();

        // Initialize individual courses
        Course course1 = new Course("AACS2284", "Operating Systems", 4);
        Course course2 = new Course("AAMS3163", "Statistics I", 4);
        Course course3 = new Course("AAMS3244", "Statistics II", 4);
        Course course4 = new Course("AJEL1023", "Academic English", 3);
        Course course5 = new Course("BACS2042", "Research Methods", 2);

        //Initialize program into course
        course2.addProgram(new Program("IST", "Interactive Software Technology"));
        course3.addProgram(new Program("CIS", "Computer Information Systems"));
        course3.addProgram(new Program("NE", "Network Engineering"));
        course4.addProgram(new Program("NE", "Network Engineering"));
        course4.addProgram(new Program("CIS", "Computer Information Systems"));
        course4.addProgram(new Program("DS", "Data Science"));
        course4.addProgram(new Program("RSW", "Software Engineers"));
        course4.addProgram(new Program("IST", "Interactive Software Technology"));
        course5.addProgram(new Program("RSW", "Software Engineers"));

        //expected output: //        Course course2 = new Course("AAMS3163", "Statistics I", 4, "IST");
//        Course course3 = new Course("AAMS3244", "Statistics II", 4, "CIS", "NE");
//        Course course4 = new Course("AJEL1023", "Academic English", 3, "CIS", "DS", "IST", "NE", "RSW");
//        Course course5 = new Course("BACS2042", "Research Methods", 2, "RSW");

        // Add courses to the list
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);
        courses.add(course5);

        return courses;
    }
    
        public static void main(String[] args) {
        // Initialize the courses
        SortedArrayListInterface<Course> courses = initializeCourses();

        // Save the courses to a file using CourseDAO
        CourseDAO courseDAO = new CourseDAO();
        courseDAO.saveToFile(courses);

        System.out.println("Courses initialized and saved to file.");
    }
}
