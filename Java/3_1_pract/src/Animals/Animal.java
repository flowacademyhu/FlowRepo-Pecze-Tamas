package Animals;

public class Animal {

    private String name;

    private byte age;

    private String color;

    private float speed;

    public Animal() {

    }
    public Animal (String name) {
        this.name = name;
    }
    public Animal(String name, byte age, String color, float speed) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
