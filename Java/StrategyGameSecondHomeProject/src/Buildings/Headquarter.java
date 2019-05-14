package Buildings;

import javax.swing.*;

public class Headquarter extends Building {
    public Headquarter(int locationX, int locationY) {
        this.hitPoints = 300;
        this.price = 400;
        this.locationX = locationX;
        this.locationY = locationY;
        this.img = new ImageIcon("img/hq1.png");
    }

}
