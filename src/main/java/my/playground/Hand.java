package my.playground;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Hand {

    private List<Card> cards;

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

    public Map<Card.CardValue, Integer> cardValuesOccurrences() {
        Map<Card.CardValue, Integer> occurrences = new HashMap<>();

        for(Card card : getCards()){
            if(occurrences.containsKey(card.getValue())){
                occurrences.put(card.getValue(), occurrences.get(card.getValue()) +1);
            }else {
                occurrences.put(card.getValue(), 1);
            }
        }
        return occurrences;
    }

    public Map<Card.CardValue,List<Card>> cardGroupByValue() {
        return cards.stream()
                    .collect(groupingBy(Card::getValue, LinkedHashMap::new, Collectors.toList()));
    }

    public  List<Card> sortedList(List<Card> cards) {
        List<Card> sorted = new ArrayList<>(cards);
        sorted.sort(Card::compareTo);
        return sorted;
    }
}
