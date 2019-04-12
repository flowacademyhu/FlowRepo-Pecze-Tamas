public class Practise5Heron {
    public static void main(String[] args){
        if(args.length < 3) {
            System.out.print("Error, minimum 3 arguments required");
        } else {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int c = Integer.parseInt(args[2]);
            double s = (a+b+c)/2;
            double heron = Math.sqrt(s*(s-a)*(s-b)*(s-c));
            System.out.println(heron);
        }
    }
}
