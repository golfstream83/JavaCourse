package ru.tulin;

import java.io.*;
import java.nio.file.Paths;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 14.10.2016
 */
public class FileSearch {

    private PrintWriter pw;
    private String[] paramArr;

    public FileSearch(String[] paramArr) {
        this.paramArr = paramArr;
    }

    /**
     * File search start
     * @throws Exception
     */
    protected void search(String logPath) throws Exception {

        Validator validator = new Validator(paramArr);
        boolean filesFound = false;

        if(validator.validation()) {

            String pathDir = paramArr[1];
            String paramFile = paramArr[3];
            String modeSearch = paramArr[4];
            String logName = paramArr[6];

            pw = new PrintWriter(new File(logPath + "\\" + logName));

            File file = new File(pathDir);

                if (modeSearch.equals("-m")) {
                    filesFound = scanFolders(file, new FilterMask(paramFile));
                    if (!filesFound) {
                        System.out.println(String.format(
                                "%s %s", "folder and subfolders does not contain files with the extension:",
                                paramFile));
                    }
                }

                if (modeSearch.equals("-f")) {
                filesFound = scanFolders(file, new FilterName(paramFile));
                    if (!filesFound) {
                        System.out.println(String.format(
                                "%s %s", "folder and subfolders does not contain files with name:",
                                paramFile));
                    }
                }

                 if (modeSearch.equals("-r")) {
                filesFound = scanFolders(file, new FilterRegularExpressions(paramFile));
                     if (!filesFound) {
                         System.out.println(String.format(
                                 "%s %s", "folder and subfolders does not contain files with regexp pattern:",
                                 paramFile));
                     }
                }

                if (filesFound) {
                    System.out.println(String.format("%s %s", "see the list of files in the file",
                            logPath));
                }

            pw.close();
        }
    }

    /**
     * method scans the specified folder and all subfolders for any file by filter
     * @param dir
     * @param filter
     */
    private boolean scanFolders(File dir, FilenameFilter filter) throws Exception {

        int count = 0;

        if (dir.listFiles(filter).length > 0) {
                for (File f : dir.listFiles(filter)) {
                    pw.println(f.getAbsolutePath());
                    count++;
                }
        }

        for (File file : dir.listFiles()) {
                if (file.isDirectory()) {
                    scanFolders(file, filter);
                }
        }

        return count > 0;
    }


    public static void main(String[] args) throws Exception {

        String logPath = String.valueOf(Paths.get(System.getProperty("user.dir") +
                "\\Module3\\FileSearch\\src\\main\\java\\ru\\tulin"));
        new FileSearch(args).search(logPath);
    }
}
