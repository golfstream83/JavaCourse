package ru.tulin;

import org.junit.Rule;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * @author Viktor Tulin
 * @version 1
 * @since 22.09.2016
 */
public class NumberTest {

    @Test
    public void whenIntroducingEvenNumberShouldGetTrue() {
        String number = "1";
        System.setIn(new ByteArrayInputStream((number.getBytes())));
        Number testNumber = new Number();
        assertTrue(testNumber.checkParity());
    }

    @Test
    public void whenIntroducingOddNumberShouldGetFalse() {
        String number = "1.2";
        System.setIn(new ByteArrayInputStream((number.getBytes())));
        Number testNumber = new Number();
        assertFalse(testNumber.checkParity());
    }
}