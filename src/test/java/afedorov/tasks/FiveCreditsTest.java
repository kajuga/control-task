package afedorov.tasks;

import org.junit.Assert;
import org.junit.Test;

public class FiveCreditsTest {

    @Test
    public void isPassedTrue() {
        FiveCredits fiveCredits = new FiveCredits("Bob", true, false, true, true, true);
        Assert.assertEquals(true, fiveCredits.isPassed());
    }

    @Test
    public void isPassedFalse() {
        FiveCredits fiveCredits = new FiveCredits("Bob", true, false, true, false, true);
        Assert.assertEquals(false, fiveCredits.isPassed());
    }

}