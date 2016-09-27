package ru.tulin;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 22.09.2016
 */
public class MinimalTest {
    @Test
    public void whenCompareThreeNumbersThenReceiveMinimum() throws Exception {
        Minimal testMinimal = new Minimal();
        String string1 = "1.1";
        String string2 = "1.3";
        String string3 = "1.4";
        float minimal = 1.1f;
        System.setIn(new ByteArrayInputStream(string1.getBytes()));
        float number1 = testMinimal.checkRealNumber();
        System.setIn(new ByteArrayInputStream(string2.getBytes()));
        float number2 = testMinimal.checkRealNumber();
        System.setIn(new ByteArrayInputStream(string3.getBytes()));
        float number3 = testMinimal.checkRealNumber();
        assertThat(testMinimal.getMinimal(number1, number2, number3), is(minimal));
    }

    @Test
    public void whenCompareThreeNumbersDifferentCharactersThenReceiveMinimum() throws Exception {
        Minimal testMinimal = new Minimal();
        String string1 = "-1.1";
        String string2 = "1.3";
        String string3 = "-1.4";
        float minimal = 1.1f;
        System.setIn(new ByteArrayInputStream(string1.getBytes()));
        float number1 = testMinimal.checkRealNumber();
        System.setIn(new ByteArrayInputStream(string2.getBytes()));
        float number2 = testMinimal.checkRealNumber();
        System.setIn(new ByteArrayInputStream(string3.getBytes()));
        float number3 = testMinimal.checkRealNumber();
        assertThat(testMinimal.getMinimal(number1, number2, number3), is(minimal));
    }

    @Test(expected = IsNotRealNumberException.class)
    public void whenCompareThreeNumbersAndNullThenGetException() throws Exception {
        Minimal testMinimal = new Minimal();
        String string1 = "-1.1";
        String string2 = "1.3";
        String string3 = "";
        System.setIn(new ByteArrayInputStream(string1.getBytes()));
        float number1 = testMinimal.checkRealNumber();
        System.setIn(new ByteArrayInputStream(string2.getBytes()));
        float number2 = testMinimal.checkRealNumber();
        System.setIn(new ByteArrayInputStream(string3.getBytes()));
        float number3 = testMinimal.checkRealNumber();
    }
}