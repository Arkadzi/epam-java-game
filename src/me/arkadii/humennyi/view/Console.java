package me.arkadii.humennyi.view;

import java.util.Scanner;

/**
 * Created by Arkadiy on 18.05.2016.
 */
public class Console implements View {
    private final Scanner in = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String read() {
        return in.nextLine();
    }
}
