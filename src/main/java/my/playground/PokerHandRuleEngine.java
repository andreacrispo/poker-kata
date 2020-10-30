package my.playground;

import my.playground.rules.*;

import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

public class PokerHandRuleEngine implements RuleEngine {

    List<GameRule> gameRules = asList(
            new StraightFlushRule(),
            new FourOfKindRule(),
            new FullHouseRule(),
            new FlushRule(),
            new StraightRule(),
            new ThreeOfKindRule(),
            new TwoPairRules(),
            new PairRule(),
            new HighCardRule()
    );

    public Rank evaluate(Hand hand) {
        return gameRules.stream()
                .map(rules -> rules.evaluate(hand))
                .filter(Objects::nonNull)
                .max(Rank::compareTo)
                .get();
    }

}
