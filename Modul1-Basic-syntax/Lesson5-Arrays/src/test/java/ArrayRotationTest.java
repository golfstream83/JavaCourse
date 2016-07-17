import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class ArrayRotationTest {
    @Test

    public void testArrayRotation () {
        //assign
        ArrayRotation arrayRotation = new ArrayRotation(4);
        int unrotatedArray [][] = arrayRotation.initialization();
        int [][] rotatedArray =
                {       {1, 1, 1, 1},
                        {2, 2, 2, 2},
                        {3, 3, 3, 3},
                        {4, 4, 4, 4} };

        //act
        int [][] testRotatedArray = arrayRotation.rotation(unrotatedArray);

        //action
        assertThat(rotatedArray, is(testRotatedArray));

    }

}