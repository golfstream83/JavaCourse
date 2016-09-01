package ru.tulin.start;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 30.08.2016
 */
public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
    * the method returns the element array of answers on incoming parameter
    *@return array answers
    */
    @Override
    public String ask(String question) {
        return answers[position++];
    }

    /**
    * metod asks number from the range.
    *@param question
    *@param range
    *@return answer
    */
    @Override
    public int ask(String question, int[] range) {

        return -1;
    }
}
