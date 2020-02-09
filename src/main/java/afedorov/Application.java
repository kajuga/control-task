package afedorov;

import afedorov.tasks.Task;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        //Settings of application
        String fileName = args[0];
        SystemSettings.setSumPassOneExam(6);
        SystemSettings.setSumPassTwoExam(16);
        TasksStorage tasksStorage = new TasksStorage();

        //Load file in collection
        tasksStorage.loadFromFile(fileName);

        //Print collection
        System.out.println("----------------------------------------------------------");
        for (Task task : tasksStorage.getTasks()){
            System.out.println(task);
        }

        //Sort collection, first - passed, then not passed. Print sorted collection
        System.out.println("----------------------------------------------------------");
        for (Task task : tasksStorage.getSortedTasksByPassed()){
            System.out.println(task);
        }

        //Print again original collection (not sorted)
        System.out.println("----------------------------------------------------------");
        for (Task task : tasksStorage.getTasks()){
            System.out.println(task);
        }
    }

}
