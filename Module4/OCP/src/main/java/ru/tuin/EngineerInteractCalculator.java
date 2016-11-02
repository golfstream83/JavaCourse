package ru.tuin;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 30.10.2016
 */
public class EngineerInteractCalculator extends InteractCalculator {

    private EngineerCalculator engCalc; //engineering calculator
    private ConsoleInput input = super.getInput();
    private CalcAction[] actions = super.getActions(); //Action array variable
    private double prevResult = super.getPrevResult(); //variable result of the previous calculation
    private double number1; //variable is the first number of the calculation

    public EngineerInteractCalculator(ConsoleInput input, Calculator calc, Print print) {
        super(input, calc, print);
        this.engCalc = (EngineerCalculator) calc;
        this.actions[Key.COSINE.getNumFromKey()] = this.new Cosine("Cosine");
        this.actions[Key.SINUS.getNumFromKey()] = this.new Sinus("Sinus");
    }

    /**
     * receipt of number entered by the user method
     */
    void getOneNumbersToCalculate() {

        if (prevResult != 0 &&
                "y".equals(input.ask("Use the result of the previous calculation? If yes, press (y) " +
                        "Else, press (Enter): "))) {
            number1 = prevResult;
        }
        else {
            number1 = input.askNumber("Please, enter the number: ");
        }
    }

    /**
     * calculate the cosine of the class
     */
    private class Cosine extends CalcAction {

        public Cosine(String name) {
            super(name);
        }

        @Override
        int key() {
            return Key.COSINE.getNumFromKey();
        }

        @Override
        void execute(ConsoleInput input, Calculator tracker, Print print) {

            getOneNumbersToCalculate();
            prevResult = engCalc.cosine(number1);
            print.printResult(prevResult);
        }
    }

    /**
     * calculate the sinus of the class
     */
    private class Sinus extends CalcAction {


        public Sinus(String name) {
            super(name);
        }

        @Override
        int key() {
            return Key.SINUS.getNumFromKey();
        }

        @Override
        void execute(ConsoleInput input, Calculator tracker, Print print) {

            getOneNumbersToCalculate();
            prevResult = engCalc.sinus(number1);
            print.printResult(prevResult);
        }
    }

    /**
     * getter for "prevResult"
     * @return prevResult
     */
    @Override
    public double getPrevResult() {
        return prevResult;
    }
}
