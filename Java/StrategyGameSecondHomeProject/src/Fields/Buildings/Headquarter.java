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
            this.img = new ImageIcon("img/korhaz.png");
        } else {
            this.img = new ImageIcon("img/korhazblue.png");
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
