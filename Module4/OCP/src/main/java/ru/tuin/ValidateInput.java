package ru.tuin;

/**
 * @author Tulin Victor
 * @since 06.08.2016
 * @version 1
 */

public class ValidateInput extends ConsoleInput {
    /**
     * method checks the entered key
     * @param question
     * @param range
     * @return
     */
    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException e) {
                System.out.println("Please select key from menu");
            } catch (NumberFormatException e) {
                System.out.println("Please enter validate data again");
            }
        }
        while (invalid);
        return value;
    }
}
