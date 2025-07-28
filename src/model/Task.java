package model;

/**
 * Clase que representa una tarea individual dentro de la aplicación.
 * Cada tarea contiene una descripción y un estado booleano que indica si está completada.
 */
public class Task {
    // Texto descriptivo de la tarea.
    private String description;
    // Estado que indica si la tarea ha sido completada (true) o no (false).
    private boolean completed;

    /**
     * Constructor que inicializa una nueva tarea con la descripción proporcionada.
     * Al crearla, la tarea se marca como no completada por defecto.
     *
     * @param description Descripción textual de la tarea.
     */
    public Task(String description) {
        this.description = description;
        this.completed = false; // Al iniciar, la tarea no está completada
    }

    /**
     * Devuelve la descripción actual de la tarea.
     *
     * @return Descripción de la tarea.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Indica si la tarea está completada.
     *
     * @return true si está completada; false en caso contrario.
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Establece una nueva descripción para la tarea.
     *
     * @param description Nuevo texto descriptivo de la tarea.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Establece el estado de completitud de la tarea.
     *
     * @param completed true si la tarea está completada; false si no lo está.
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * Devuelve una representación en texto de la tarea.
     * Incluye un ícono "[✔]" si está completada o "[ ]" si no lo está, seguido de la descripción.
     *
     * @return Representación legible de la tarea.
     */
    @Override
    public String toString() {
        return (completed ? "[✔] " : "[ ] ") + description;
    }
}
