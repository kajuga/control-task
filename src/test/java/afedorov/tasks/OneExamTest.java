package afedorov.tasks;

import org.junit.Assert;
import org.junit.Test;

public class OneExamTest {

    @Test
    public void isPassedTrue() {
        OneExam oneExam = new OneExam("Bob", 7.7, true);
        Assert.assertEquals(true, oneExam.isPassed());
    }

    @Test
    public void isPassedFalse() {
        OneExam oneExam = new OneExam("Bob", 7.7, false);
        Assert.assertEquals(false, oneExam.isPassed());
    }
}