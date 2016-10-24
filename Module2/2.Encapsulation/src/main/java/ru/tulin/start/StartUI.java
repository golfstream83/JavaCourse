package ru.tulin.start;

/**
 * @author Tulin Victor
 * @since 06.08.2016
 * @version 1
 */

public class StartUI {
    private Input input;
    private Tracker tracker;
    private MenuTracker menu;

    public StartUI(final Input input, final Tracker tracker, final MenuTracker menu) {
        this.input = input;
        this.tracker = tracker;
        this.menu = menu;
    }

    /**
     * method displays a menu until the user does not want to leave the program
     */
    public void init() {
        do {
            menu.show();
            int entry = this.input.ask("\nselect the menu item: ", menu.getAcceptableRange());
            menu.select(entry);

        } while (!"y".equals(this.input.ask("To exit the program press (y) To continue work press (Enter)")));
    }

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Input input = new ValidateInput();
        MenuTracker menu = new MenuTracker(input, tracker);

        menu.fillActions();
        new StartUI(input, tracker, menu).init();
    }
}
