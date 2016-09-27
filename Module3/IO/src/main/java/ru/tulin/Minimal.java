package ru.tulin;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 22.09.2016
 */
public class Minimal {
    /**
     * method checks the number on the real
     */
    public float checkRealNumber() throws Exception {
        Scanner sc = new Scanner(System.in);
        float result;
        System.out.println("enter number: ");
        try {
            result = Float.valueOf(sc.nextLine());
        }
        catch (Exception e) {
            throw new IsNotRealNumberException("you entered is not a number");
        }

        return result;
    }

    /**
     * method determines the minimum number of
     */
    public float getMinimal (float number1, float number2, float number3) {
        float result;
        float modulNum1 = Math.abs(number1);
        float modulNum2 = Math.abs(number2);
        float modulNum3 = Math.abs(number3);
        if (modulNum1 < modulNum2) {
            result = modulNum1;
        }
        else {
            result = modulNum2;
        }
        if (modulNum3 < result) {
            result = modulNum3;
        }
        System.out.println(String.format("minimum number = %s", result));
        return result;
    }
}
