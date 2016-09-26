package ru.tulin;

import java.util.Scanner;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 22.09.2016
 */
public class Number {

    /**
     * method checks the number of even or odd
     * @return true or false
     */
    public boolean checkParity() {
        Scanner sc = new Scanner(System.in);
        boolean result = false;
        if(sc.hasNextInt()) {
            result = true;
        }
        return result;
    }

}
