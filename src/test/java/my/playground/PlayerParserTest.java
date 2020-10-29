package my.playground;
import org.junit.Test;

import static my.playground.Card.Suit.*;
import static my.playground.CardFactory.*;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerParserTest {

    @Test
    public void expect_one_player_with_one_card_four_of_clubs() {
        String playerString = "Mario: 4C";
        Player player = PlayerParser.fromString(playerString);
        Card card = new Card(Card.CardValue.Four, Card.Suit.Clubs);
        assertEquals("Mario", player.getName());
        assertEquals(card, player.getHand().getCards().get(0));
    }

    @Test
    public void expect_one_player_with_two_card_two_of_diamond_seven_heart() {
        String playerString = "Mario: 2D 7H";
        Player player = PlayerParser.fromString(playerString);
        Card cardOne = new Card(Card.CardValue.Two, Diamonds);
        Card cardTwo = new Card(Card.CardValue.Seven, Card.Suit.Hearts);
        assertEquals("Mario", player.getName());
        assertEquals(cardOne, player.getHand().getCards().get(0));
        assertEquals(cardTwo, player.getHand().getCards().get(1));
    }


    @Test
    public void expect_one_player_with_three_card_two_of_diamond_seven_of_heart_five_of_clubs() {
        String playerString = "Mario: 2D 7H 5C";
        Player player = PlayerParser.fromString(playerString);
        Card cardOne = twoOf(Diamonds);
        Card cardTwo = sevenOf(Hearts);
        Card cardThree = fiveOf(Clubs);
        assertEquals("Mario", player.getName());
        assertEquals(cardOne, player.getHand().getCards().get(0));
        assertEquals(cardTwo, player.getHand().getCards().get(1));
        assertEquals(cardThree, player.getHand().getCards().get(2));
    }

    @Test
    public void expect_one_player_with_four_card() {
        String playerString = "Frank: 2D 7H 5C 9C";
        Player player = PlayerParser.fromString(playerString);
        assertEquals("Frank", player.getName());
        assertEquals(twoOf(Diamonds), player.getHand().getCards().get(0));
        assertEquals(sevenOf(Hearts), player.getHand().getCards().get(1));
        assertEquals(fiveOf(Clubs), player.getHand().getCards().get(2));
        assertEquals(nineOf(Clubs), player.getHand().getCards().get(3));
    }
}