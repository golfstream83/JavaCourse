package ru.tuin;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 27.10.2016
 */
public class InteractCalculator {

    private ConsoleInput input;
    private Calculator calc;
    private Print print;
    private CalcAction[] actions = new CalcAction[7]; //Action array variable
    private double prevResult; //variable result of the previous calculation
    private double number1; //variable is the first number of the calculation
    private double number2; //variable is the second number for the calculation

    public InteractCalculator(ConsoleInput input, Calculator calc, Print print) {
        this.input = input;
        this.calc = calc;
        this.print = print;

        this.actions[Key.EXIT.getNumFromKey()] = this.new ExitFromProgram("Exit");
        this.actions[Key.ADDITION.getNumFromKey()] = this.new AdditionNumbers("Addition");
        this.actions[Key.SUBTRUCTION.getNumFromKey()] = this.new SubstractionNumbers("Subtraction");
        this.actions[Key.DIVISION.getNumFromKey()] = this.new DivisionNumber("Division");
        this.actions[Key.MULTIPLICATION.getNumFromKey()] = this.new MultiplicationNumber("Multiplication");
    }

    /**
     * getter for "input"
     * @return input
     */
    public ConsoleInput getInput() {
        return input;
    }

    /**
     * getter for "prevResult"
     * @return prevResult
     */
    public double getPrevResult() {
        return prevResult;
    }

    /**
     * getter for "actions"
     * @return actions
     */
    public CalcAction[] getActions() {
        return actions;
    }

    /**
     * method to call the method execute the object of the inner class by key
     * @param key
     */
    public void select(Key key) {
        this.actions[key.getNumFromKey()].execute(this.input, this.calc, this.print);
    }

    /**
     * method to display the console a list of all available actions
     */
    public void show() {

        print.printArrayActions(this.actions);
    }

    /**
     * method returns a range of acceptable values ​​of menus
     * @return array result
     */
    public int[] getAcceptableRange () {

        int [] result = new int[this.actions.length];
        for (int i = 0; i != result.length; i++) {
            if (actions[i] != null) {
                result[i] = actions[i].key();
            }
        }
        return result;
    }

    /**
     * receipt of two numbers entered by the user method
     */
    void getTwoNumbersToCalculate() {

        if (prevResult != 0 &&
                "y".equals(input.ask("Use the result of the previous calculation? If yes, press (y) " +
                        "Else, press (Enter): "))) {
            number1 = prevResult;
            number2 = input.askNumber("Please, enter the second number: ");
        }
        else {
            number1 = input.askNumber("Please, enter the first number: ");
            number2 = input.askNumber("Please, enter the second number: ");
        }
    }

    /**
     * the program output class
     */
    private class ExitFromProgram extends CalcAction {

        public ExitFromProgram(String name) {
            super(name);
        }

        @Override
        int key() {
            return Key.EXIT.getNumFromKey();
        }

        @Override
        void execute(ConsoleInput input, Calculator tracker, Print print) {

        }
    }

    /**
     * adding numbers class
     */
    private class AdditionNumbers extends CalcAction {

        public AdditionNumbers(String name) {
            super(name);
        }

        @Override
        int key() {
            return Key.ADDITION.getNumFromKey();
        }

        @Override
        void execute(ConsoleInput input, Calculator calc, Print print) {

            getTwoNumbersToCalculate();
            prevResult = calc.add(number1, number2);
            print.printResult(prevResult);
        }
    }

    /**
     * subtraction of numbers class
     */
    private class SubstractionNumbers extends CalcAction {

        public SubstractionNumbers(String name) {
            super(name);
        }

        @Override
        int key() {
            return Key.SUBTRUCTION.getNumFromKey();
        }

        @Override
        void execute(ConsoleInput input, Calculator calc, Print print) {

            getTwoNumbersToCalculate();
            prevResult = calc.substruct(number1, number2);
            print.printResult(prevResult);
        }
    }

    /**
     * dividing the number of class
     */
    private class DivisionNumber extends CalcAction {

        public DivisionNumber(String name) {
            super(name);
        }

        @Override
        int key() {
            return Key.DIVISION.getNumFromKey();
        }

        @Override
        void execute(ConsoleInput input, Calculator calc, Print print) {

            getTwoNumbersToCalculate();
            prevResult = calc.div(number1, number2);
            print.printResult(prevResult);
        }
    }

    /**
     * multiplying the number of class
     */
    private class MultiplicationNumber extends CalcAction {

        public MultiplicationNumber(String name) {
            super(name);
        }

        @Override
        int key() {
            return Key.MULTIPLICATION.getNumFromKey();
        }

        @Override
        void execute(ConsoleInput input, Calculator calc, Print print) {

            getTwoNumbersToCalculate();
            prevResult = calc.multiple(number1, number2);
            print.printResult(prevResult);
        }
    }
}
