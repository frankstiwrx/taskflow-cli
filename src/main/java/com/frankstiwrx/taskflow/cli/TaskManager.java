package com.frankstiwrx.taskflow.cli;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private final List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public void addTask(String description, TaskPriority priority) {
        if (description == null || description.isBlank()) {
            System.out.println("Error: Task description is required.");
            return;
        }

        if (priority == null) {
            System.out.println("Error: Task priority is required.");
            return;
        }

        tasks.add(new Task(nextId++, description.trim(), priority));
        System.out.println("Task added successfully!");
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }

        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void completeTask(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.complete();
                System.out.println("Tarefa concluida!");
                return;
            }
        }

        System.out.println("Tarefa nao encontrada.");
    }

    public void removeTask(int id) {
        boolean removed = tasks.removeIf(
                task -> task.getId() == id
        );

        if (removed) {
            System.out.println("Tarefa removida!");
        } else {
            System.out.println("Tarefa nao encontrada.");
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

}
