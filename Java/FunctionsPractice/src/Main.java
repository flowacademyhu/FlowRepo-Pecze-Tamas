import java.util.function.Function;
import java.util.function.IntUnaryOperator;

public class Main {
    private static final Function<Integer, Integer> TRICE_BOXED = x -> (3 * x);
    private static final IntUnaryOperator FOURTH = x -> ( 4 * x);
    private static final IntUnaryOperator TWO = x -> ( 2 * x);
    private static final IntUnaryOperator TRICE_BOXED_FOURTH = FOURTH.andThen(TWO);
    public static void main(String[] args) {
        System.out.println(TRICE_BOXED.apply(3));
        System.out.println(FOURTH.applyAsInt(3));
        System.out.println(TRICE_BOXED_FOURTH.applyAsInt(3));
    }
}
