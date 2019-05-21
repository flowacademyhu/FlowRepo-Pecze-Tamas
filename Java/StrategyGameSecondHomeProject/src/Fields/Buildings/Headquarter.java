package Fields.Buildings;

import Players.Player;

import javax.swing.*;

public class Headquarter extends Building {
    public Headquarter(int locationX, int locationY, Player player) {
        this.hitPoints = 300;
        this.price = 400;
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
        return "Headquarter{" +
                "hitPoints=" + hitPoints +
                ", locationX=" + locationX +
                ", locationY=" + locationY +
                ", player='" + player + '\'' +
                '}';
    }
}
