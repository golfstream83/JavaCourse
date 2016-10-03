package ru.tulin;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 28.09.2016
 */
public class ConsoleChat {
    Random random = new Random();
    Scanner sc = new Scanner(System.in);
    static final String GO = "продолжить";
    static final String STOP = "стоп";
    static final String END = "закончить";

    public ConsoleChat() throws IOException {
    }

    /**
     * method reads words from a file and creates an array of these words
     * @return array words
     * @throws IOException
     */
    public String[] getArrayAnswersFromFile(File filePath) throws IOException {
        String words = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + filePath)));
        String[] arrayAnswers = words.split(" ");
        return arrayAnswers;
    }

    public String getRandomAnswer(String[] array) {
        return array[random.nextInt(array.length)];
    }

    /**
     * method starts the chat
     *
     */
    public void launch (File filePath, File logPath) throws IOException {
        PrintWriter pw = new PrintWriter(new File(String.valueOf(Paths.get(System.getProperty("user.dir") + logPath))));
        String[] answers = getArrayAnswersFromFile(filePath);
        String input;
        boolean toggle = true;

        do {
            input = sc.nextLine();
            pw.println(input);

            if (STOP.equalsIgnoreCase(input) || END.equalsIgnoreCase(input)) {
                toggle = false;
            }
            if (toggle) {
                String temp = getRandomAnswer(answers);
                System.out.println(temp);
                pw.println(temp);
            }
            if (GO.equalsIgnoreCase(input)) {
                toggle = true;
            }
        }
        while (!END.equalsIgnoreCase(input));

        pw.close();
    }

    public static void main(String[] args) throws IOException {
        ConsoleChat chat = new ConsoleChat();
        String filePath = "\\Module3\\IO\\src\\main\\java\\ru\\tulin\\words.txt";
        String logPath = "\\Module3\\IO\\src\\main\\java\\ru\\tulin\\log.txt";
        chat.launch(new File(filePath), new File(logPath));
    }

}
