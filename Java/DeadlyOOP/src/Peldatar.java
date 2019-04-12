public class Peldatar extends Konyv {

    private int valtozo;

    public Peldatar(String szerzo, String cim, int valtozo) {
        super(szerzo, cim);
        this.valtozo = valtozo;
    }

    public int getValtozo() {
        return valtozo;
    }

    public void setValtozo(int valtozo) {
        this.valtozo = valtozo;
    }

    @Override
    public String toString() {
        return "Peldatar{" +
                "valtozo=" + valtozo +
                ", szerzo='" + szerzo + '\'' +
                ", cim='" + cim + '\'' +
                '}';
    }

    @Override
    boolean dedikalASzerzo() {
        return false;
    }
}
