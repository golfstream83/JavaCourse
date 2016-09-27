package ru.tulin;

import java.io.Reader;
import java.util.Scanner;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 26.09.2016
 */
public class SumOfNumbers {
    /**
     * method checks whether the number is an integer
     */
    public int checkParity() throws IsNotAnIntegerException {
        Scanner sc = new Scanner(System.in);
        int result;
        System.out.print("enter number: ");
            if(sc.hasNextInt()) {
                result = Integer.valueOf(sc.next());
            }
            else {
                throw new IsNotAnIntegerException("you entered is not an integer");
            }

        return result;
    }

    /**
     * method calculates the sum of two integers
     */
    public int sum (int number1, int number2) {
        int result = number1 + number2;
        System.out.println(String.format("%s + %s = %s", number1, number2, result));
        return result;
    }
}
