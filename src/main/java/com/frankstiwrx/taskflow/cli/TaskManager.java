
package com.frankstiwrx.taskflow.cli;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private final List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public void addTask(String description) {
        tasks.add(new Task(nextId++, description));
        System.out.println("Tarefa adicionada com sucesso!");
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
}
