public class Main {
    private String x;

    public static void main(String[] args) {
        counting2("1111");
    }

    public static void counting2(String x) {
        int value = 1;
        int expectedoutput = 1;
        for(int i = x.length() - 1; i >= 0; i--) {
            if (x.charAt(i) == '1') {
                expectedoutput *= 2;
            }
        }
        System.out.println(x.charAt(0));
        if(x.charAt(0) == '1'){
            expectedoutput -= 1;
        }
        System.out.println(expectedoutput);
    }
}
