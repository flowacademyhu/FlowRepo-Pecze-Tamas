public class Practise2IntelliJ {
    public static void main(String[] args){
        int counter = 0;
        for(int i=0; i<args.length; i++) {
            counter++;
        }
        if(counter < 2) {
            System.out.println("Minimally two arguments needed!");
            System.exit(0);
        }
        int minimum = Integer.MAX_VALUE;
        for(int j=0; j<args.length; j++) {
            if(Integer.parseInt(args[j]) < minimum) {
                minimum = Integer.parseInt(args[j]);
            }
        }
        System.out.println(minimum);
    }
}
