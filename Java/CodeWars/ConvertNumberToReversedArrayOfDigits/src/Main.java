import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int a[] = digitalize(35231);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
    public static int[] digitalize(long n) {
        String convert = Long.toString(n);
        int [] arr = new int[convert.length()];
        int counter = 0;
       while(n>0) {
           Long i = n % 10;
           n= n/10;
           arr[counter] = Math.toIntExact(i);
           counter++;
       }
       return arr;
    }
}
