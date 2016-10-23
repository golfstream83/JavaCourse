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
        boolean filesFound;

        if(validator.validation()) {

            pw = new PrintWriter(new File(String.format("%s%s%s",logPath,"\\",validator.getLogName())));
            File file = new File(validator.getPathDir());

            filesFound = scanFolders(file, chooseFilter(validator.getModeSearch(), validator.getParamFile()));

            if (filesFound) {
                    System.out.println(String.format("%s %s", "see the list of files in the file",
                            logPath));
                }
            else {
                    System.out.println("folder and sub-folders do not contain files with the specified parameters");
                }

            pw.close();
        }
    }

    /**
     * method creates a class-filter object, depending on the selected parameter filtering
     * @param mode
     * @param paramFile
     * @return object FilenameFilter class
     */
    private FilenameFilter chooseFilter(String mode, String paramFile) {

        FilenameFilter result = null;

        if (mode.equals("-m")){
            result = new FilterMask(paramFile);
        }
        else if (mode.equals("-f")) {
            result = new FilterName(paramFile);
        }
        else if (mode.equals("-r")) {
            result = new FilterRegularExpressions(paramFile);
        }

        return result;
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
