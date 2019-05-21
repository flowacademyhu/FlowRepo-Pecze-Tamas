package Fields.Buildings;

import Fields.Fields;
import Players.Player;

import javax.swing.*;

public class Building extends Fields {
    protected int hitPoints;
    protected int price;
    protected int locationX;
    protected int locationY;
    protected ImageIcon img;
    protected Player player;

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public ImageIcon getImg() { return img; }

    public void setImg(ImageIcon img) {
        this.img = img;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
