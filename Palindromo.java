import java.util.Scanner;
import java.util.Stack;

public class Palindromo {
    // Definición del Nodo para la lista circular
    static class Nodo {
        char car;
        Nodo sig;
    }
    
    private Nodo ultimo = null;

    // Método para insertar en la lista circular por el final
    public void insertarCircular(char c) {
        Nodo nuevo = new Nodo();
        nuevo.car = c;
        if (ultimo == null) {
            ultimo = nuevo;
            ultimo.sig = ultimo; // Se apunta a sí mismo para cerrar el círculo
        } else {
            nuevo.sig = ultimo.sig;
            ultimo.sig = nuevo;
            ultimo = nuevo;
        }
    }

    public void verificar(String frase) {
        // 1. Limpiar la frase: quitar espacios y signos, pasar a minúsculas
        String limpia = frase.replaceAll("[^a-zA-Z]", "").toLowerCase();
        
        if (limpia.isEmpty()) {
            System.out.println("La frase no contiene caracteres válidos.");
            return;
        }

        Stack<Character> pila = new Stack<>();
        ultimo = null; // Reiniciar la lista para cada verificación

        // 2. Añadir caracteres a la pila (LIFO) y a la lista circular (FIFO)
        for (char c : limpia.toCharArray()) {
            pila.push(c);
            insertarCircular(c);
        }

        // 3. Comparar carácter por carácter
        Nodo reco = ultimo.sig; // Empezamos por el primer nodo (el siguiente del último)
        boolean esPalindromo = true;

        for (int i = 0; i < limpia.length(); i++) {
            // Sacamos de la pila (viene al revés) y comparamos con la lista (va al derecho)
            if (pila.pop() != reco.car) {
                esPalindromo = false;
                break;
            }
            reco = reco.sig;
        }

        // 4. Mostrar resultado
        if (esPalindromo) {
            System.out.println("RESULTADO: Es un palíndromo.");
        } else {
            System.out.println("RESULTADO: No es un palíndromo.");
        }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Palindromo app = new Palindromo();
        
        System.out.println("--- DETECTOR DE PALÍNDROMOS ---");
        System.out.print("Ingrese una frase o palabra: ");
        String texto = teclado.nextLine();
        
        app.verificar(texto);
        
        teclado.close();
    }
}