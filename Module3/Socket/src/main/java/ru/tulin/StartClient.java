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
        new Client().launch(new File(logPath));
    }
}
