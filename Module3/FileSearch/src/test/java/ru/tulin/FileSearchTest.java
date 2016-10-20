package ru.tulin;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.nio.file.Paths;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 20.10.2016
 */
public class FileSearchTest {

    String filePath;
    String logPath;

    @Before
            public void init() {

        filePath = String.valueOf(Paths.get(System.getProperty("user.dir") +
                "\\src\\test\\java\\ru\\tulin\\files"));
        logPath = String.valueOf(Paths.get(System.getProperty("user.dir") +
                "\\src\\test\\java\\ru\\tulin"));

    }

    @Test
    public void whenSearchFilesByMaskThenGetListFiles() throws Exception {

        String[] inputArray = {"-d", filePath, "-n", ".jpg", "-m", "-o", "log.txt"};
        String[] expectedArray = {"image1.jpg", "image2.jpg", "image3.jpg", "image4.jpg"};
        String[] resultArray = new String[4];
        String logName = "\\" + inputArray[6];

        new FileSearch(inputArray).search(logPath);
        Scanner scanner = new Scanner(new File(logPath + logName));

        int i = 0;
        String s;

        while (scanner.hasNextLine()) {
            s = scanner.nextLine();
            resultArray[i] = s.substring(s.length() - 10);
            i++;
        }

        assertThat(expectedArray, is(resultArray));
    }

    @Test
    public void whenSearchFilesByFullNameThenGetListFiles() throws Exception {
        String[] inputArray = {"-d", filePath, "-n", "image1.jpg", "-f", "-o", "log.txt"};
        String[] expectedArray = {"image1.jpg"};
        String[] resultArray = new String[1];
        String logName = "\\" + inputArray[6];

        new FileSearch(inputArray).search(logPath);
        Scanner scanner = new Scanner(new File(logPath + logName));

        int i = 0;
        String s;

        while (scanner.hasNextLine()) {
            s = scanner.nextLine();
            resultArray[i] = s.substring(s.length() - 10);
            i++;
        }

        assertThat(expectedArray, is(resultArray));
    }

    @Test
    public void whenSearchFilesByRegexpThenGetListFiles() throws Exception {
        String[] inputArray = {"-d", filePath, "-n", ".+\\.(jpg)", "-r", "-o", "log.txt"};
        String[] expectedArray = {"image1.jpg", "image2.jpg", "image3.jpg", "image4.jpg"};
        String[] resultArray = new String[4];
        String logName = "\\" + inputArray[6];

        new FileSearch(inputArray).search(logPath);
        Scanner scanner = new Scanner(new File(logPath + logName));

        int i = 0;
        String s;

        while (scanner.hasNextLine()) {
            s = scanner.nextLine();
            resultArray[i] = s.substring(s.length() - 10);
            i++;
        }

        assertThat(expectedArray, is(resultArray));
    }

}