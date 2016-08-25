package ru.tulin.start;

/**
 * @author Tulin Victor
 * @since 06.08.2016
 * @version 1
 */

public class StartUI {
    private int[] ranges = new int[] {0, 1, 2, 3, 4, 5, 6};
    private Input input;

    public StartUI(Input input) {
        this.input = input;
    }

    /**
     * initialization method
     */
    public void init() {

        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillActions();
        do {
            menu.show();
            menu.select(input.ask("select: ", ranges));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

    public static void main(String[] args) {
        Input input = new ValidateInput();
        new StartUI(input).init();
    }
}
