package HarcosokKlubbja;

public class Harcos {

    private int utoero;
    private int egeszseg;

    public int getUtoero() {
        return utoero;
    }

    public void etUtoero(int utoero) {
        this.utoero = utoero;
    }

    public int getEgeszseg() {
        return egeszseg;
    }

    public void setEgeszseg(int egeszseg) {
        this.egeszseg = egeszseg;
    }

    public Harcos(int utoero, int egeszseg) {
        this.utoero = utoero;
        this.egeszseg = egeszseg;
    }

    @Override
    public String toString() {
        return "HarcosokKlubbja.Harcos vagyok, utoerom: " + utoero + " egeszseg: " + egeszseg;
    }



    public void megutN(Nagydarab nagy) {
        nagy.setEgeszseg(nagy.getEgeszseg() - this.utoero);
    }
}
