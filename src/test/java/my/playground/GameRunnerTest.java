package my.playground;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameRunnerTest {

    @Test
    public void expect_player_one_win_with_high_card_seven() {
        String gameInput = "Black: 7H 3D 4H  White: 2C 3H 5D";
        GameRunner gameRunner = new GameRunner();

        String result = gameRunner.run(gameInput);

        String expectedResult = "Black wins. - with high card: Seven";
        assertEquals(expectedResult, result);
    }


    @Test
    public void expect_player_two_win_with_pair_of_two() {
        String gameInput = "Black: 7H 3D 2D  White: 2C 2H 5C";
        GameRunner gameRunner = new GameRunner();

        String result = gameRunner.run(gameInput);

        String expectedResult = "White wins. - with pair: Two";
        assertEquals(expectedResult, result);
    }

    @Test
    public void expect_player_two_win_with_three_of_kind() {
        String gameInput = "Black: 7H 3D 3H  White: 4C 4H 4D";
        GameRunner gameRunner = new GameRunner();

        String result = gameRunner.run(gameInput);

        String expectedResult = "White wins. - with three of kind: Four";
        assertEquals(expectedResult, result);
    }


    @Test
    public void expect_tie_with_pair_of_seven_each() {
        String gameInput = "Black: 7H 7D  White: 7C 7S";
        GameRunner gameRunner = new GameRunner();

        String result = gameRunner.run(gameInput);

        String expectedResult = "Tie. - with pair: Seven";
        assertEquals(expectedResult, result);
    }


    @Test
    public void expect_player_one_win_with_straight() {
        String gameInput = "Black: 7H 5D 6C  White: 2C 3H 7C";
        GameRunner gameRunner = new GameRunner();

        String result = gameRunner.run(gameInput);

        String expectedResult = "Black wins. - with straight: Seven";
        assertEquals(expectedResult, result);
    }

    @Test
    public void expect_player_two_win_with_straight_seven() {
        String gameInput = "Black: 2H 4D 3C  White: 5C 6H 7C";
        GameRunner gameRunner = new GameRunner();

        String result = gameRunner.run(gameInput);

        String expectedResult = "White wins. - with straight: Seven";
        assertEquals(expectedResult, result);
    }

    @Test
    public void expect_tie_with_same_straight() {
        String gameInput = "Black: 2H 4D 3C  White: 4C 2H 3C";
        GameRunner gameRunner = new GameRunner();

        String result = gameRunner.run(gameInput);

        String expectedResult = "Tie. - with straight: Four";
        assertEquals(expectedResult, result);
    }


    @Test
    public void expect_tie_with_same_three_of_kind() {
        String gameInput = "Black: 9H 9D 9C  White: 9C 9H 9C";
        GameRunner gameRunner = new GameRunner();

        String result = gameRunner.run(gameInput);

        String expectedResult = "Tie. - with three of kind: Nine";
        assertEquals(expectedResult, result);
    }


    @Test
    public void expect_player_two_win_with_flush() {
        String gameInput = "Black: 2H 4D 3C  White: 2C 6C 7C";
        GameRunner gameRunner = new GameRunner();

        String result = gameRunner.run(gameInput);

        String expectedResult = "White wins. - with flush: Clubs";
        assertEquals(expectedResult, result);
    }
}
