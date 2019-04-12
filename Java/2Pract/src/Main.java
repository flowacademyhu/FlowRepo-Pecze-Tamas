public class Main {
  public static void main(String[] args) {
    System.out.println(args[]);
    // java Main.java 2
    // terminalban kiirja a kettot.
    // threeDotArrayParam("a","b","c","d","e","f");
    // a basiccal nem fut le, mert 1 tombot var ami stringekbol all
    // a String... akarmennyi tombel le fog futni csak string tipusu legyen
  }
public static void basicArrayParam(String[] strings) {
  for(String string: strings) {
    System.out.println(string);
  }
}
public static void threeDotArrayParam(String... strings){
  for(String string: strings) {
    System.out.println(string);
  }
}
}