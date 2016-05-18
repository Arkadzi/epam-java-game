package me.arkadii.humennyi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Arkadiy on 18.05.2016.
 */
public class GameModel {

    private Random random;

    private int answer;
    private int left;
    private int right;


    public void setLeft(int left) {
        this.left = left;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
