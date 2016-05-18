package me.arkadii.humennyi.view;

/**
 * View, which enables rendering messages and user input in {@link String} form
 */
public interface View {
    /**
     * displays message
     * @param message displaying message
     */
    void print(String message);

    /**
     * reads user input
     * @return read string
     */
    String read();
}
