package afedorov;

import afedorov.tasks.FiveCredits;
import afedorov.tasks.OneExam;
import afedorov.tasks.Task;
import afedorov.tasks.TwoExams;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TasksStorageTest {

    @Test
    public void loadFromFile() throws IOException {
        TasksStorage tasksStorage = new TasksStorage();
        tasksStorage.loadFromFile(TasksStorage.class.getClassLoader().getResource("tasks.txt").getFile());

        List<Task> tasks = new ArrayList<>();
        tasks.add(new TwoExams("Иванов И.И.", 9, 10));
        tasks.add(new OneExam("Федоров Ф.Ф.", 7.5, true));
        tasks.add(new FiveCredits("Матвеев Д.Д.", true, true, false, true, true));
        tasks.add(new TwoExams("Федорова О.А.", 7, 14));
        tasks.add(new FiveCredits("Петров П.П", true, false, true, true, true));
        tasks.add(new OneExam("Коновалов Ф.П.", 6.5, false));
        tasks.add(new TwoExams("Васильева Е.Р.", 2, 4));
        tasks.add(new OneExam("Морозова М.Л.", 6, true));
        tasks.add(new FiveCredits("Шустрова В.Н.", true, false, true, true, false));

        Assert.assertEquals(tasks, tasksStorage.getTasks());
    }

    @Test
    public void getSortedTasksByPassed() {
        Task task1 = new TwoExams("Bob1", 9, 5);
        Task task2 = new TwoExams("Bob2", 9, 8);

        TasksStorage tasksStorage = new TasksStorage();
        tasksStorage.addTask(task1);
        tasksStorage.addTask(task2);

        List<Task> sortedTask = new ArrayList<>();
        sortedTask.add(task2);
        sortedTask.add(task1);

        Assert.assertEquals(sortedTask, tasksStorage.getSortedTasksByPassed());
    }
}