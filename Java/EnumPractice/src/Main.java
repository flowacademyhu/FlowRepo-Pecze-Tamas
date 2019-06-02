import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        deck().forEach(e-> System.out.println(e.suit.toString()));
    }
    public enum Suit{
        HEARTS,
        DIAMONDS,
        SPADES,
        CLUBS
    }
    public enum Rank{
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

    static class Card {
        final Suit suit;
        final Rank rank;

        Card(Suit suit, Rank rank) {
            this.suit = suit;
            this.rank = rank;
        }
    }
    static List<Card> deck() {
        List<Card> deck = new ArrayList<>();
        for(var suit: Suit.values()) {
            for (var rank: Rank.values()){
                deck.add(new Card(suit,rank));
            }
        }
        return deck;
    }
}
