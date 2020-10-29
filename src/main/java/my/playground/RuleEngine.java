package my.playground;

import my.playground.rules.GameRule;
import my.playground.rules.HighCardRule;
import my.playground.rules.PairRule;
import my.playground.rules.ThreeOfKindRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

public class RuleEngine {

    List<GameRule> gameRules = asList(
            new ThreeOfKindRule(),
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
