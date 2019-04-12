package HarcosokKlubbja;

public class Nagydarab extends Harcos {

    private int allokepesseg;

    public int getAllokepesseg() {
        return allokepesseg;
    }

    public void setAllokepesseg(int allokepesseg) {
        this.allokepesseg = allokepesseg;
    }

    public Nagydarab(int utoero, int egeszseg, int allokepesseg) {
        super(utoero, egeszseg);
        this.allokepesseg = allokepesseg;
        setEgeszseg(getEgeszseg() + allokepesseg);
    }

    @Override
    public String toString() {
        return " FYI: Nagydarab harcosrol van szo. Allokepessege: " + allokepesseg + " egeszsege: "
                + getEgeszseg() + " utoero: " + getUtoero();
    }
    public void megutH(Harcos harcos) {
        harcos.setEgeszseg(harcos.getEgeszseg()-this.getUtoero());
    }

}
