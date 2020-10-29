package my.playground;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerParserTest {

    @Test
    public void expect_one_player_with_one_card_four_of_clubs() {
        String playerString = "Mario: 4C";
        Player player = PlayerParser.createFromString(playerString);
        Card card = new Card(Card.CardValue.Four, Card.Suit.Clubs);
        assertEquals("Mario", player.getName());
        assertEquals(card, player.getHand().getCards().get(0));
    }

    @Test
    public void expect_one_player_with_two_card_two_of_diamond_seven_heart() {
        String playerString = "Mario: 2D 7H";
        Player player = PlayerParser.createFromString(playerString);
        Card cardOne = new Card(Card.CardValue.Two, Card.Suit.Diamonds);
        Card cardTwo = new Card(Card.CardValue.Seven, Card.Suit.Hearts);
        assertEquals("Mario", player.getName());
        assertEquals(cardOne, player.getHand().getCards().get(0));
        assertEquals(cardTwo, player.getHand().getCards().get(1));
    }
}