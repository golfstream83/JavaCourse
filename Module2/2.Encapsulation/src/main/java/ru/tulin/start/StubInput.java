package ru.tulin.start;

/**
 * @author Tulin Victor
 * @since 06.08.2016
 * @version 1
 */

public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String ask(String question) {
        return answers[position++];
    }

    @Override
    public int ask(String question, int[] range)  {

        //throw new UnsupportedOperationException("Unsupported operation");
        return -1;
    }
}
