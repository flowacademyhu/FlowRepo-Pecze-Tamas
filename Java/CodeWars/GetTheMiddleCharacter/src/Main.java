public class Main {
    public static void main(String[] args) {
        System.out.println(Str("world"));
    }
    StringBuilder
    private static String Str(String world) {
        for (int i = 0; i < world.length() - 1; i++) {
            world = world.substring(1,world.length());
            world = world.substring(world.length()-1,world.length());
        }
        return world;
    }
}
