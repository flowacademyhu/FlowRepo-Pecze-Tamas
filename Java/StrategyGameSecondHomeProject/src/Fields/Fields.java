package Fields;

import javax.swing.*;

public class Fields {

    ImageIcon img = new ImageIcon("img/hq1red.png");

    private boolean used = false;

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public Fields(boolean used) {
        this.used = used;
    }

    public ImageIcon getImg() {
        return img;
    }

    public void setImg(ImageIcon img) {
        this.img = img;
    }

    public Fields() {
    }

    @Override
    public String toString() {
        return "Empty field";
    }
}
