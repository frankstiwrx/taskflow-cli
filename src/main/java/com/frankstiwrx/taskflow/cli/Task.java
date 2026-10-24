
package com.frankstiwrx.taskflow.cli;

public class Task {

    private final int id;
    private final String description;
    private boolean completed;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void complete() {
        this.completed = true;
    }

    @Override
    public String toString() {
        String status = completed ? "[X]" : "[ ]";
        return status + " " + id + " - " + description;
    }
}
