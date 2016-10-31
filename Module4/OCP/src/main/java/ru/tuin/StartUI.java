package ru.tuin;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 27.10.2016
 */
public class StartUI {

    private Calculator calc;
    private ConsoleInput input;
    private InteractCalculator menu;

    public StartUI(ConsoleInput input, Calculator calc, InteractCalculator menu) {
        this.calc = calc;
        this.input = input;
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

        } while (!"y".equals(this.input.ask("To exit the program press (y) To continue work press (Enter): ")));

    }

    public static void main(String[] args) {
        EngineerCalculator calc = new EngineerCalculator();
        ConsoleInput input = new ValidateInput();
        Print print = new Print();
        EngineerInteractCalculator menu = new EngineerInteractCalculator(input, calc, print);

        new StartUI(input, calc, menu).init();
    }
}
