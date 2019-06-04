import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(10));
    }
    public static int solution(int number) {
        List<Integer> r = new ArrayList<Integer>();
        for (int i = 0; i < number; i++) {
            if(i % 3 == 0 && i % 5 == 0) {
                r.add(i);
            } else if(i % 3 == 0) {
                r.add(i);
            } else if(i % 5 == 0) {
                r.add(i);
            }
        }
        return r.stream().mapToInt(Integer::intValue).sum();
    }
}
