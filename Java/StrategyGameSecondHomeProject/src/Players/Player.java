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
}
