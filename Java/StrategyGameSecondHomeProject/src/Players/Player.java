package Players;

import java.util.List;

public class Player {
    private int GP;
    private String name;
    private String color;
    private List<String> buildings;

    public Player(String name) {
        this.GP = 1000;
        this.name = name;
    }

    public int getGP() {
        return GP;
    }

    public void setGP(int GP) {
        this.GP = GP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
