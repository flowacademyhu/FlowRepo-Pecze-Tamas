import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 133, 1};
        Arrays.sort(arr);
        System.out.println(sum(arr));

    }

    private static int sum(int[] arr) {
        int sum = 0;
        for(int i = 1; i < arr.length - 1; i++) {
            System.out.println(arr[i]);
            sum += arr[i];
        }
        return sum;
    }
}
