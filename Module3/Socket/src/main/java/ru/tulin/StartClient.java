package ru.tulin;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 08.10.2016
 */
public class StartClient {
    public static void main(String[] args) throws FileNotFoundException {
        String logPath = "\\Module3\\Socket\\src\\main\\java\\ru\\tulin\\log.txt";
        final int servPort = 5000;
        final String ipAdress = "127.0.0.1";
        new Client().launch(new File(logPath), ipAdress, servPort);
    }
}
