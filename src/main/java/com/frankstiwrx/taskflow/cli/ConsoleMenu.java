package com.frankstiwrx.taskflow.cli;

import java.util.Scanner;

public class ConsoleMenu {

    private final Scanner scanner = new Scanner(System.in);
    private final TaskManager manager = new TaskManager();

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("\n=== TASKFLOW CLI ===");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Concluir tarefa");
            System.out.println("4. Remover tarefa");
            System.out.println("5. Filtrar tasks por status");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            String option = scanner.nextLine();

            try {
                switch (option) {

                    case "1":
                        System.out.print("Description: ");
                        String description = scanner.nextLine().trim();

                        if (description.isEmpty()) {
                            System.out.println("Error: Description is required.");
                            break;
                        }

                        System.out.println("Priority: 1-LOW | 2-MEDIUM | 3-HIGH");
                        System.out.print("Choose priority: ");

                        String priorityOption = scanner.nextLine();
                        TaskPriority priority;

                        switch (priorityOption) {
                            case "1":
                                priority = TaskPriority.LOW;
                                break;
                            case "2":
                                priority = TaskPriority.MEDIUM;
                                break;
                            case "3":
                                priority = TaskPriority.HIGH;
                                break;
                            default:
                                System.out.println("Invalid priority.");
                                continue;
                        }

                        manager.addTask(description, priority);
                        break;

                    case "2":
                        manager.listTasks();
                        break;

                    case "3":
                        System.out.print("ID da tarefa: ");
                        int completeId = Integer.parseInt(
                                scanner.nextLine()
                        );
                        manager.completeTask(completeId);
                        break;

                    case "4":
                        System.out.print("ID da tarefa: ");
                        int removeId = Integer.parseInt(
                                scanner.nextLine()
                        );
                        manager.removeTask(removeId);
                        break;

                    case "5":
                        System.out.println("1. All tasks");
                        System.out.println("2. Pending tasks");
                        System.out.println("3. Completed tasks");
                        System.out.print("Choose filter: ");

                        String filterOption = scanner.nextLine();

                        switch (filterOption) {
                            case "1":
                                manager.filterTasks("ALL");
                                break;
                            case "2":
                                manager.filterTasks("PENDING");
                                break;
                            case "3":
                                manager.filterTasks("COMPLETED");
                                break;
                            default:
                                System.out.println("Invalid filter.");
                        }
                        break;

                    case "0":
                        running = false;
                        break;

                    default:
                        System.out.println("Opcao invalida.");
                }

            } catch (NumberFormatException e) {
                System.out.println(
                        "Erro: digite um ID numerico valido."
                );
            }
        }

        System.out.println("Ate a proxima!");
    }
}
