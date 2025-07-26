package controller;

import model.Task;
import model.TaskFileRepository;

import java.util.List;

/**
 * Controlador que gestiona la lógica de tareas y la persistencia en archivo.
 */
public class TaskController {
    private final List<Task> tasks;
    private final TaskFileRepository repository;

    public TaskController() {
        repository = new TaskFileRepository("tasks.txt");
        tasks = repository.loadTasks(); // Cargar desde archivo al iniciar
    }

    public void addTask(String description) {
        tasks.add(new Task(description));
        repository.saveTasks(tasks);
    }

    public void removeTask(int index) {
        if (isValidIndex(index)) {
            tasks.remove(index);
            repository.saveTasks(tasks);
        }
    }

    public void markTaskCompleted(int index) {
        if (isValidIndex(index)) {
            tasks.get(index).setCompleted(true);
            repository.saveTasks(tasks);
        }
    }

    public List<Task> getTasks() {
        return tasks;
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < tasks.size();
    }
}

