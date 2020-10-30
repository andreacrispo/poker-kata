package my.playground;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameRunnerTest {

    @Test
    public void expect_player_one_win_with_high_card_nine() {
        String gameInput = "Black: 9H 3D 4H 2D 5H  White: 2C 3H 5D 4H 8H";
        GameRunner gameRunner = new GameRunner();

        String result = gameRunner.run(gameInput);

        String expectedResult = "Black wins. - with high card: Nine";
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
        String gameInput = "Black: 7H 3D 3H 2H 5H  White: 4C 4H 4D 5H 8H";
        GameRunner gameRunner = new GameRunner();

        String result = gameRunner.run(gameInput);

        String expectedResult = "White wins. - with three of kind: Four";
        assertEquals(expectedResult, result);
    }


    @Test
    public void expect_tie_with_pair_of_seven_each() {
        String gameInput = "Black: 7H 7D 2C 3S JC  White: 7C 7S 2C 5C JC";
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
        String gameInput = "Black: 9H 9D 9C  White: 9C 9H 9C 8D";
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


    @Test
    public void expect_player_one_win_double_pair() {
        String gameInput = "Black: 2H 4D 2C 4C 5C  White: 2C 6C 7C 3H 9C";
        GameRunner gameRunner = new GameRunner();

        String result = gameRunner.run(gameInput);

        String expectedResult = "Black wins. - with two pair: Two Four";
        assertEquals(expectedResult, result);
    }

    @Test
    public void expect_player_one_win_four_of_kind() {
        String gameInput = "Black: 4H 4D 4S 4C  White: 2C 2C 2C 3H";

        String result = new GameRunner().run(gameInput);
        String expectedResult = "Black wins. - with four of kind: Four";
        assertEquals(expectedResult, result);
    }

    @Test
    public void expect_player_two_win_four_of_kind_by_value() {
        String gameInput = "Black: 4H 4D 4S 4C 5S  White: 9D 9S 9C 9H 5S";
        GameRunner gameRunner = new GameRunner();

        String result = gameRunner.run(gameInput);
        String expectedResult = "White wins. - with four of kind: Nine";
        assertEquals(expectedResult, result);
    }


    @Test
    public void expect_player_two_win_full_house() {
        String gameInput = "Black: 4H 4D 4S AC AD  White: 9D 9S 2C 9H AD";
        String result = new GameRunner().run(gameInput);
        String expectedResult = "Black wins. - with full house";
        assertEquals(expectedResult, result);
    }

    @Test
    public void expect_player_one_win_with_full_house_from_sample() {
        String gameInput = "Black: 2H 4S 4C 2D 4H  White: 2S 8S AS QS 3S";
        String result = new GameRunner().run(gameInput);
        String expectedResult = "Black wins. - with full house";
        assertEquals(expectedResult, result);
    }

    @Test
    public void expect_player_one_win_with_straight_flush() {
        String gameInput = "Black: 2C 5C 3C 4C 6C  White: 2S 8S AS QS 3S 3S";
        String result = new GameRunner().run(gameInput);
        String expectedResult = "Black wins. - with straight flush";
        assertEquals(expectedResult, result);
    }


    @Test
    public void expect_player_two_win_when_both_player_have_one_pair_evaluate_remain_card() {
        String gameInput = "Black: 2C 2C 3C 9C 6S  White: 2S 2S 3S 5S AC";
        String result = new GameRunner().run(gameInput);
        String expectedResult = "White wins. - with pair: Two";
        assertEquals(expectedResult, result);
    }

    @Test
    public void expect_player_two_win_when_both_player_have_two_pair_evaluate_remain_card() {
        String gameInput = "Black: 2C 2C 4C 4C 6S  White: 2S 2S 4S 4S AC";
        String result = new GameRunner().run(gameInput);
        String expectedResult = "White wins. - with two pair: Two Four";
        assertEquals(expectedResult, result);
    }
}
