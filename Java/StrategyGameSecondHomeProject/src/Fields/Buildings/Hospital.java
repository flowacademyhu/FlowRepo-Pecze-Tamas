package Fields.Buildings;

import javax.swing.*;

public class Hospital extends Building {
    public Hospital(int locationX, int locationY, String color) {
        this.hitPoints = 300;
        this.price = 400;
        this.locationX = locationX;
        this.locationY = locationY;
        if(color.equals("BLUE")) {
            this.img = new ImageIcon("img/hqblue.png");
        } else {
            this.img = new ImageIcon("img/hqred.png");
        }
    }
}
