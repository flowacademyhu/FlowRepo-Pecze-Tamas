package Fields.Units;

import Players.Player;

import javax.swing.*;

public class Soldier extends Unit {
    public Soldier(int locationX, int locationY, Player player) {
        this.health = 50;
        this.price = 40;
        this.locationX = locationX;
        this.locationY = locationY;
        this.dmg = 20;
        if(player.getColor().equals("BLUE")) {
            this.img = new ImageIcon("img/hqblue.png");
        } else {
            this.img = new ImageIcon("img/hqred.png");
        }
    }
}
