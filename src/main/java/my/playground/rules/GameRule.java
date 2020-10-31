package my.playground.rules;

import my.playground.Hand;
import my.playground.Rank;

import java.util.Optional;

public interface GameRule {

  Optional<Rank> evaluate(Hand hand);
}
