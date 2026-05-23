import java.util.Scanner;

public class LaboratorioListas {
    static Scanner teclado = new Scanner(System.in);

    // --- ESTRUCTURA DE LOS NODOS ---
    static class Nodo {
        int dato;
        Nodo sig, ant; // ant se usa para lista doble
        Nodo(int d) { dato = d; }
    }

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- MENU ESTRUCTURAS DE DATOS (JOYANES) ---");
            System.out.println("1. Lista Simple (Insertar/Mostrar)");
            System.out.println("2. Lista Doblemente Enlazada (Insertar/Mostrar)");
            System.out.println("3. Lista Circular (Insertar/Mostrar)");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1: menuListaSimple(); break;
                case 2: menuListaDoble(); break;
                case 3: menuListaCircular(); break;
            }
        } while (opcion != 4);
    }

    // --- ALGORITMOS PARA LISTA SIMPLE ---
    static void menuListaSimple() {
        Nodo raiz = null;
        System.out.print("Ingrese valor para la Lista Simple: ");
        int d = teclado.nextInt();
        raiz = new Nodo(d); // Inserción básica
        System.out.println("Nodo creado: [" + raiz.dato + "] -> null");
    }

    // --- ALGORITMOS PARA LISTA DOBLE ---
    static void menuListaDoble() {
        System.out.println("Algoritmo: Cada nodo apunta al siguiente y al anterior.");
        Nodo nuevo = new Nodo(10);
        System.out.println("Estructura: null <- [10] -> null");
    }

    // --- ALGORITMOS PARA LISTA CIRCULAR ---
    static void menuListaCircular() {
        System.out.println("Algoritmo: El ultimo nodo apunta a la raiz.");
        System.out.println("Estructura: [Dato] -> [Raiz] (Cierre del ciclo)");
    }
}