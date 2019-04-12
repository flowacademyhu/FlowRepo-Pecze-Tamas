public class Regeny extends Konyv implements Rendelheto {

    private String tartalmiOsszefoglalo;

    @Override
    public boolean dedikalASzerzo() {
        return true;
    }

    public Regeny(String szerzo, String cim, String tartalmiOsszefoglalo) {
        super(szerzo, cim);
        this.tartalmiOsszefoglalo = tartalmiOsszefoglalo;
    }

}
