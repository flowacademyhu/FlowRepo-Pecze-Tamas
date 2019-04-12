package kifejezesek;

public class Muvelet extends Kifejezes {
    boolean isKiertekeles = false;

    public int getA1() {
        return a1;
    }

    public void setA1(int a1) {
        this.a1 = a1;
    }

    public int getA2() {
        return a2;
    }

    public void setA2(int a2) {
        this.a2 = a2;
    }

    public Muvelet(int a, int a1, int a2) {
        super(a);
        this.a1 = a1;
        this.a2 = a2;
    }

    private int a1;
    private int a2;

    public void Operator () {
        isKiertekeles = true;
    }
}

