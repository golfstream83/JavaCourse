public class BubbleSortArray {

    public static void main(String[] args) {
        int values[] = {3, 45, 6, 2, 11, 1};
        for (int x : sort(values)) {
            System.out.println(x);
        }
    }

    static int[] sort(int array[]){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length - 1; j++){
                if (array[i] < array[j]){
                    int temp = array[i];
                    array[i] = array [j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
