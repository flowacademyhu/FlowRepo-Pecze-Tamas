public class Main {
    public static void main(String[] args) {
        public static int calculateYears(double principal, double interest,  double tax, double desired) {
            int counter = 0;
            return call(principal,counter,desired,interest,tax);
        }
    }public static int call(double principal, int counter, double desired, double interest, double tax) {
        if(principal > desired) {
            return counter;
        }
        principal =+ (principal*interest) * tax;
        counter++;
        call(principal);
    }
}
/*
public class Money {
  public static int calculateYears(double principal, double interest,  double tax, double desired) {
    int counter = 0;
    return call(principal,counter,desired,interest,tax,);
    }

  public static int call(double principal, int counter, double desired, double interest, double tax) {
    if(principal > desired) {
      return counter;
    }
    principal =+ (principal*interest) * tax;
    call(principal,counter,desired,interest,tax);
    return counter;
  }
}
 */
