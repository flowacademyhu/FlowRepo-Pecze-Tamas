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
/*
We have a number of bunnies and each bunny has two big floppy ears. We want to compute the total number of ears across
all the bunnies recursively (without loops or multiplication).

bunnyEars(0) → 0
bunnyEars(1) → 2
bunnyEars(2) → 4
*/