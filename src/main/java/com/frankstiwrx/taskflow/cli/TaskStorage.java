
package com.frankstiwrx.taskflow.cli;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskStorage {

    private static final String FILE_NAME = "tasks.txt";

    public void saveTasks(List<Task> tasks) {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(FILE_NAME))) {

            for (Task task : tasks) {
                writer.write(task.getId() + ";"
                        + task.getDescription().replace(";", ",") + ";"
                        + task.getPriority() + ";"
                        + task.isCompleted());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    public List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return tasks;
        }

        try (BufferedReader reader = new BufferedReader(
                new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";", 4);

                if (data.length != 4) {
                    continue;
                }

                try {
                    int id = Integer.parseInt(data[0]);
                    String description = data[1];
                    TaskPriority priority =
                            TaskPriority.valueOf(data[2]);
                    boolean completed = Boolean.parseBoolean(data[3]);

                    Task task = new Task(id, description, priority);

                    if (completed) {
                        task.complete();
                    }

                    tasks.add(task);

                } catch (IllegalArgumentException e) {
                    System.out.println("Skipping invalid task record.");
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }

        return tasks;
    }
}
