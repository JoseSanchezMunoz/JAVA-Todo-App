package model;

// Librerías necesarias para manejo de archivos y colecciones.
import java.io.*;                    // Importa clases para entrada/salida de archivos.
import java.util.ArrayList;         // Implementación de listas dinámicas.
import java.util.List;              // Interfaz de listas genéricas.

/**
 * Clase encargada de la persistencia de datos de las tareas mediante archivo de texto.
 * Permite cargar tareas desde un archivo y guardarlas nuevamente en él.
 */
public class TaskFileRepository {
    // Ruta del archivo donde se guardarán y cargarán las tareas.
    private final String filePath;

    /**
     * Constructor que inicializa el repositorio con la ruta del archivo.
     *
     * @param filePath Ruta al archivo de texto que almacena las tareas.
     */
    public TaskFileRepository(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Carga todas las tareas existentes desde el archivo.
     * Si el archivo no existe, devuelve una lista vacía.
     *
     * @return Lista de tareas cargadas desde el archivo.
     */
    public List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();       // Lista que almacenará las tareas.
        File file = new File(filePath);             // Referencia al archivo físico.

        // Si el archivo no existe aún, se retorna la lista vacía (no hay tareas guardadas).
        if (!file.exists()) return tasks;

        // Lectura segura con try-with-resources para asegurar el cierre del archivo.
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            // Lee línea por línea el archivo.
            while ((line = reader.readLine()) != null) {
                // Divide la línea en dos partes: estado (1 o 0) y descripción.
                String[] parts = line.split("\\|", 2);
                if (parts.length == 2) {
                    boolean completed = parts[0].equals("1"); // true si está completada.
                    String description = parts[1];            // Descripción de la tarea.

                    // Crea la tarea con la descripción y le asigna su estado de completitud.
                    Task task = new Task(description);
                    task.setCompleted(completed);

                    // Añade la tarea a la lista.
                    tasks.add(task);
                }
            }
        } catch (IOException e) {
            // Manejo de errores de lectura del archivo.
            System.err.println("Error al cargar tareas: " + e.getMessage());
        }

        return tasks;
    }

    /**
     * Guarda todas las tareas de la lista al archivo.
     * Cada línea contiene el estado (1 o 0) seguido por la descripción, separados por "|".
     *
     * @param tasks Lista de tareas a guardar.
     */
    public void saveTasks(List<Task> tasks) {
        // Escritura segura con try-with-resources para cerrar correctamente el archivo.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Task task : tasks) {
                // Convierte la tarea en una línea de texto: "1|Descripción" o "0|Descripción".
                String line = (task.isCompleted() ? "1" : "0") + "|" + task.getDescription();

                // Escribe la línea en el archivo y salta a la siguiente.
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            // Manejo de errores de escritura del archivo.
            System.err.println("Error al guardar tareas: " + e.getMessage());
        }
    }
}
