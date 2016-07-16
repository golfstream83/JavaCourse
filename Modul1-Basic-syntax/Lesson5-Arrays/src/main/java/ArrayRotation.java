public class ArrayRotation {

    int size;

    public ArrayRotation(int size) {
        this.size = size;
    }

    public static void main(String[] args) {
        ArrayRotation arrayRotation = new ArrayRotation(4);
        int values [][] = arrayRotation.initialization();
        arrayRotation.print(values);
        int[][] valuesRotation = arrayRotation.rotation(values);
        arrayRotation.print(valuesRotation);
        }

    int[][] initialization () {
        int[][] array = new int [this.size][this.size];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                array[i][j] = j + 1;
            }
        }
        return array;
    }

    void print (int[][] array) {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                System.out.print(String.format("%s ", array[i][j]));
            }
            System.out.println();
        }
        System.out.println();
    }

    int [][] rotation (int[][] array) {
        int x = 0;
        int y = 0;
        int [][] rotation = new int[array.length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j >= 0 ; j--) {
                rotation [x][y] = array [j][i];
                y++;
            }
            x++;
            y = 0;
        }
        return rotation;
    }

    }
