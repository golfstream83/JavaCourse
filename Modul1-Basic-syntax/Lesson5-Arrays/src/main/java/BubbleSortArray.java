public class BubbleSortArray {

    public static void main(String[] args) {
        int values[] = {3, 45, 6, 2, 11, 1, 56, 5};
        for (int x : new BubbleSortArray().sort(values)) {
            System.out.println(x);
        }
    }

    int[] sort(int array[]){
        for (int i = 0; i < array.length - 1; i++){
            for (int j = 0; j < array.length - 1; j++){
                if (array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array [j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
