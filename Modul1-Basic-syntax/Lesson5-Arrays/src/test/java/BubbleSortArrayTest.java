import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BubbleSortArrayTest {
    @Test

    public void testSortArray() {
        //assign
        BubbleSortArray bubbleSortArray = new BubbleSortArray();
        int[] unsortedArray = {4, 3, 2, 1};
        int[] sortedArray = {1, 2, 3, 4};

        //act
        bubbleSortArray.sort(unsortedArray);

        //action
        assertThat(sortedArray, is(unsortedArray));

    }

}