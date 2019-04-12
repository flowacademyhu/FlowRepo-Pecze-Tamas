package penz;

public class Penz {
    private String nevertek;
    private boolean tipus;

    public Penz(String nevertek, boolean tipus) {
        this.nevertek = nevertek;
        this.tipus = tipus;
    }

    @Override
    public String toString() {
        return "Penz{" +
                "nevertek='" + nevertek + '\'' +
                ", tipus=" + tipus +
                '}';
    }
}

