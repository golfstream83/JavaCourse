package ru.tulin;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 30.09.2016
 */
public class ConsoleChatTest {

    @Test
    public void whenReadFileThenGetArrayAnswers() throws IOException {
        ConsoleChat consoleChat = new ConsoleChat();
        String filePath = "\\src\\test\\java\\ru\\tulin\\testWords.txt";
        String[] testArray = {"answer1", "answer2", "answer3", "answer4", "answer5", "answer6"};

        String[] array = consoleChat.getArrayAnswersFromFile(new File(filePath));

        assertThat(array, is(testArray));
    }

    @Test
    public void whenWriteInChatThenGetAnswer() {
        ConsoleChat consoleChat = mock(ConsoleChat.class);
        String[] testAnswersArr = {"answer1", "answer2", "answer3"};

        when(consoleChat.getRandomAnswer(testAnswersArr)).thenReturn("answer1");

        assertThat("answer1", is(consoleChat.getRandomAnswer(testAnswersArr)));
    }
}