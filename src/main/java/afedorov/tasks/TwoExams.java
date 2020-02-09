package afedorov.tasks;

import afedorov.SystemSettings;

import java.util.Objects;

public class TwoExams extends Task {

    private final int firstExam;
    private final int secondExam;

    public TwoExams(String candidate, int firstExam, int secondExam) {
        super(candidate);
        this.firstExam = firstExam;
        this.secondExam = secondExam;
    }

    @Override
    public boolean isPassed() {
        return firstExam + secondExam >= SystemSettings.getSumPassTwoExam();
    }

    @Override
    public String toString() {
        return "Кандидат = " + candidate + ";" +
                "1-й экзамен = " + firstExam + ";" +
                "2-й экзамен = " + secondExam + ";" +
                "Статус = " + statusToString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TwoExams twoExams = (TwoExams) o;
        return firstExam == twoExams.firstExam &&
                secondExam == twoExams.secondExam;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstExam, secondExam);
    }
}
