package my.playground.rules;

import my.playground.Card;
import my.playground.Hand;
import my.playground.Rank;

import java.util.List;
import java.util.Optional;

/**
 * Hands which do not fit any higher category are ranked by the value of their highest card.
 * If the highest cards have the same value, the hands are ranked by the next highest, and so on.
 */
public class HighCardRule implements GameRule {

    @Override
    public Rank evaluate(Hand hand) {
        List<Card> cards = hand.getCards();

        Optional<Card> highestCard = cards.stream().max(Card::compareTo);
        if(highestCard.isPresent()){
            return Rank.highCard(highestCard.get());
        }
        return null;
    }
}
