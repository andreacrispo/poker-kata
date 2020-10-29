package my.playground;
import java.util.HashMap;
import java.util.Map;

public class CardFactory {

    private static final Map<Character, Card.CardValue> cardValueMapper  = new HashMap<Character, Card.CardValue>() {{
        put('2', Card.CardValue.Two);
        put('3', Card.CardValue.Three);
        put('4', Card.CardValue.Four);
        put('5', Card.CardValue.Five);
        put('6', Card.CardValue.Six);
        put('7', Card.CardValue.Seven);
        put('8', Card.CardValue.Eight);
        put('9', Card.CardValue.Nine);
        put('T', Card.CardValue.Ten);
        put('J', Card.CardValue.Jack);
        put('Q', Card.CardValue.Queen);
        put('K', Card.CardValue.King);
        put('A', Card.CardValue.Ace);
    }};

    private static final Map<Character, Card.Suit> suitMapper = new HashMap<Character, Card.Suit>() {{
        put('C', Card.Suit.Clubs);
        put('H', Card.Suit.Hearts);
        put('D', Card.Suit.Diamonds);
        put('S', Card.Suit.Spades);
    }};

    public static Card fromString(String cardString) {
        Card.CardValue value = cardValueMapper.get(cardString.charAt(0));
        Card.Suit suit = suitMapper.get(cardString.charAt(1));
        return new Card(value, suit);
    }


    public static Card twoOf(Card.Suit suit) {
        return new Card(Card.CardValue.Two, suit);
    }
    public static Card threeOf(Card.Suit suit) {
        return new Card(Card.CardValue.Three, suit);
    }
    public static Card fourOf(Card.Suit suit) {
        return new Card(Card.CardValue.Four, suit);
    }
    public static Card fiveOf(Card.Suit suit) {
        return new Card(Card.CardValue.Five, suit);
    }
    public static Card sixOf(Card.Suit suit) {
        return new Card(Card.CardValue.Six, suit);
    }
    public static Card sevenOf(Card.Suit suit) {
        return new Card(Card.CardValue.Seven, suit);
    }
    public static Card eightOf(Card.Suit suit) {
        return new Card(Card.CardValue.Eight, suit);
    }
    public static Card nineOf(Card.Suit suit) {
        return new Card(Card.CardValue.Nine, suit);
    }
}
