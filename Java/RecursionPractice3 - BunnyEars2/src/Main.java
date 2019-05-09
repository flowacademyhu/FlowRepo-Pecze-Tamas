public class Main {
    public static int result = 5;
    public static void main(String[] args) {
        System.out.println(BunnyEarsTwo(10));
    }

    private static int BunnyEarsTwo(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 2;
        } else if (n == 2) {
            return 5;
        }
        if(n % 2 == 1) {
            result += 3;
        } else {
            result += 2;
        }
        BunnyEarsTwo(n-1);
        return result;
    }
}
/*
We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..) have the normal 2 ears. The even
bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot. Recursively return the number of "ears"
in the bunny line 1, 2, ... n (without loops or multiplication).
bunnyEars2(0) → 0
bunnyEars2(1) → 2
bunnyEars2(2) → 5
*/
