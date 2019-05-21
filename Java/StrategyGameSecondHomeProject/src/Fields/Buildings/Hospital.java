package Fields.Buildings;

import Players.Player;

import javax.swing.*;

public class Hospital extends Building {
    public Hospital(int locationX, int locationY, Player player) {
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
}
