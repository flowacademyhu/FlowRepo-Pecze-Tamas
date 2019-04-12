public abstract class Hulladek {

    private final String HULLADEK_FEM = "fem";
    private final String HULLADEK_UVEG = "uveg";
    private String alapanyag;
    private String leiras;
    private int tomeg;

    public Hulladek(String alapanyag) {
        this.alapanyag = alapanyag;
        this.leiras = "";
        this.tomeg = 1;
    }
    public void megsemmisit() {
        System.out.println(alapanyag + leiras + tomeg);
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public String getAlapanyag() {
        return alapanyag;
    }

    public void setAlapanyag(String alapanyag) {
        this.alapanyag = alapanyag;
    }
}