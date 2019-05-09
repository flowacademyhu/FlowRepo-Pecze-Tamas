public class Main {
    public static int a = 2;
    public static void main(String[] args) {
        System.out.println(bunnyEars(20));;
    }
    public static int bunnyEars(int n) {
        if(n==1){
            return 1;
        }
        bunnyEars(n-1);
        a+=2;
        return a;
    }
}
