package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que maneja la lectura y escritura de tareas desde/hacia un archivo de texto.
 */
public class TaskFileRepository {
    private final String filePath;

    /**
     * Constructor que recibe la ruta del archivo donde se guardan las tareas.
     */
    public TaskFileRepository(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Carga todas las tareas del archivo, si existe.
     */
    public List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) return tasks;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|", 2); // dividir en estado y descripción
                if (parts.length == 2) {
                    boolean completed = parts[0].equals("1");
                    String description = parts[1];
                    Task task = new Task(description);
                    task.setCompleted(completed);
                    tasks.add(task);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar tareas: " + e.getMessage());
        }

        return tasks;
    }

    /**
     * Guarda la lista de tareas actual al archivo.
     */
    public void saveTasks(List<Task> tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Task task : tasks) {
                String line = (task.isCompleted() ? "1" : "0") + "|" + task.getDescription();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar tareas: " + e.getMessage());
        }
    }
}
