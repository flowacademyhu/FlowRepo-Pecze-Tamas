public class Cat {
    private int id;
    private String name;
    private String color;
    private int age;

    public Cat(int id, String name, String color, int age) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cats id:" + id + ", name: " + name + ", color:'" + color + "age: " + age;
    }
}
