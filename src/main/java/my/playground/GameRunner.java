
package my.playground;
public class GameRunner {

    private static final String PLAYER_SEPARATOR = "  ";

    public String run(String gameInput) {
        String[] playerSplit = gameInput.split(PLAYER_SEPARATOR);
        Player playerOne = getPlayer(playerSplit[0]);
        Player playerTwo = getPlayer(playerSplit[1]);

        RuleEngine ruleEngine = new RuleEngine();

        Rank playerOneRank = ruleEngine.evaluate(playerOne.getHand());
        Rank playerTwoRank = ruleEngine.evaluate(playerTwo.getHand());

        String gameResult = "";
        if(playerOneRank.isHigherThen(playerTwoRank)) {
            gameResult = playerOne.getName() + " wins. - with " + playerOneRank.toString();
        } else if(playerTwoRank.isHigherThen(playerOneRank)) {
            gameResult = playerTwo.getName() + " wins. - with " + playerTwoRank.toString();
        }else {
            gameResult =  "Tie. - with " + playerOneRank.toString();
        }
        System.out.println(gameResult);


        return gameResult;
    }

    private Player getPlayer(String playerString) {
        return  PlayerParser.fromString(playerString);
    }
}
