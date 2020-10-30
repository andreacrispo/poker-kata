package my.playground;

public class Game {

    private static RuleEngine ruleEngine;

    public Game(RuleEngine ruleEngine) {
        Game.ruleEngine = ruleEngine;
    }

    public GameResult play(Player playerOne, Player playerTwo) {
        Rank playerOneRank = ruleEngine.evaluate(playerOne.getHand());
        Rank playerTwoRank = ruleEngine.evaluate(playerTwo.getHand());

        if (playerOneRank.isHigherThen(playerTwoRank))
            return new Winner(playerOne, playerOneRank);

        if (playerTwoRank.isHigherThen(playerOneRank))
            return new Winner(playerTwo, playerTwoRank);


        return new Tie(playerOneRank);
    }

}

class GameResult {
    protected Rank rank;

    GameResult(Rank rank) {
        this.rank = rank;
    }
}

class Tie extends GameResult {
    Tie(Rank rank) {
        super(rank);
    }

    @Override
    public String toString() {
        return "Tie. - with " + rank.toString();
    }
}

class Winner extends GameResult {
    private final Player player;

    Winner(Player player, Rank rank) {
        super(rank);
        this.player = player;
    }

    @Override
    public String toString() {
        return player.getName() + " wins. - with " + rank.toString();
    }
}
