import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String... args) {
        ArrayList database = new ArrayList();
        for (int i = 0; i<args.length; i++) {
            database.add(Integer.parseInt(args[i]));
        }
        writeOut(database);
        System.out.println();
        System.out.println("Match? " + Match(database, 2));
        deleteElements(database);
        Scanner reader = new Scanner(System.in);

    }
    public static void writeOut(ArrayList array01){
        for (int i = 0; i < array01.size(); i++) {
            System.out.print(array01.get(i));
            if(i<array01.size()-1){
                System.out.print(", ");
            }
        }
    }
    public static boolean Match (ArrayList <Integer>array00, int matching){
        for (int i = 0; i < array00.size(); i++) {
            if(array00.get(i) == (matching)){
                return true;
            }
        }
        return false;
    }
    public static void deleteElements(ArrayList <Integer> array007) {
        for (int i = 0; i < array007.size(); i++) {
            if(array007.get(i) % 2 == 0) {
                array007.remove(i);
            }
        }
        System.out.println(array007);
    }
}

