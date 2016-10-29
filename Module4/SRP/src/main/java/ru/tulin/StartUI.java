package ru.tulin;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 27.10.2016
 */
public class StartUI {

    private Calculator calc;
    private ConsoleInput input;
    private InteractCalculator menu;

    public StartUI(Calculator calc, ConsoleInput input, InteractCalculator menu) {
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

        Calculator calc = new Calculator();
        ConsoleInput input = new ValidateInput();
        Print print = new Print();
        InteractCalculator menu = new InteractCalculator(input, calc, print);

        menu.fillActions();
        new StartUI(calc, input, menu).init();
    }
}
