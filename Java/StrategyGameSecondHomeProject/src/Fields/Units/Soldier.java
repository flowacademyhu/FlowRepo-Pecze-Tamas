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
        this.moveDistance = 2;
        this.player = player;
        if(player.getColor().equals("BLUE")) {
            this.img = new ImageIcon("img/blue-soldier-shadow.png");
        } else {
            this.img = new ImageIcon("img/red-soldier-shadow.png");
        }

    }
    @Override
    public String toString() {
        return "Soldier, HP:" + health + ", "+ getPlayer().getName();
    }
}
