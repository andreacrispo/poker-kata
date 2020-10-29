package my.playground;
import java.util.List;

public class Hand {

    private List<Card> cards;

    public Hand(List<Card> cards) {
       /// cards.sort(Card::compareTo);
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Card getHighestCard() {
        return this.cards.stream()
                    .max(Card::compareTo)
                    .get();
    }

}
