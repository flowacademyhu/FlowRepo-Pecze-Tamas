package Fields.Units;

import Fields.Fields;
import Players.Player;

import javax.swing.*;

public class Unit extends Fields {
    protected int health;
    protected int price;
    protected int moveDistance;
    protected int locationX;
    protected int locationY;
    protected Player player;
    protected ImageIcon img;
    protected int dmg;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMoveDistance() {
        return moveDistance;
    }

    public void setMoveDistance(int moveDistance) {
        this.moveDistance = moveDistance;
    }

    public int getLocationX() {
        return locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "health=" + health +
                ", price=" + price +
                ", moveDistance=" + moveDistance +
                ", locationX=" + locationX +
                ", locationY=" + locationY +
                ", player=" + player +
                ", img=" + img +
                ", dmg=" + dmg +
                '}';
    }
}
