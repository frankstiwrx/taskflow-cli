
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
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            String option = scanner.nextLine();

            try {
                switch (option) {
                    case "1":
                        System.out.print("Descricao: ");
                        String description = scanner.nextLine().trim();

                        if (description.isEmpty()) {
                            System.out.println(
                                    "A descricao nao pode ficar vazia."
                            );
                        } else {
                            manager.addTask(description);
                        }
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
