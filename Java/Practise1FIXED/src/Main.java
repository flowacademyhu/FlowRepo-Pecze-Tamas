import java.util.Random;

public class Main {
    public static void main(String[] args) {
        fi();
        s();
        t();
        fo(); //waiting to be finished
        ei();
        ni();
    }

    private static void fi() {
        System.out.println("First Method");
        Random ra1 = new Random();
        int n = 5 + (ra1.nextInt(5));
        System.out.println("Random number: " + n);
        int finalValue = 0;
        for (int i = 0; i <= n; i++) {
            finalValue += i;
        }
        System.out.println("Sum of random numbers: " + finalValue);
    }
    private static void s() {
        System.out.println("Second Method");
        Random ra2 = new Random();
        int n = 5 + (ra2.nextInt(5));
        System.out.println("Random number: " + n);
        int sum = 0;
        int multiplication = 1;
        int temp2 = 10;
        int temp3 = -10;
        for (int i = 0; i <= n; i++){
            int temp = ra2.nextInt(20);
            temp -= 10;
            System.out.println("The " + i + " random number is the: " + temp);
            sum += temp;
            multiplication *= temp;
            if (temp < temp2) {
                temp2 = temp;
            }
            if (temp > temp3) {
                temp3 = temp;
            }
        }
        System.out.println("Sum of numbers: " + sum);
        System.out.println(multiplication);
        System.out.println( (float) sum/n);
        System.out.println("Smallest number is: " + temp2);
        System.out.println("Biggest number is: " + temp3);
    }
    private static void t() {
        System.out.println("Third Method");
        int n;
        int sum = 0;
        int temp = -100;
        int temp2 = -5;
        do{
            Random ra3 = new Random();
            n = 5 - (ra3.nextInt(10));
            System.out.println("Random number: " + n);
            sum += n;
            temp = n;
            if (temp > temp2) {
                temp2 = temp;
            }
        }while(n != 0);
        System.out.println("Sum:" + sum);
        System.out.println("Biggest generated number: " + temp2);
    }
    private static void fo() {
        Random ra = new Random();
        int value = (ra.nextInt(10)) - 10;
    }
    private static void ei() {
        int max = 4;
        for(int i = 0; i <= max; i++) {
            for(int j =0; j <= i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
    private static void ni() {
        Random raa = new Random();
        int k = raa.nextInt(10);
        for(int i = 0; i <= k; i++) {
            for(int j =0; j <= i; j++) {
                System.out.print(" ");
            }
            System.out.print(i);
            System.out.println();
        }
    }
}