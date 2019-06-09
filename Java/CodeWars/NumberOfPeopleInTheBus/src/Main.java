import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int counter;
        ArrayList<int[]> list = new ArrayList<int[]>();
        list.add(new int[] {10,0});
        list.add(new int[] {3,5});
        // in stream foreach mutable variable like int counter can't be used.
        counter = list.stream().mapToInt(p -> p[0]).sum();
        counter -= list.stream().mapToInt(p -> p[1]).sum();
        System.out.println(counter);
        }
    }