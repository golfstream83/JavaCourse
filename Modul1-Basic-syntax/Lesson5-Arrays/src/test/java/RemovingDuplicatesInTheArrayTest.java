import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RemovingDuplicatesInTheArrayTest {

    @Test

    public void testRemovingDuplicates() {

        //assign
        RemovingDuplicatesInTheArray removingDuplicatesInTheArray = new RemovingDuplicatesInTheArray();
        String[] testArray = new String[] {"one", "one", "two", "two", "three", "three", "four", "four"};
        String[] resultArray = new String[] {"one", "two", "three", "four", null, null, null, null};

        //act
        removingDuplicatesInTheArray.removingDuplicates(testArray);

        //action
        assertThat(resultArray, is(testArray));

    }

}