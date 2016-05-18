package me.arkadii.humennyi.model;

/**
 * Simple entity class. Stores some data about state of game
 */
public class GameModel {
    /**
     * right answer
     */
    private int answer;
    /**
     * left boundary
     */
    private int left;
    /**
     * right boundary
     */
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
