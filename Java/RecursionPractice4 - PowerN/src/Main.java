public class Main {
    private static int result = 1;
    public static void main(String[] args) {
        System.out.println(powerN(3,4));
    }
    public static int powerN(int base, int n) {

        if(n == 1) {
            return base;
        } else if (base == 1) {
            return 1;
        }
        if (n % 2 == 0) {
            result = powerN(base,n/2);
            return result*result;
        } else {
            return base * powerN(base, n-1);
        }
    }
    /*
    Given base and n that are both 1 or more, compute recursively (no loops) the value of base to the n power, so powerN(3, 2) is 9 (3 squared).

    powerN(3, 1) → 3
    powerN(3, 2) → 9
    powerN(3, 3) → 27

    StackOverFlow comment:
    When rewriting your function, don't lose sight of the main benefit of recursion in this case, which is to reduce the
    number of multiplication operations required. For example, if n = 8, then it is much more efficient to compute x * x
    as val1, then val1 * val1 as val2, and the final answer as val2 * val2 (3 multiplications) than to compute
    x * x * x * x * x * x * x * x (7 multiplications).

    This difference is trivial for small integers but matters if you put this operation inside a big loop, or if you
    replace the integers with very large number representations or maybe ginormous matrices.
    */
}
