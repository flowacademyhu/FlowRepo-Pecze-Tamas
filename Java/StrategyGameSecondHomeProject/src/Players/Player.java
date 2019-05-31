package Players;

import java.util.List;

public class Player {
    protected int GP;
    protected String name;
    protected String color;
    protected int numberOfHospitalsPresent;
    public Player() {
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

    public int getNumberOfHospitalsPresent() {
        return numberOfHospitalsPresent;
    }

    public void setNumberOfHospitalsPresent(int numberOfHospitalsPresent) {
        this.numberOfHospitalsPresent = numberOfHospitalsPresent;
    }
}
