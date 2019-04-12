import java.time.LocalDateTime;
public class Main {
  public static void main(String[] args) {
    char someChar = 'w';
    int meaningOfTheLife = 42;
    Integer maxValue = Integer.MAX_VALUE;
    LocalDateTime today = LocalDateTime.now();
    System.out.println(
      + someChar
      + "\n"
      + meaningOfTheLife
      + "\n"
      + maxValue
      + "\n"
      + today
    );
    System.out.println(
      (float) 2/3
      // Hardcast
    );
  }
}