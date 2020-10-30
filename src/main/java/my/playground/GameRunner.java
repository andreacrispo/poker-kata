
package my.playground;
public class GameRunner {

    private static final String PLAYER_SEPARATOR = "  ";

    public String run(String gameInput) {
        String[] playerSplit = gameInput.split(PLAYER_SEPARATOR);
        Player playerOne = getPlayer(playerSplit[0]);
        Player playerTwo = getPlayer(playerSplit[1]);

        Game game = new Game(new PokerHandRuleEngine());

        GameResult result = game.play(playerOne, playerTwo);

        return result.toString();
    }

    private Player getPlayer(String playerString) {
        return  PlayerParser.fromString(playerString);
    }
}
