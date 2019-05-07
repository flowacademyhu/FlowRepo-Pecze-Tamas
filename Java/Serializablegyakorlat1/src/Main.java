import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("KAJ Andor", 1993, 2.00);
        Student student2 = new Student("Micsik Zoltan", 1988, 4.40);
        Student student3 = new Student("Viczian Tamas", 1988, 4.30);
        List list1 = new ArrayList();
        list1.add(student1);
        list1.add(student2);
        list1.add(student3);
        Lecture lec1 = new Lecture(list1);
        for(int i = 0; i < list1.size(); i++) {
            // System.out.println(list1.get(i));
        }
        //save(list1);
        System.out.println(read());
    }
    public static void save(List lec1) {
        try (FileOutputStream fos = new FileOutputStream("test1.ser");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(lec1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList read() {
        try (FileInputStream fis = new FileInputStream("test1.ser"); ObjectInputStream ois = new ObjectInputStream(fis);) {
            ArrayList newList = (ArrayList) ois.readObject();
            return newList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
