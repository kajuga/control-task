package afedorov.tasks;

public abstract class Task {

    protected final String candidate;

    public Task(String candidate) {
        this.candidate = candidate;
    }

    protected String creditToString(boolean credit) {
        return credit == true ? "Сдан" : "Не сдан";
    }

    protected String statusToString() {
        return isPassed() == true ? "Пройден" : "Не пройден";
    }

    public abstract boolean isPassed();
}
