package me.arkadii.humennyi.controller;

import me.arkadii.humennyi.model.GameModel;
import me.arkadii.humennyi.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * "Guess number" game controller
 */
public class GameController {
    /**
     * input message for restart
     */
    private final String RESTART = "restart";
    /**
     * input message for finish
     */
    private final String FINISH = "finish";
    /**
     * minimum value for random generated answer
     */
    private final int RAND_MIN = 0;
    /**
     * minimum value for random generated answer
     */
    private final int RAND_MAX = 100;
    /**
     * view, representing the game
     */
    private View view;
    /**
     * game storage
     */
    private GameModel model;
    /**
     * random answer generator
     */
    private Random random;
    /**
     * list of user's attempts
     */
    private List<String> attempts;

    public GameController(View view, GameModel model) {
        this.view = view;
        this.model = model;
        random = new Random();
        attempts = new ArrayList<>();
    }

    /**
     * launches the process of the game
     */
    public void start() {
        String input = "";
        resetGame();
        boolean continueGame = true;
        while (continueGame) {
            view.print(String.format("input %s to restart, %s to finish, or input your guess", RESTART, FINISH));
            outputUserInfo();
            input = view.read();
            addAttempt(input);
            continueGame = handleInput(input);

        }
    }

    /**
     * handles user's input
     *
     * @param input - user's input string
     * @return true if game process should continue
     */
    private boolean handleInput(String input) {
        switch (input) {
            case RESTART:
                resetGame();
                break;
            case FINISH:
                view.print(input);
                return false;
            default:
                try {
                    int guess = Integer.parseInt(input);
                    if (guess == model.getAnswer()) {
                        view.print(String.format("%s: Congratulations!", input));
                        view.print("You can play again!");
                        resetGame();
                    } else if (guess < model.getLeft()) {
                        view.print("Your guess is too low");
                    } else if (guess > model.getRight()) {
                        view.print("Your guess is too high");
                    } else if (guess < model.getAnswer()) {
                        model.setLeft(guess);
                    } else if (guess > model.getAnswer()) {
                        model.setRight(guess);
                    }
                } catch (NumberFormatException e) {
                    view.print(String.format("%s: try again", input));
                }
        }
        return true;
    }

    /**
     * adds attempt to attempts' list
     *
     * @param attempt - user's input
     */
    private void addAttempt(String attempt) {
        attempts.add(attempt);
    }

    /**
     * resets game state
     */
    private void resetGame() {
        model.setLeft(RAND_MIN);
        model.setRight(RAND_MAX);
        model.setAnswer(rand(RAND_MIN, RAND_MAX));
        attempts.clear();
    }

    /**
     * outputs user's progress
     */
    private void outputUserInfo() {
        view.print(String.format("borders: [%d:%d]", model.getLeft(), model.getRight()));
        view.print(String.format("attempts: %s", attempts));
    }

    /**
     * generates random number inclusively
     *
     * @param min - min value
     * @param max - max value
     * @return random generated value
     */
    private int rand(int min, int max) {
        return min + random.nextInt(max - min + 1);
    }
}
