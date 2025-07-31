# JAVA-Todo-App

Una aplicacion con interaccion en consola para registrar actividades e ir marcando aquellas cumplidas.



Gestiona tareas pendientes (To-Do List) usando Java. Permite agregar, ver, editar, completar y eliminar tareas, almacenándolas de forma persistente en un archivo de texto.





## 📁 Estructura del proyecto



\- model/

&nbsp; - Task.java                 Clase que representa una tarea individual.

&nbsp; - TaskFileRepository.java   Repositorio para cargar y guardar tareas en archivo.



\- controller/

&nbsp; - TaskController.java       Lógica de negocio que conecta modelo y vista.



\- view/

&nbsp; - ConsoleView.java          Interfaz de usuario basada en consola.



\- Main.java                   Punto de entrada de la aplicación.



## Uso del Programa



Al iniciar el programa verás el siguiente menú:



'''bash

--- MENÚ DE TAREAS ---

1\. Agregar tarea

2\. Ver tareas

3\. Editar una tarea existente

4\. Marcar tarea como completada

5\. Eliminar tarea

0\. Salir

'''



Las tareas se numeran comenzando desde \*\*1\*\* para facilitar su uso desde el punto de vista del usuario.

Sin embargo, internamente los índices comienzan desde 0.





## Formato del archivo de tareas



Las tareas se guardan en un archivo `.txt` con el siguiente formato por línea:



'''bash

1|Estudiar para el examen

0|Lavar los platos

'''



Donde:

\- `1` indica tarea completada.

\- `0` indica tarea pendiente.

Esto se visualiza con una "palomita" para aquellos completados



## 🧪 Requisitos



- Java JDK 8 o superior

- Terminal o consola para interactuar



## 📄 Licencia







Este proyecto puede ser reutilizado libremente siempre que se brinde el crédito correspondiente.







---



## 👨‍💻 Autor







**José Sánchez Muñoz**  



Ingeniero de Sistemas  



🔗 GitHub: https://github.com/JoseSanchezMunoz







> Si te resulta útil este proyecto, ¡no dudes en darle una ⭐ en GitHub!



