package ru.tulin;

import java.util.Scanner;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 27.09.2016
 */
public class Palindrome {
    /**
     * method checks the number of letters in the word
     */
    public String checkLengthWord() throws IsNotWordOddNumberOfLettersException {
        Scanner sc = new Scanner(System.in);
        String result;

        System.out.println("enter the word: ");
        String input = sc.nextLine().toLowerCase();

        if (input.length()%2 != 0) {
            result = input;
        }
        else {
            throw new IsNotWordOddNumberOfLettersException("you enter a word with an even number of letters");
        }

        return result;
    }

    /**
     * method checks whether the word palindrome
     */
    public boolean isPalindrome(String word) {
        boolean result = false;
        char[] array = word.toCharArray();
        int quantity = array.length / 2;
        int count = 0;

        for (int i = 0; i != quantity; i++) {
            if (array[i] == array[array.length - 1 - i]) {
                count++;
            }
        }

        if (count == quantity) {
            result = true;
        }

        return  result;
    }
}
