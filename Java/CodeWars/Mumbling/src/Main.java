import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //System.out.println(accum("sajt"));
        LocalDate date = LocalDate.now();
        System.out.println(date.plusMonths(1));
    }

    public static String accum(String s) {
        char re;
        String string = "";
        for (int i = 0; i < s.length(); i++) {
            re = s.charAt(i);
            System.out.println(re);
            for (int j = 0; j <= i; j++) {
                if(j==0) {
                    string += Character.toUpperCase(re);
                } else {
                    string += re;
                }
            }
            if(i < s.length()) {
                string += '-';
            }
        }
        return string;
    }
}