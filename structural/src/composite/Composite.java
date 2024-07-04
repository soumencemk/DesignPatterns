package composite;

import java.util.ArrayList;
import java.util.List;

interface Task {
    String getTitle();

    void setTitle(String title);

    void display();
}

public class Composite {
    public static void main(String[] args) {
        Task simpleTask1 = new SimpleTask("Complete Coding");
        Task simpleTask2 = new SimpleTask("Write Documentation");

        // Creating a task list
        TaskList projectTasks = new TaskList("Project Tasks");
        projectTasks.addTask(simpleTask1);
        projectTasks.addTask(simpleTask2);

        // Nested task list
        TaskList phase1Tasks = new TaskList("Phase 1 Tasks");
        phase1Tasks.addTask(new SimpleTask("Design"));
        phase1Tasks.addTask(new SimpleTask("Implementation"));

        projectTasks.addTask(phase1Tasks);

        // Displaying tasks
        projectTasks.display();
    }

}

class TaskList implements Task {
    private String title;
    private List<Task> tasks = new ArrayList<>() ;

    public TaskList(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void display() {
        System.out.println("Task List: " + title);
        tasks.forEach(System.out::println);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }
}

class SimpleTask implements Task {
    private String title;

    public SimpleTask(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;

    }

    @Override
    public void display() {
        System.out.println("Simple Task: " + title);
    }
}
