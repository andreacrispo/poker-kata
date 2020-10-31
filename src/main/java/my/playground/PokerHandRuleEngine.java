package my.playground;

import my.playground.rules.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

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
        // With this version the order declaration of the rules is not important
        // but they will evaluate also when not necessary
        return gameRules.stream()
                .map(rules -> rules.evaluate(hand))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .max(Rank::compareTo)
                .get();

        // Meanwhile with this version the order declaration of the rules is important!
        // but they will not evaluate if not necessary

//        return gameRules.stream()
//                .map(rules -> rules.evaluate(hand))
//                .filter(Optional::isPresent)
//                .findFirst()
//                .flatMap(Function.identity())
//                .get();
    }

}
