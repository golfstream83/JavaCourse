package ru.tuin;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 01.11.2016
 */
public enum  Key {
    EXIT(0),
    ADDITION(1),
    SUBTRUCTION(2),
    DIVISION(3),
    MULTIPLICATION(4),
    COSINE(5),
    SINUS(6);

    private int num;

    /**
     * @param num
     */
    Key(int num) {
        this.num = num;
    }

    /**
     * @return number of Key
     */
    public int getNumFromKey() {
        return num;
    }

    /**
     * @param num
     * @return Key from number
     */
    public static Key getKeyFromNumber(int num) {

        switch (num) {
            case 0:
                return EXIT;
            case 1:
                return ADDITION;
            case 2:
                return SUBTRUCTION;
            case 3:
                return DIVISION;
            case 4:
                return MULTIPLICATION;
            case 5:
                return COSINE;
            case 6:
                return SINUS;
        }
        return null;
    }

}
