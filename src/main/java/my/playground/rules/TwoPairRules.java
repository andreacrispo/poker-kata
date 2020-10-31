package my.playground.rules;

import my.playground.Card;
import my.playground.Hand;
import my.playground.Rank;

import java.util.List;
import java.util.Optional;

/**
 * Two Pairs: The hand contains 2 different pairs. Hands which both contain 2 pairs are ranked by the value of their highest pair. Hands with the same highest pair are ranked by the value of their other pair.
 * If these values are the same the hands are ranked by the value of the remaining card.
 */
public class TwoPairRules implements GameRule {

    @Override
    public Optional<Rank> evaluate(Hand hand) {
        List<Card> pair = hand.cardsEqualValueTwoByTwo();
        if(pair.size() == 4) {
            List<Card> kickers = hand.allCardsExcept(pair);
            Card highestKicker = kickers.stream().max(Card::compareTo).get();
            return Optional.of(Rank.twoPair(pair.get(0), pair.get(3), highestKicker));
        }

        return Optional.empty();
    }

}
