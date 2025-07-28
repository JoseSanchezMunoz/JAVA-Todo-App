package controller;
// Importa la clase Task, que representa una tarea individual.
import model.Task;
// Importa la clase TaskFileRepository, responsable de guardar y cargar tareas desde un archivo.
import model.TaskFileRepository;
// Importa la interfaz List para manejar una colección de objetos tipo Task.
import java.util.List;

/**
 * Clase controladora que gestiona la lógica principal de la aplicación de tareas.
 * Se encarga de manipular la lista de tareas en memoria y de delegar la persistencia al repositorio.
 */
public class TaskController {
    // Lista de tareas
    private final List<Task> tasks;
    // Objeto encargado de guardar y cargar tareas desde un archivo de texto.
    private final TaskFileRepository repository;

    /**
     * Constructor por defecto del controlador.
     * Inicializa el repositorio con el archivo "tasks.txt" y carga las tareas existentes desde ese archivo.
     */
    public TaskController() {
        repository = new TaskFileRepository("tasks.txt"); // Se inicializa el repositorio
        tasks = repository.loadTasks(); // Se cargan las tareas existentes desde el archivo
    }

    /**
     * Agrega una nueva tarea con la descripción proporcionada.
     * Luego guarda la lista actualizada en el archivo.
     *
     * @param description Descripción de la nueva tarea.
     */
    public void addTask(String description) {
        tasks.add(new Task(description)); // Se crea y añade una nueva tarea a la lista
        repository.saveTasks(tasks); // Se guarda la lista actualizada en el archivo
    }

    /**
     * Actualiza la descripción de una tarea existente en la posición indicada.
     * Si el índice es válido, se realiza la modificación y se guarda la lista.
     *
     * @param index Índice de la tarea a modificar (comienza en 0).
     * @param newDescription Nueva descripción que reemplazará la actual.
     */
    public void updateTask(int index, String newDescription) {
        if (isValidIndex(index)) {
            tasks.get(index).setDescription(newDescription); // Se actualiza la descripción
            repository.saveTasks(tasks); // Se guarda la lista modificada
            System.out.println(" Tarea actualizada correctamente.");
        } else {
            System.out.println(" Índice de tarea inválido.");
        }
    }

    /**
     * Marca una tarea como completada (true) según su posición en la lista.
     * La lista se guarda después de la modificación.
     *
     * @param index Índice de la tarea a marcar como completada.
     */
    public void markTaskCompleted(int index) {
        if (isValidIndex(index)) {
            tasks.get(index).setCompleted(true); // Se marca la tarea como completada
            repository.saveTasks(tasks); // Se guarda la lista actualizada
        }
    }

    /**
     * Elimina una tarea de la lista según el índice proporcionado.
     * Luego persiste los cambios en el archivo.
     *
     * @param index Índice de la tarea que se desea eliminar.
     */
    public void removeTask(int index) {
        if (isValidIndex(index)) {
            tasks.remove(index); // Se elimina la tarea del índice especificado
            repository.saveTasks(tasks); // Se guarda la lista tras la eliminación
        }
    }

    /**
     * Devuelve la lista actual de tareas.
     *
     * @return Lista de objetos Task actualmente en memoria.
     */
    public List<Task> getTasks() {
        return tasks;
    }

    /**
     * Verifica si el índice proporcionado se encuentra dentro del rango válido de la lista.
     *
     * @param index Índice a validar.
     * @return true si el índice es válido; false si está fuera de rango.
     */
    private boolean isValidIndex(int index) {
        return index >= 0 && index < tasks.size(); // Condición de validez del índice
    }
}
