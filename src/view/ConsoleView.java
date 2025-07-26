package view;

import controller.TaskController;
import model.Task;

import java.util.Scanner;
import java.util.List;

/**
 * Clase encargada de la interacción con el usuario por consola.
 * Muestra el menú, recibe entradas y comunica con el controlador.
 */
public class ConsoleView {
    private final Scanner scanner;
    private final TaskController controller;

    /**
     * Constructor que inicializa el escáner y el controlador.
     */
    public ConsoleView() {
        scanner = new Scanner(System.in); // Entrada por teclado
        controller = new TaskController(); // Lógica del sistema
    }

    /**
     * Inicia el bucle principal de la aplicación.
     */
    public void start() {
        int option;
        do {
            showMenu(); // Mostrar opciones al usuario
            option = readInt("Selecciona una opción: ");
            handleOption(option);
        } while (option != 0);

        System.out.println("¡Hasta pronto!");
    }

    /**
     * Imprime el menú principal.
     */
    private void showMenu() {
        System.out.println("\n--- MENÚ DE TAREAS ---");
        System.out.println("1. Agregar tarea");
        System.out.println("2. Ver tareas");
        System.out.println("3. Marcar tarea como completada");
        System.out.println("4. Eliminar tarea");
        System.out.println("0. Salir");
    }

    /**
     * Ejecuta la acción seleccionada por el usuario.
     */
    private void handleOption(int option) {
        switch (option) {
            case 1 -> {
                System.out.print("Escribe la descripción de la tarea: ");
                String description = scanner.nextLine();
                controller.addTask(description);
            }
            case 2 -> displayTasks();
            case 3 -> {
                int index = readInt("Número de tarea a marcar como completada: ");
                controller.markTaskCompleted(index);
            }
            case 4 -> {
                int index = readInt("Número de tarea a eliminar: ");
                controller.removeTask(index);
            }
            case 0 -> {} // Salir del programa
            default -> System.out.println("Opción inválida. Intenta de nuevo.");
        }
    }

    /**
     * Muestra todas las tareas en consola.
     */
    private void displayTasks() {
        List<Task> tasks = controller.getTasks();
        if (tasks.isEmpty()) {
            System.out.println("No hay tareas registradas.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + ". " + tasks.get(i));
            }
        }
    }

    /**
     * Lee un número entero del usuario con manejo de errores.
     */
    private int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.next(); // Ignora entrada no numérica
            System.out.print("Entrada inválida. " + prompt);
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // Limpia el salto de línea
        return value;
    }
}
