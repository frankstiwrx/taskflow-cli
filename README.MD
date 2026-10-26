
# TaskFlow CLI

A simple command-line task manager built with Java.

## Features

- Create tasks with description validation
- Assign LOW, MEDIUM, or HIGH priorities
- List all registered tasks
- Mark tasks as completed
- Remove tasks
- Filter tasks by completion status
- Save tasks locally to a file
- Restore tasks when restarting the application

## Technologies

- Java
- Object-Oriented Programming
- Java Collections
- File I/O
- Command-Line Interface

## Project Structure

```text
src/
└── com/frankstiwrx/taskflow/cli/
    ├── Main.java
    ├── Task.java
    ├── TaskPriority.java
    ├── TaskManager.java
    ├── TaskStorage.java
    └── ConsoleMenu.java
```

## How to Run

1. Clone or download this repository.
2. Open the project in Apache NetBeans.
3. Make sure a compatible JDK is configured.
4. Build and run the project.
5. Use the interactive console menu to manage tasks.

## Data Storage

Tasks are stored locally in `tasks.txt`.
The file is created when tasks are saved.

## Learning Goals

This project demonstrates basic Java development,
encapsulation, enums, collections, exception handling,
and file persistence.

## Author

GitHub: [@frankstiwrx](https://github.com/frankstiwrx)
