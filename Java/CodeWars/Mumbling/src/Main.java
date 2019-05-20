import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println(accum("sajt"));;
    }

    public static String accum(String s) {
        char re;
        String string = "";
        for (int i = 0; i < s.length(); i++) {
            re = s.charAt(i);
            for (int j = 0; j <= i; j++) {
                if(j==0) {
                    string += Character.toUpperCase(re);
                } else {
                    string += Character.toLowerCase(re);
                }
            }
            if(i < s.length()-1) {
                string += '-';
            }
        }
        return string;
    }
}