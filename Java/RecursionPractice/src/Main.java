public class Main {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
    public static int factorial (int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    /*

    f(5) = 5*f(4)= 5*4*f(3) = 5 * 4 * 3 * f(2)... =
    f(1)=1;
    f(2)=2*1 = 2;
    f(3)= 3*2
    f(4)= 4*3
    f(5)=5*4
     */
}
