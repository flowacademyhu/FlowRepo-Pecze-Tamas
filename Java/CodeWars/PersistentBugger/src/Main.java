
public class Main {
    public static void main(String[] args) {
        System.out.println(persistence(25));
    }
    public static int persistence(long n) {
        if(n >= 10) {
            int firstDigit = Integer.parseInt(Long.toString(n).substring(0, 1));
            int secondDigit = Integer.parseInt(Long.toString(n).substring(1, 2));
            int sum = firstDigit * secondDigit;
            while(sum >= 10) {
                firstDigit = (int)Math.ceil(firstDigit/2.00);
                secondDigit = (int)Math.ceil(secondDigit/2.00);
                sum = firstDigit * secondDigit;
                System.out.println(firstDigit + " : " + secondDigit);
            }
            return (int)firstDigit * (int)secondDigit;
        } else if (n >= 100) {
        } else if (n >= 1000) {
        } else {
        } return 0;
    }
}
