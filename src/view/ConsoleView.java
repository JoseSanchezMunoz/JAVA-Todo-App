package view;

import controller.TaskController;
import model.Task;

import java.util.Scanner;
import java.util.List;

/**
 * Clase encargada de la interacción con el usuario a través de la consola.
 * Presenta el menú, recibe entradas y se comunica con el controlador.
 */
public class ConsoleView {
    private final Scanner scanner;
    private final TaskController controller;

    /**
     * Constructor que inicializa el escáner de entrada y el controlador de tareas.
     */
    public ConsoleView() {
        scanner = new Scanner(System.in);       // Entrada por teclado
        controller = new TaskController();       // Lógica del sistema
    }

    /**
     * Método principal que inicia el bucle de ejecución del programa.
     * Permite seleccionar opciones hasta que se elija salir.
     */
    public void start() {
        int option;
        do {
            showMenu();  // Mostrar el menú de opciones
            option = readInt("Selecciona una opción: ");
            handleOption(option);  // Ejecutar acción correspondiente
        } while (option != 0);

        System.out.println("¡Hasta pronto!");
    }

    /**
     * Muestra el menú principal con las opciones disponibles.
     */
    private void showMenu() {
        System.out.println("\n--- MENÚ DE TAREAS ---");
        System.out.println("1. Agregar tarea");
        System.out.println("2. Ver tareas");
        System.out.println("3. Editar una tarea existente");
        System.out.println("4. Marcar tarea como completada");
        System.out.println("5. Eliminar tarea");
        System.out.println("0. Salir");
    }

    /**
     * Procesa la opción seleccionada por el usuario.
     *
     * @param option número de opción seleccionada
     */
    private void handleOption(int option) {
        switch (option) {
            case 1 -> {
                System.out.print("Escribe la descripción de la tarea: ");
                String description = scanner.nextLine();
                controller.addTask(description); // Crear nueva tarea
            }
            case 2 -> displayTasks(); // Mostrar lista de tareas
            case 3 -> {
                // Editar una tarea existente
                System.out.print("Ingrese el número de la tarea a editar: ");
                int editIndex = readInt("");

                System.out.print("Ingrese el nuevo texto de la tarea: ");
                String newText = scanner.nextLine();

                controller.updateTask(editIndex, newText); // Actualizar descripción
            }
            case 4 -> {
                // Marcar tarea como completada
                int index = readInt("Número de tarea a marcar como completada: ") - 1;
                controller.markTaskCompleted(index);
            }
            case 5 -> {
                // Eliminar tarea
                int index = readInt("Número de tarea a eliminar: ") - 1;
                controller.removeTask(index);
            }
            case 0 -> {
                // Salir del programa
            }
            default -> System.out.println("Opción inválida. Intenta de nuevo.");
        }
    }

    /**
     * Muestra todas las tareas guardadas en la lista.
     * Si no hay tareas, informa al usuario.
     */
    private void displayTasks() {
        List<Task> tasks = controller.getTasks();
        if (tasks.isEmpty()) {
            System.out.println("No hay tareas registradas.");
        } else {
            System.out.println("\n--- LISTA DE TAREAS ---");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i) + ". " + tasks.get(i));
            }
        }
    }

    /**
     * Solicita al usuario un número entero (con manejo de errores).
     * Muestra un mensaje personalizado antes de la lectura.
     *
     * @param prompt mensaje a mostrar al usuario
     * @return número entero leído
     */
    private int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.next(); // Descartar entrada no válida
            System.out.print("Entrada inválida. " + prompt);
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // Limpia el salto de línea
        return value;
    }
}
