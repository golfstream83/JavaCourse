package ru.tulin;

import java.io.File;


/**
 * @author Viktor Tulin
 * @version 1
 * @since 16.10.2016
 */
public class Validator {

    private String[] inputArray;
    private String pathDir;
    private String paramFile;
    private String modeSearch;
    private String logName;

    public Validator(String[] inputArray) {
        this.inputArray = inputArray;
    }

    /**
     * print a list of acceptable parameters and the order of their entry
     */
    void printHelp() {
        System.out.println(String.format("%s\n\r\n\r%s\n\r%s\n\r%s\n\r%s\n\r%s\n\r%s\n\r%s\n\r%s\n\r\n\r%s\n\r%s",
                "Incorrect input !",
        "to start the program, enter all the parameters in the following sequence:",
                "[-d] folder key with which to start search",
                "[c:/...] the full path to the directory",
                "[-n] key file name, file mask or regular expression",
                "[.txt] such as a file mask",
                "[-m] search by mask [-f] search by the full coincidence [-r] search by a regular expression",
                "[-o] key log file name",
                "[log.txt] the log file must be in txt format",
                "An example of starting the program:",
                "java -jar FileSearch.jar -d c:/ -n *.txt -m -o log.txt"));
    }

    /**
     * check that all parameters are set
     * @return
     */
    boolean checkIfAllParameters() {

        if (inputArray.length == 7) {
            return true;
        }
        else {
            printHelp();
            return false;
        }
    }

    /**
     * check that the keys are correct
     * @return
     */
    boolean checkAllKeys() {

        if (inputArray[0].equals("-d") &
                inputArray[2].equals("-n") &
                (inputArray[4].equals("-m") || inputArray[4].equals("-f") || inputArray[4].equals("-r")) &
                inputArray[5].equals("-o")) {
            return true;
        }
        else {
            printHelp();
            return false;
        }
    }

    /**
     * check that the path to the current folder
     * @return
     */
    boolean checkPathExists() {

        if (new File(inputArray[1]).isDirectory()) {
            return true;
        }
        else {
            System.out.println("an invalid path to the folder or folder does not exist");
            return false;
        }
    }

    /**
     * check that the specified log file name is correct
     * @return
     */
    boolean checkLogFileName() {

        if (inputArray[6].length() > 4 & inputArray[6].endsWith(".txt")) {
            return true;
        }
        else {
            System.out.println("incorrectly stated the name of the log file\n\r");
            printHelp();
            return false;
        }
    }

    /**
     * run all verification methods
     * @return
     */
    public boolean validation() {

        if (checkIfAllParameters() &&
                checkAllKeys() &&
                checkPathExists() &&
                checkLogFileName()) {

            this.pathDir = this.inputArray[1];
            this.paramFile = this.inputArray[3];
            this.modeSearch = this.inputArray[4];
            this.logName = this.inputArray[6];

            return true;
        }
        else {
            return false;
        }
    }

    /**
     * getter for "pathDir"
     * @return
     */
    public String getPathDir() {
        return pathDir;
    }

    /**
     * getter for "paramFile"
     * @return
     */
    public String getParamFile() {
        return paramFile;
    }

    /**
     * getter for "modeSearch"
     * @return
     */
    public String getModeSearch() {
        return modeSearch;
    }

    /**
     * getter for "logName"
     * @return
     */
    public String getLogName() {
        return logName;
    }
}
