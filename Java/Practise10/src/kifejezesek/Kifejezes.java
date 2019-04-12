package kifejezesek;

public class Kifejezes {
    //reprezentalom a konstans kifejezeseket
    public void setA(int a) {
        this.a = a;
    }

    private int a;

    public Kifejezes() {
        this.a = 0;
    }
    public Kifejezes(int a) {
        this.a = a;
    }
    public int getA() {
        return a;
    }

    @Override
    public String toString() {
        return String.valueOf(this.a);
    }
}
