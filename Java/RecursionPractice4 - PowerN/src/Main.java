public class Main {
    private static int result = 1;

    public static void main(String[] args) {
        System.out.println(powerN(3,3));
    }
    public static int powerN(int base, int n) {
        if(n == 1) {
            return base;
        } else if (base == 1) {
            return 1;
        }
        // hate Mathematics
        powerN(base, n-1);
        return result;
    }
}
