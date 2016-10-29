package ru.tulin;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 28.10.2016
 */
public class Print {
    /**
     * output in the console result calculation method
     * @param number
     */
    public void printResult(double number) {
        System.out.println(String.format("%s = %s","result", number));
    }

    /**
     * method of the console displays all the actions of the array
     * @param array
     */
    public void printArrayActions(CalcAction[] array) {
        for (CalcAction action : array) {
            if (action != null) {
                System.out.println(String.format("%s. %s", action.key(), action.getName()));
            }
        }
    }
}
