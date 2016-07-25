import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class TestTaskTest {

    @Test

    public void testTask() {
        //assign
        TestTask testTask = new TestTask();
        boolean testExpected = true;

        //act
        boolean testResult = testTask.contains("one two three", "two");

        //action
        assertThat(testExpected, is(testResult));
    }
}