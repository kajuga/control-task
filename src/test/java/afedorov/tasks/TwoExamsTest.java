package afedorov.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TwoExamsTest {

    @Test
    public void isPassedTrue() {
        TwoExams twoExams = new TwoExams("Bob", 10, 7);
        Assert.assertEquals(true, twoExams.isPassed());
    }

    @Test
    public void isPassedFalse() {
        TwoExams twoExams = new TwoExams("Bob", 10, 6);
        Assert.assertEquals(false, twoExams.isPassed());
    }
}