package Fields.Buildings;

import Players.Player;

import javax.swing.*;

public class Headquarter extends Building {
    public Headquarter(int locationX, int locationY, Player player) {
        this.hitPoints = 600;
        this.price = 200;
        this.locationX = locationX;
        this.locationY = locationY;
        this.player = player;
        if(player.getColor().equals("BLUE")) {
            this.img = new ImageIcon("img/blue-hq-shadow.png");
        } else {
            this.img = new ImageIcon("img/red-hq-shadow.png");
        }
    }
    @Override
    public String toString() {
        return "Headquarter, HP:" + hitPoints + " " + getPlayer().getName();
    }
}
