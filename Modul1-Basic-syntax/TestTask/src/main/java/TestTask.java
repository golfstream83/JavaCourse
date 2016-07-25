public class TestTask {
    public boolean contains (String origin, String sub) {

        boolean result = false;
        char [] originArray = origin.toCharArray();
        char [] subArray = sub.toCharArray();

        for (int i = 0; i < originArray.length; i++){

            int count = 0;

            if (originArray[i] == subArray[0]) {

                count++;

                for (int j = 1; j < subArray.length; j++) {

                    if (originArray[i + 1] == subArray[j]) {

                        count++;
                        i++;
                    }
                }

                if (count == subArray.length) {
                    result = true;
                }
            }
        }

        return result;
    }
}
