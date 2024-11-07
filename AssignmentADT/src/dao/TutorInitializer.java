package dao;

import adt.*;
import entity.FullTimeTutor;
import entity.PartTimeTutor;
import entity.Tutor;

/**
 *
 * @author zhinf
 */
public class TutorInitializer {
    private TutorDAO tutorDAO = new TutorDAO();
    
    public ListInterface<Tutor> TutorInitializer(){       
        ListInterface<Tutor> tList = new ArrayList<>();
        tList.add(new PartTimeTutor("PT1111", "ZhiHin", 20, "Male", "zhin@gmail.com", "011-17616448", 1, "FOCS", "Software Engineering", 20.0, 30.0, 60.0, 10.0));
        tList.add(new PartTimeTutor("PT1333", "Jackson", 30, "Female", "Jackson@gmail.com", "012-3456782", 1, "FOCS", "Software Engineering", 30.0, 40.0, 50.0, 10.0));
        tList.add(new PartTimeTutor("PT1945", "Rainbow Tan", 25, "Female", "Rainbow@gmail.com", "011-16782234", 1, "FOCS", "Software Engineering", 200.0, 30.0, 50.0, 5.0));
        tList.add(new PartTimeTutor("PT1999", "Nancy Tan", 28, "Female", "Nancy@gmail.com", "011-11112222", 1, "FOCS", "DSA", 20.0, 20.0, 50.0, 10.0));
        tList.add(new PartTimeTutor("PT1024", "PeppaPig", 23, "Female", "PeppaPig@gmail.com", "012-7778888", 1, "FOCS", "DSA", 30.0, 30.0, 50.0, 10.0));
        tList.add(new PartTimeTutor("PT1110", "Rando", 50,"Female", "Rando@gmail.com", "012-6666333", 1, "FOCS", "DSA", 30.0, 30.0, 50.0, 10.0));
        
        tList.add(new FullTimeTutor("FT2345", "Ellen", 20, "Female", "ellen@gmail.com", "012-3454567", 1, "FOCS", "DSA", 2500.00, 200.00));
        tList.add(new FullTimeTutor("FT2567", "Jett", 30, "Female", "Jett@gmail.com", "012-3454567", 1, "FOCS", "DSA", 2800.00, 300.00));
        tList.add(new FullTimeTutor("FT2123", "Charles", 40, "Male", "Charles@gmail.com", "012-3454567", 1, "FOCS", "DSA", 3000.00, 500.00));
        tList.add(new FullTimeTutor("FT2867", "Danny", 29, "Male", "Danny@gmail.com", "012-3454567", 1, "FOCS", "DSA", 5000.00, 600.00));
        tList.add(new FullTimeTutor("FT2200", "Ronaldo", 28, "Male", "Ronaldo@gmail.com", "012-3454567", 1, "FOCS", "DSA", 6000.00, 800.00));
        tList.add(new FullTimeTutor("FT2398", "Nyokki", 20, "Female", "Nyokki@gmail.com", "012-3454567", 1, "FOCS", "DSA", 5500.00, 700.00));
        
        tutorDAO.saveToFile(tList);
        
        return tList;
    }   
    
    public static void main(String[] args) {
    TutorInitializer t = new TutorInitializer();
    ListInterface<Tutor> tList = t.TutorInitializer();
    System.out.println("\nProducts:\n" + tList);
  }
}
