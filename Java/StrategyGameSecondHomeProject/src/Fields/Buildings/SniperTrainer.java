package Fields.Buildings;

import javax.swing.*;

public class SniperTrainer extends Building {
    public SniperTrainer(int hitPoints, int price) {
        super();
        if(this.color == Color.BLUE) {
            this.img = new ImageIcon("img/hqblue.png");
        } else {
            this.img = new ImageIcon("img/hqred.png");
        }
    }
}
