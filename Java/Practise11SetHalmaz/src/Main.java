import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String... args){
        System.out.println("Hello user!");
        HashSet set = new HashSet<Integer>();
        Scanner read = new Scanner(System.in);
        System.out.println("Please type in 5 numbers (one by one)");
        set.add(read.nextInt());
        set.add(read.nextInt());
        set.add(read.nextInt());
        set.add(read.nextInt());
        set.add(read.nextInt());
        System.out.println(set.toString());
    }
}
