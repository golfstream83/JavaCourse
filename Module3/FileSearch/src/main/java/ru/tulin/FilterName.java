package ru.tulin;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 17.10.2016
 */
public class FilterName implements FilenameFilter {

    String fileName;

    public FilterName(String name) {
        this.fileName = name;
    }

    @Override
    public boolean accept(File dir, String name) {
        return fileName.equals(name);
    }
}
