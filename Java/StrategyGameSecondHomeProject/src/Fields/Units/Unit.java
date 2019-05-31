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
    protected boolean hasAttackedThisTurn;
    protected int maxhealth;

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public boolean isHasAttackedThisTurn() {
        return hasAttackedThisTurn;
    }

    public void setHasAttackedThisTurn(boolean hasAttackedThisTurn) {
        this.hasAttackedThisTurn = hasAttackedThisTurn;
    }

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
    public ImageIcon getImg() {
        return img;
    }

    @Override
    public void setImg(ImageIcon img) {
        this.img = img;
    }

    public int getMaxhealth() {
        return maxhealth;
    }

    public void setMaxhealth(int maxhealth) {
        this.maxhealth = maxhealth;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "health=" + health +
                ", locationX=" + locationX +
                ", locationY=" + locationY +
                ", player=" + player +
                '}';
    }
}
