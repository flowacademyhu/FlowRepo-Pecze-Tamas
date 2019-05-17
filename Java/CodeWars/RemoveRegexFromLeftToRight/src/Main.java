public class Main {
    public static void main(String[] args) {
        System.out.println(remove("!hello!!",3));
    }

    private static String remove(String s, int n) {
        for(int i = 0; i < n; i++) {
            s = s.replaceFirst("!","");
        }
        return s;
    }
}
