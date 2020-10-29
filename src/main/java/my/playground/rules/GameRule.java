package my.playground.rules;

import my.playground.Hand;
import my.playground.Rank;

public interface GameRule {

    Rank evaluate(Hand hand);
}
