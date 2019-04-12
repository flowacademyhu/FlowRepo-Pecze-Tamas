package Animals;

public class Dog extends Animal {
    public Dog() {
        //super("Dog"); // a kozvetlen osre hivatkozik
        this.setName("Doggo");// az aktualis objektumra hivatkozik

    }
}