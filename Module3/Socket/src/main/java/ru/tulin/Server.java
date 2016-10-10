package ru.tulin;

import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 03.10.2016
 */
public class Server {
    Random random = new Random();
    static final String END = "закончить";
    static final int PORT = 5000;

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

    /**
     * method returns a random value from the array
     * @param array
     * @return
     */
    public String getRandomAnswer(String[] array) {
        return array[random.nextInt(array.length)];
    }

    /**
     * method starts the chat
     *
     */
    public boolean launch (File filePath) throws IOException {

        String[] answers = getArrayAnswersFromFile(filePath);
        String input = null;

        try {
            ServerSocket servSocket = new ServerSocket(PORT);
            System.out.println("Ждём подключения к серверу");
            Socket socket = servSocket.accept();
            System.out.println("Подключение состоялось");

            InputStream socketIn = socket.getInputStream();
            OutputStream socketOut = socket.getOutputStream();

            BufferedReader in = new BufferedReader(new InputStreamReader(socketIn));
            PrintWriter out = new PrintWriter(socketOut, true);

            while (!END.equalsIgnoreCase(input)) {
                input = in.readLine();
                System.out.println("Мы получили следующее сообщение: \n" + input);
                String temp = getRandomAnswer(answers);
                System.out.println("Отправка обратно");
                System.out.println(temp);
                out.println(temp);
                out.flush();
            }

        } catch (Exception e) {
            System.out.println("Работа завершена");
        }

        return true;
    }
}
