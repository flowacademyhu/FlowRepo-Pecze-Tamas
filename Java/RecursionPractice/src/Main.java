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

    f(5) = 5*f(4) -> 5*30 = 120!!!!
    f(4) = 4*f(3) -> 4*6 = 30
    f(3) = 3*f(2) -> 3*2 = 6
    f(2) = 2*f(1) -> 2*1 = 2
    f(1) = 1 (returns 1)

    Given n of 1 or more, return the factorial of n, which is n * (n-1) * (n-2) ... 1.
    Compute the result recursively (without loops).

    factorial(1) → 1
    factorial(2) → 2
    factorial(3) → 6
     */
}
