package my.playground.rules;

import my.playground.Hand;
import my.playground.Rank;

public class StraightFlushRule implements GameRule {

    @Override
    public Rank evaluate(Hand hand) {
        if(new StraightRule().evaluate(hand) == null)
            return null;
        if(new FlushRule().evaluate(hand) == null)
            return null;

        return Rank.straightFlush(hand.getHighestCard());
    }
}
