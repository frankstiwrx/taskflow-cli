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

        tasks.forEach(System.out::println);
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
        boolean removed = tasks.removeIf(task -> task.getId() == id);
        System.out.println(removed
                ? "Tarefa removida!"
                : "Tarefa nao encontrada.");
    }
}