package Fields.Units;

import javax.swing.*;

public class Soldier extends Unit {
    public Soldier(int locationX, int locationY, String color) {
        this.health = 50;
        this.price = 40;
        this.locationX = locationX;
        this.locationY = locationY;
        this.dmg = 20;
        if(color.equals("BLUE")) {
            this.img = new ImageIcon("img/hqblue.png");
        } else {
            this.img = new ImageIcon("img/hqred.png");
        }
    }
}
