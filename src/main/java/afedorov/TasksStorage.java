package afedorov;

import afedorov.tasks.FiveCredits;
import afedorov.tasks.OneExam;
import afedorov.tasks.Task;
import afedorov.tasks.TwoExams;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TasksStorage {

    private final List<Task> tasks = new ArrayList<>();

    public void loadFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));) {
            String str = null;
            while ((str = reader.readLine()) != null) {
                String[] data = str.split(";");

                if (data.length == 4 && "Два экзамена".equals(data[1])) {
                    tasks.add(new TwoExams(data[0], Integer.parseInt(data[2]), Integer.parseInt(data[3])));
                }

                if (data.length == 4 && "Один экзамен".equals(data[1])) {
                    tasks.add(new OneExam(data[0], Double.parseDouble(data[2]), parseCredit(data[3])));
                }

                if (data.length == 7 && "Пять зачетов".equals(data[1])) {
                    tasks.add(new FiveCredits(data[0], parseCredit(data[2]), parseCredit(data[3]),
                            parseCredit(data[4]), parseCredit(data[5]), parseCredit(data[6])));
                }
            }
        }
    }

    private boolean parseCredit(String credit) {
        return "сдан".equals(credit) ? true : false;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public List<Task> getSortedTasksByPassed() {
        return tasks.stream()
                .sorted((t1, t2) -> Boolean.compare(t2.isPassed(), t1.isPassed()))
                .collect(Collectors.toList());
    }

    void addTask(Task task) {
        tasks.add(task);
    }

}
