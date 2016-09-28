package ru.tulin;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 27.09.2016
 */
public class PalindromeTest {

    @Test
    public void whenCheckPalindromeThenGetTrue() throws IsNotWordOddNumberOfLettersException {
        Palindrome palindrome = new Palindrome();
        String string = "ротор";
        System.setIn(new ByteArrayInputStream(string.getBytes()));
        assertTrue(palindrome.isPalindrome(palindrome.checkLengthWord()));
    }

    @Test
    public void whenCheckPalindromeWithCapitalLetterThenGetTrue() throws IsNotWordOddNumberOfLettersException {
        Palindrome palindrome = new Palindrome();
        String string = "Ротор";
        System.setIn(new ByteArrayInputStream(string.getBytes()));
        assertTrue(palindrome.isPalindrome(palindrome.checkLengthWord()));
    }

    @Test
    public void whenCheckNotPalindromeThenGetFalse() throws IsNotWordOddNumberOfLettersException {
        Palindrome palindrome = new Palindrome();
        String string = "посох";
        System.setIn(new ByteArrayInputStream(string.getBytes()));
        assertFalse(palindrome.isPalindrome(palindrome.checkLengthWord()));
    }

    @Test (expected = IsNotWordOddNumberOfLettersException.class)
    public void whenCheckWordWithEvenNumberLettersThenGetException() throws IsNotWordOddNumberOfLettersException {
        Palindrome palindrome = new Palindrome();
        String string = "сорока";
        System.setIn(new ByteArrayInputStream(string.getBytes()));
        palindrome.checkLengthWord();
    }

}