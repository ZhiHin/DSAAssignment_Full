package dao;

import adt.*;
import entity.Programme;
import java.io.*;

/**
 *
 * @author Tan Guan Wei
 */

public class ProgrammeDAO {

    private String fileName = "programme.dat"; // For security and maintainability, should not have filename hardcoded here.

    public void saveToFile(SortedArrayList<Programme> programmeList) {
        File file = new File(fileName);
        try {
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream(file));
            ooStream.writeObject(programmeList);
            ooStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("\nFile not found");
        } catch (IOException ex) {
            System.err.println("Error saving to file: " + ex.getMessage());
            System.out.println("\nCannot save to file ");
        }
    }

    public SortedArrayList<Programme> retrieveFromFile() {
        File file = new File(fileName);
        SortedArrayList<Programme> productList = new SortedArrayList<>();
        try {
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(file));
            productList = (SortedArrayList<Programme>) (oiStream.readObject());
            oiStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("\nNo such file.");
        } catch (IOException ex) {
            System.out.println("\nCannot read from file.");
        } catch (ClassNotFoundException ex) {
            System.out.println("\nClass not found.");
        } finally {
            return productList;
        }
    }
}
