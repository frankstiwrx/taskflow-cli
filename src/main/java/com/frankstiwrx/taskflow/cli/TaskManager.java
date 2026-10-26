
package com.frankstiwrx.taskflow.cli;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private final List<Task> tasks = new ArrayList<>();
    private final TaskStorage storage = new TaskStorage();
    private int nextId = 1;

    public TaskManager() {
        tasks.addAll(storage.loadTasks());

        for (Task task : tasks) {
            if (task.getId() >= nextId) {
                nextId = task.getId() + 1;
            }
        }
    }

    public void addTask(String description, TaskPriority priority) {
        if (description == null || description.isBlank()) {
            System.out.println("Error: Task description is required.");
            return;
        }

        if (priority == null) {
            System.out.println("Error: Task priority is required.");
            return;
        }

        Task task = new Task(nextId++, description.trim(), priority);
        tasks.add(task);
        saveTasks();

        System.out.println("Task added successfully!");
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks registered.");
            return;
        }

        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void completeTask(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                if (task.isCompleted()) {
                    System.out.println("Task is already completed.");
                    return;
                }

                task.complete();
                saveTasks();

                System.out.println("Task completed successfully!");
                return;
            }
        }

        System.out.println("Task not found.");
    }

    public void removeTask(int id) {
        boolean removed = tasks.removeIf(
                task -> task.getId() == id
        );

        if (removed) {
            saveTasks();
            System.out.println("Task removed successfully!");
        } else {
            System.out.println("Task not found.");
        }
    }

    public void filterTasks(String status) {
        boolean found = false;

        for (Task task : tasks) {
            if (status.equalsIgnoreCase("ALL")
                    || (status.equalsIgnoreCase("PENDING")
                    && !task.isCompleted())
                    || (status.equalsIgnoreCase("COMPLETED")
                    && task.isCompleted())) {

                System.out.println(task);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No tasks found for this filter.");
        }
    }

    private void saveTasks() {
        storage.saveTasks(tasks);
    }
}
