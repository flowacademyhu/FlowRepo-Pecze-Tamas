public abstract class Konyv {

    protected String szerzo;
    protected String cim;
    abstract boolean dedikalASzerzo();

    public Konyv(String szerzo, String cim) {
        this.szerzo = szerzo;
        this.cim = cim;
    }

    public String getSzerzo() {
        return szerzo;
    }

    public void setSzerzo(String szerzo) {
        this.szerzo = szerzo;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }
}
