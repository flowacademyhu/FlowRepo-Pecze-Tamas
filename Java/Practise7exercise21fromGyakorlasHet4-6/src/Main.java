public class Main {
    public static void main(String[] args) {
    int first = Integer.parseInt(args[0]);
    String operator = args[1];
    int second = Integer.parseInt(args[2]);
    task(first, operator, second);
    }

    private static void task(int f, String o, int s) {
        if(o.equals("+")){
            System.out.println(f+s);
        } else if(o.equals("-")){
            System.out.println(f-s);
        } else if(o.equals("x")) {
            System.out.println(f * s);
        } else if(o.equals("/")) {
            System.out.println(f / s);
        } else {
            System.out.println("Invalid input");
        }
    }
}
