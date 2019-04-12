public class CD implements Rendelheto {
    String neve;
    String albumCim;

    public CD(String neve, String albumCim) {
        this.neve = neve;
        this.albumCim = albumCim;
    }

    @Override
    public String toString() {
        return "CD{" +
                "neve='" + neve + '\'' +
                ", albumCim='" + albumCim + '\'' +
                '}';
    }

    public String getNeve() {
        return neve;
    }

    public void setNeve(String neve) {
        this.neve = neve;
    }

    public String getAlbumCim() {
        return albumCim;
    }

    public void setAlbumCim(String albumCim) {
        this.albumCim = albumCim;
    }
}
