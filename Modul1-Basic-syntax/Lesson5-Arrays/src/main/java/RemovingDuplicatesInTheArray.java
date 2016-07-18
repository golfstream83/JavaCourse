
public class RemovingDuplicatesInTheArray {

    public static void main(String[] args) {
        RemovingDuplicatesInTheArray removingDuplicatesInTheArray = new RemovingDuplicatesInTheArray();
        String[] suppliedArray = new String[] {"one", "four", "two", "three", "four", "one"};
        removingDuplicatesInTheArray.removingDuplicates(suppliedArray);
        removingDuplicatesInTheArray.print(suppliedArray);
    }

    String[] removingDuplicates(String[] array) {

        return array;
    }

    void print (String[] array) {
        for (String x : array) {
            System.out.printf(x + " ");
        }
    }

}
