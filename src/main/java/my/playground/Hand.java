package my.playground;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Hand {

    private List<Card> cards;

    private Map<Card.CardValue,List<Card>> _cardGroupByValue;

    public Hand(List<Card> cards) {
        this.cards = this.sortedList(cards);
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

    public Map<Card.CardValue,List<Card>> cardGroupByValue() {
        if(_cardGroupByValue == null) {
            _cardGroupByValue = cards.stream()
                    .collect(groupingBy(Card::getValue, LinkedHashMap::new, Collectors.toList()));
        }
        return _cardGroupByValue;
    }

    public  List<Card> sortedList(List<Card> cards) {
        List<Card> sorted = new ArrayList<>(cards);
        sorted.sort(Card::compareTo);
        return sorted;
    }
}
