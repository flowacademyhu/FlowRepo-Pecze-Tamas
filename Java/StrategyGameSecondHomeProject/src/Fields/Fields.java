package Fields;

import Fields.Buildings.Building;
import Fields.Buildings.Headquarter;
import GameArea.GameArea;
import GameLoop.GameLoop;
import Players.Player;

import javax.swing.*;

public class Fields {

    ImageIcon img = new ImageIcon("img/hqred.png");

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
    public JLabel convert(Headquarter h) {
        JLabel label = new JLabel();
        label.setIcon(h.getImg());
        return label;
    }

    public ImageIcon getImg() {
        return img;
    }

    public void setImg(ImageIcon img) {
        this.img = img;
    }

    public Fields() {
    }
}
