package me.arkadii.humennyi.view;

import java.util.Scanner;

/**
 * Simple console view
 */
public class Console implements View {
    private final Scanner in = new Scanner(System.in);

    /**
     * prints message in console
     * @param message - printing message
     */
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    /**
     * reads line from console
     * @return read line
     */
    @Override
    public String read() {
        return in.nextLine();
    }
}
