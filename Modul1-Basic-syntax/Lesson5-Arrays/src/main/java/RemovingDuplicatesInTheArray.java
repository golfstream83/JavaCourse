
public class RemovingDuplicatesInTheArray {

    String[] removingDuplicates(String[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].equals(array[i])) {
                    array[j] = null;
                }
            }
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == null) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[j] != null) {
                        array[i] = array[j];
                        array[j] = null;
                        break;
                    }
                }
            }
        }
        return array;
    }

    void print (String[] array) {
        for (String x : array) {
            System.out.printf(String.format("%s ", x));
        }
    }

}
