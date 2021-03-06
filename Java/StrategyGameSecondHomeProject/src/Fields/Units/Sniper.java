package Fields.Units;

import Players.Player;

import javax.swing.*;

public class Sniper extends Unit {
    public Sniper(int locationX, int locationY, Player player) {
        this.health = 30;
        this.maxhealth = 30;
        this.price = 60;
        this.locationX = locationX;
        this.locationY = locationY;
        this.dmg = 450;
        this.moveDistance = 1;
        this.player = player;
        if(player.getColor().equals("BLUE")) {
            this.img = new ImageIcon("img/blue-sniper-shadow.png");
        } else {
            this.img = new ImageIcon("img/red-sniper-shadow.png");
        }
        this.hasAttackedThisTurn = false;
    }
    @Override
    public String toString() {
        return "Sniper, HP:" + health + ", "+ getPlayer().getName();
    }
}
