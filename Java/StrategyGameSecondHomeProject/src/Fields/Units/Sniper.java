package Fields.Units;

import Players.Player;

import javax.swing.*;

public class Sniper extends Unit {
    public Sniper(int locationX, int locationY, Player player) {
        this.health = 30;
        this.price = 60;
        this.locationX = locationX;
        this.locationY = locationY;
        this.dmg = 45;
        this.moveDistance = 1;
        this.player = player;
        if(player.getColor().equals("BLUE")) {
            this.img = new ImageIcon("img/blue-soldier-shadow.png");
        } else {
            this.img = new ImageIcon("img/blue-soldier-shadow.png");
        }
    }
    @Override
    public String toString() {
        return "Sniper, HP:" + health + ", "+ getPlayer().getName();
    }
}
