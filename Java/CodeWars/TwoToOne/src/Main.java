import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println(longest("inmanylanguages", "theresapairoffunctions"));
    }

    public static String longest(String s1, String s2) {
        String tempA = "";
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s1.length(); j++) {
                if (s1.substring(i, i + 1).equals(s1.substring(j, j + 1))) {
                    tempA.concat(s1.substring(i, i + 1));
                    s1 = s1.replace(s1.substring(j, j + 1), "");
                }
            }
        }
        String tempB = "";
        for (int i = 0; i < s2.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s2.substring(i, i + 1).equals(s2.substring(j, j + 1))) {
                    tempB.concat(s2.substring(i, i + 1);
                    s2 = s2.replace(s2.substring(j, j + 1), "");
                    s2 = s2.concat(temp);
                }
            }
        }
        char tempArrayA[] = s1.toCharArray();
        char tempArrayB[] = s2.toCharArray();

        Arrays.sort(tempArrayA);
        Arrays.sort(tempArrayB);
        s1 = new String(tempArrayA);
        s2 = new String(tempArrayB);
        if (s1.length() < s2.length()) {
            System.out.println("elso s1");
            return s1;
        } else {
            return s2;
        }
    }
}
