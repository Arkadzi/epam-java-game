package me.arkadii.humennyi.controller;

import me.arkadii.humennyi.model.GameModel;
import me.arkadii.humennyi.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Arkadiy on 18.05.2016.
 */
public class GameController {
    private final String RESTART = "restart";
    private final String FINISH = "finish";
    private final int RAND_MIN = 0;
    private final int RAND_MAX = 100;

    private View view;
    private GameModel model;

    private Random random;
    private List<String> attempts;

    public GameController(View view, GameModel model) {
        this.view = view;
        this.model = model;
        random = new Random();
        attempts = new ArrayList<>();
    }

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

    private void addAttempt(String input) {
        attempts.add(input);
    }

    private void resetGame() {
        model.setLeft(RAND_MIN);
        model.setRight(RAND_MAX);
        model.setAnswer(rand(RAND_MIN, RAND_MAX));
        attempts.clear();
    }

    private void outputUserInfo() {
        view.print(String.format("borders: [%d:%d]", model.getLeft(), model.getRight()));
        view.print(String.format("attempts: %s", attempts));
    }

    private int rand(int min, int max) {
        return min + random.nextInt(max - min + 1);
    }
}
