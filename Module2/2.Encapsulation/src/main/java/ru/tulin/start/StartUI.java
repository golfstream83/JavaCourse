package ru.tulin.start;

/**
 * @author Tulin Victor
 * @since 06.08.2016
 * @version 1
 */

public class StartUI {
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
            int entry = input.ask("\n select the menu item: ", menu.getAcceptableRange());
            if (entry == 7) {
                break;
            }
            else {
                menu.select(entry);
            }
        } while (!"y".equals(this.input.ask("To exit the program press (Y) To continue work press (Enter)")));
    }

    public static void main(String[] args) {
        Input input = new ValidateInput();
        new StartUI(input).init();
    }
}
