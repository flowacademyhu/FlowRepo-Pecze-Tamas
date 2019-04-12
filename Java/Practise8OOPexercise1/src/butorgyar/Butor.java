package butorgyar;
import java.util.Arrays;
public class Butor {
    private int lap;
    private Butorlap[] lapok;
    public Butor() {
        this.lapok = new Butorlap[100];
        lap= 0;
    }
    public void laphozzaAd(Butorlap butorlap) {
        lapok[lap]=butorlap;
        this.lap++;    }
    public int arSzamol () {
        int szamol = 0;
        for (int i = 0; i < lap; i++) {
            szamol+= lapok[i].ArSzamol();
        }
        return szamol;
    }
    @Override
    public String toString() {
        return "Butor{ " +
                "lap= " + lap +
                ", Arszamol= " + arSzamol() +
                '}';
    }
}