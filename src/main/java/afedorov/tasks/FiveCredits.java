package afedorov.tasks;

import afedorov.SystemSettings;

import java.util.Arrays;

public class FiveCredits extends Task {

    private final boolean[] credits = new boolean[5];

    public FiveCredits(String candidate,
                       boolean first,
                       boolean second,
                       boolean third,
                       boolean fourth,
                       boolean fifth) {
        super(candidate);
        credits[0] = first;
        credits[1] = second;
        credits[2] = third;
        credits[3] = fourth;
        credits[4] = fifth;
    }

    @Override
    public boolean isPassed() {
        int passedCount = 0;
        for (boolean credit : credits) {
            if (credit == true) {
                passedCount++;
            }
        }
        return passedCount >= SystemSettings.getCountPassedCredit();
    }

    @Override
    public String toString() {
        return "Кандидат = "  + candidate + ";" +
                "1-й зачет = " + creditToString(credits[0]) + ";" +
                "2-й зачет = " + creditToString(credits[1]) + ";" +
                "3-й зачет = " + creditToString(credits[2]) + ";" +
                "4-й зачет = " + creditToString(credits[3]) + ";" +
                "5-й зачет = " + creditToString(credits[4]) + ";" +
                "Статус = " + statusToString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FiveCredits that = (FiveCredits) o;
        return Arrays.equals(credits, that.credits);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(credits);
    }
}
