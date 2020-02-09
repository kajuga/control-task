package afedorov.tasks;

import afedorov.SystemSettings;

import java.util.Objects;

public class OneExam extends Task {

    private final double exam;
    private final boolean credit;

    public OneExam(String candidate, double exam, boolean credit) {
        super(candidate);
        this.exam = exam;
        this.credit = credit;
    }

    public boolean isPassed() {
        return exam >= SystemSettings.getSumPassOneExam() && credit == true;
    }

    @Override
    public String toString() {
        return "Кандидат = " + candidate + ";" +
                "Экзамен = " + exam + ";" +
                "Зачет = " + creditToString(credit) + ";" +
                "Статус = " + statusToString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OneExam oneExam = (OneExam) o;
        return Double.compare(oneExam.exam, exam) == 0 &&
                credit == oneExam.credit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(exam, credit);
    }
}
