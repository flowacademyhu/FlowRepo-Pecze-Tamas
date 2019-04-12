import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1 || args.length >= 2) {
            System.out.print("Error, the application requires only one arguemnt!");
        } else {
            Random cube = new Random();
            int value = 0;
            int counter[] = {0, 0, 0, 0, 0, 0};
            for(int i = 0; i < Integer.parseInt(args[0]); i++) {
                value = 1 + cube.nextInt(5);
                System.out.println(value);
                counter[value - 1] += 1;
            }
            System.out.println("[1, 2, 3, 4, 5, 6]");
            System.out.println(Arrays.toString(counter));
            for(int i = 0; i < counter.length; i++) {
                System.out.println(i+1 + ((counter[i] / (double) 6) * 100) + "%");
            }
        }
    }
}