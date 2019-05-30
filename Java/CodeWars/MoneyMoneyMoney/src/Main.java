public class Main {

    public static void main(String[] args) {
        int count = 0;
        System.out.println(calculateYears(1000.00,0.05,0.18,1100.00));
}
    public static int calculateYears(double principal, double interest,  double tax, double desired) {
        if(principal == desired) {
            return 0;
        }
        int counter = 0;
        return call(principal,counter,desired,interest,tax);
    }
private static int call(double principal, int counter, double desired, double interest, double tax) {
    if(principal > desired) {
        return counter;
    }
    principal += (principal*interest)-((principal*interest) * tax);
    counter++;

    return call(principal,counter++,desired,interest,tax);
}
}