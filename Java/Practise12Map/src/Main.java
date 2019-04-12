import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main (String... args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Give me your name please: ");
        String y = input.nextLine();
        System.out.print("Give me your ID please: ");
        int x = input.nextInt();
        System.out.println();
        HashMap<Integer, String> keyChain = new HashMap<Integer, String>(){{
            put(x,y);
        }};
        System.out.println(keyChain.toString());
        HashMap<Integer, String> keyChain02 = new HashMap<Integer, String>(){{
            put(1,"Sun Balazs");
            put(2,"SZKT Ellenor");
            put(3,"PC Igazgato");
        }};
        System.out.println("Please give me the user ID to find it's username (database size: " +
                keyChain02.size() + "): ");
        int keyChainNumber = input.nextInt();
        System.out.println(keyChain02.get(keyChainNumber));
        HashMap<Integer, String> keyChain3 = new HashMap<Integer, String>();
        System.out.println("How many users would you like to add?");
        int n = input.nextInt();
        input.nextLine();
        for(int i = 0; i < n; i++){
            System.out.println("user " + (i+1) + " :");
            System.out.println("Name:");
            String temp1 = input.nextLine();
            System.out.println("ID:");
            int temp2 = input.nextInt();
            input.nextLine();
            keyChain3.put(temp2,temp1);
        }
        System.out.println(keyChain3.toString());
    }
}
