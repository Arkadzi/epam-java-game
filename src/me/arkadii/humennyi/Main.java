package me.arkadii.humennyi;

import me.arkadii.humennyi.controller.GameController;
import me.arkadii.humennyi.model.GameModel;
import me.arkadii.humennyi.view.Console;

public class Main {

    public static void main(String[] args) {
        GameController gameController = new GameController(new Console(), new GameModel());
        gameController.start();
    }
}
