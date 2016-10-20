package ru.tulin;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 19.10.2016
 */
public class FilterRegularExpressions implements FilenameFilter {

    private Pattern pattern;

    public FilterRegularExpressions(String reg) {
        this.pattern = Pattern.compile(reg);
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).find();
    }
}
