package my.playground;
import java.util.ArrayList;
import java.util.List;

public class PlayerParser {

    private static String PLAYER_NAME_SEPARATOR = ":";
    private static String CARD_SEPARATOR = " ";

    public static Player fromString(String playerString) {
        String[] nameCardsSplit = playerString.split(PLAYER_NAME_SEPARATOR);
        String playerName = nameCardsSplit[0];
        String cardsString = nameCardsSplit[1].substring(1);

        return new Player(playerName, new Hand(getCardList(cardsString)));
    }

    private static List<Card> getCardList(String cardsString) {
        List<Card> cards = new ArrayList<>();
        String[] cardSplit = cardsString.split(CARD_SEPARATOR);
        for (String cardString : cardSplit) {
            cards.add(CardFactory.fromString(cardString));
        }
        return cards;
    }
}
