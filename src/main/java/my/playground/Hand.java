package my.playground;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class Hand {

    private List<Card> cards;
    private Map<Card.CardValue,List<Card>> _groupCardByValue;
    private Card _highestCard;

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
        if(_highestCard == null){
            _highestCard = this.cards.stream()
                                    .max(Card::compareTo)
                                    .get();
        }
        return _highestCard;
    }

    public Map<Card.CardValue,List<Card>> groupCardByValue() {
        if(_groupCardByValue == null) {
            _groupCardByValue = cards.stream()
                    .collect(groupingBy(Card::getValue, LinkedHashMap::new, toList()));
        }
        return _groupCardByValue;
    }


    public List<Card> cardsEqualValueTwoByTwo() {
        return this.cardsEqualValueSizeBySize(2);
    }
    public List<Card> cardsEqualValueThreeByThree() {
        return this.cardsEqualValueSizeBySize(3);
    }
    public List<Card> cardsEqualValueFourByFour() {
        return this.cardsEqualValueSizeBySize(4);
    }

    private List<Card> cardsEqualValueSizeBySize(int size) {
       return this.groupCardByValue().values().stream()
               .filter(cards -> cards.size() == size)
               .flatMap(List::stream)
               .collect(toList());
    }

    public List<Card> allCardsExcept(List<Card> exclude) {
        return cards.stream()
                .filter(card -> !exclude.contains(card))
                .collect(toList());
    }

    public  List<Card> sortedList(List<Card> cards) {
        List<Card> sorted = new ArrayList<>(cards);
        sorted.sort(Card::compareTo);
        return sorted;
    }
}
