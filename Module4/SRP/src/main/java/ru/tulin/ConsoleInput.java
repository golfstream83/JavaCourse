package ru.tulin;

import java.util.Scanner;

/**
 * @author Tulin Victor
 * @since 06.08.2016
 * @version 1
 */

public class ConsoleInput {

    private Scanner scanner = new Scanner(System.in);

    /**
     * method reads the data entered by the user
     * @param question
     * @return
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    /**
     * method reads the number entered by the user
     * @param question
     * @return
     */
    public double askNumber(String question) {
        System.out.print(question);
        return Double.valueOf(scanner.nextLine());
    }

    /**
     * method checks the entered key
     * @param question
     * @param range
     * @return
     * @throws MenuOutException
     */
    public int ask(String question, int[] range) throws MenuOutException {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value: range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        }
        else {
            throw new MenuOutException("Out of menu range");
        }
    }
}
