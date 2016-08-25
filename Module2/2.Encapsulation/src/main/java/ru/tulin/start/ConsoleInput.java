package ru.tulin.start;

import java.util.Scanner;

/**
 * @author Tulin Victor
 * @since 06.08.2016
 * @version 1
 */

public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    @Override
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
