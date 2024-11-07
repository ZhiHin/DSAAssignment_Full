/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.SortedArrayList;
import entity.Course;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import adt.SortedArrayListInterface;

/**
 *
 * @author Dickie Wong Wei Hao
 */
public class CourseDAO {

    private String fileName = "course.dat";

    public void saveToFile(SortedArrayListInterface<Course> course) {
        File file = new File(fileName);

        try {
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    System.out.println("Failed to create the file.");
                    return;
                }
            }

            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream(file));
            ooStream.writeObject(course);
            ooStream.close();
            System.out.println("Courses saved to file successfully.");
        } catch (FileNotFoundException ex) {
            System.out.println("\nFile not found");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("\nCannot save to file");
        }
    }

    public SortedArrayListInterface<Course> retrieveFromFile() {
        File file = new File(fileName);
        SortedArrayListInterface<Course> course = new SortedArrayList<>();
        try {
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(file));
            course = (SortedArrayList<Course>) (oiStream.readObject());
            oiStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("\nNo such file.");
        } catch (IOException ex) {
            System.out.println("\nCannot read from file.");
        } catch (ClassNotFoundException ex) {
            System.out.println("\nClass not found.");
        } finally {
            return course;
        }
    }

    public void clearFile() {
        try {
            File file = new File(fileName);

            if (!file.exists()) {
                System.out.println("File does not exist.");
                return;
            }

            FileWriter fileWriter = new FileWriter(file, false); // Open the file in write mode, which clears its contents
            fileWriter.close(); // Close the file

            System.out.println("File cleared successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occurred while clearing the file.");
        }
    }
}
