package dao;

import adt.*;
import java.io.*;
import entity.Tutor;

/**
 *
 * @author zhinf
 */
public class TutorDAO {

    private String fileName = "tutor.dat"; 

    public void saveToFile(ListInterface<Tutor> tList) {
        File file = new File(fileName);
        try {
            ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream(file));
            ooStream.writeObject(tList);
            ooStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("\nFile not found");
        } catch (IOException ex) {
            System.out.println("\nCannot save to file");
        }
    }

    public ListInterface<Tutor> retrieveFromFile() {
        File file = new File(fileName);
        ListInterface<Tutor> tList = new ArrayList<>();
        try {
            ObjectInputStream oiStream = new ObjectInputStream(new FileInputStream(file));
            tList = (ArrayList<Tutor>) (oiStream.readObject());
            oiStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("\nNo such file.");
        } catch (IOException ex) {
            System.out.println("\nCannot read from file.");
        } catch (ClassNotFoundException ex) {
            System.out.println("\nClass not found.");
        } finally {
            return tList;
        }
    }
}
