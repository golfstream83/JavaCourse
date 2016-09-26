package ru.tulin;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 26.09.2016
 */
public class SumOfNumbersTest {
    @Test
    public void whenAddTwoEvenNumbersThenGetSum() throws IsNotAnIntegerException {
        SumOfNumbers sum1 = new SumOfNumbers();
        String string1 = "1";
        String string2 = "2";
        int sum = 3;
        System.setIn(new ByteArrayInputStream(string1.getBytes()));
        int number1 = sum1.checkParity();
        System.setIn(new ByteArrayInputStream(string2.getBytes()));
        int number2 = sum1.checkParity();
        assertThat(sum1.sum(number1, number2), is(sum));
    }

    @Test (expected = IsNotAnIntegerException.class)
    public void whenAddOneOddNumberAndOneEvenNumberThenGetException() throws IsNotAnIntegerException {
        SumOfNumbers sum1 = new SumOfNumbers();
        String string1 = "1";
        String string2 = "2.2";
        System.setIn(new ByteArrayInputStream(string1.getBytes()));
        int number1 = sum1.checkParity();
        System.setIn(new ByteArrayInputStream(string2.getBytes()));
        int number2 = sum1.checkParity();
    }

}