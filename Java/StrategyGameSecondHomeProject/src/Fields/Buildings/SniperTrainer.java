package Fields.Buildings;

import Players.Player;

import javax.swing.*;

public class SniperTrainer extends Building {
    public SniperTrainer(int locationX, int locationY, Player player) {
        this.hitPoints = 400;
        this.price = 250;
        this.locationX = locationX;
        this.locationY = locationY;
        this.player = player;
        if(player.getColor().equals("BLUE")) {
            this.img = new ImageIcon("img/hqblue.png");
        } else {
            this.img = new ImageIcon("img/hqred.png");
        }
    }

    @Override
    public String toString() {
        return "SniperTrainer, HP:" + hitPoints + " " + getPlayer().getName();
    }
}
