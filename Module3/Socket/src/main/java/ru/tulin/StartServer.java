package ru.tulin;

import java.io.File;
import java.io.IOException;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 08.10.2016
 */
public class StartServer {
    public static void main(String[] args) throws IOException {
        String filePath = "\\Module3\\Socket\\src\\main\\java\\ru\\tulin\\words.txt";
        new Server().launch(new File(filePath));
    }
}
