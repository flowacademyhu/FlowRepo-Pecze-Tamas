import butorgyar.Butor;
import butorgyar.Butorlap;public class Main {
    public static void main (String... args) {
        Butor butor = new Butor();
        Butorlap butorlap = new Butorlap(234000,233000,true);
        Butorlap butorlap2 = new Butorlap(2840,230003,false);
        butor.laphozzaAd(butorlap);
        butor.laphozzaAd(butorlap2);
        System.out.println(butor.toString());    }
}