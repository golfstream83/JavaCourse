package ru.tulin;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 16.10.2016
 */
public class FilterMask implements FilenameFilter {

    String endWith;

    public FilterMask(String endWith) {
        this.endWith = endWith;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(endWith);
    }
}
