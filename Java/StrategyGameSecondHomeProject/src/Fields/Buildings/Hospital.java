package Fields.Buildings;

import javax.swing.*;

public class Hospital extends Building {
    public Hospital(int hitPoints, int price, Color color) {
        super();
        if(this.color == Color.BLUE) {
            this.img = new ImageIcon("img/hqblue.png");
        } else {
            this.img = new ImageIcon("img/hqred.png");
        }
    }
}
