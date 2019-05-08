package Units;

public class Unit {
    private int health;
    private int price;
    private int moveDistance;

    public Unit(int health, int price, int moveDistance) {
        this.health = health;
        this.price = price;
        this.moveDistance = moveDistance;
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
}
