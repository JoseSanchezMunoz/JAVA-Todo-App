package model;

/**
 * Clase que representa una tarea individual en la lista.
 * Contiene una descripción y un estado (completado o no).
 */
public class Task {
    private String description;
    private boolean completed;

    /**
     * Constructor que crea una nueva tarea con la descripción dada.
     * Por defecto, la tarea no está completada.
     *
     * @param description descripción de la tarea
     */
    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * Devuelve una representación textual de la tarea, incluyendo su estado.
     */
    @Override
    public String toString() {
        return (completed ? "[✔] " : "[ ] ") + description;
    }
}
