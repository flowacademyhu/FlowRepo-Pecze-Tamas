import java.util.Scanner;

public class Main {
    public static void main(String... args) {
        Map map = new Map(10,10);

        Scanner scan = new Scanner(System.in);

        map.drawMap();

        System.out.println("Waiting for commands...");

        String str = scan.nextLine();

        while ( !str.equals("exit")) {
            map.doCommand(str);
            map.drawMap();
            str = scan.nextLine();
        }
    }
}
