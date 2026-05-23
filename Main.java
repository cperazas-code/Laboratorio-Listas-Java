import java.util.Random;

public class Main {
    static class Nodo {
        int info;
        Nodo sig;
        Nodo(int x) { info = x; sig = null; }
    }

    private Nodo raiz = null;

    // Insertar al final (Requerimiento 1.1)
    public void insertarUltimo(int x) {
        Nodo nuevo = new Nodo(x);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            Nodo reco = raiz;
            while (reco.sig != null) reco = reco.sig;
            reco.sig = nuevo;
        }
    }

    // Eliminar mayores a un valor (Requerimiento 1.3)
    public void eliminarMayores(int limite) {
        while (raiz != null && raiz.info > limite) {
            raiz = raiz.sig;
        }
        Nodo reco = raiz;
        while (reco != null && reco.sig != null) {
            if (reco.sig.info > limite) {
                reco.sig = reco.sig.sig;
            } else {
                reco = reco.sig;
            }
        }
    }

    public void imprimir() {
        Nodo reco = raiz;
        while (reco != null) {
            System.out.print(reco.info + " -> ");
            reco = reco.sig;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Main lista = new Main();
        Random azar = new Random();

        System.out.println("--- Creando lista de aleatorios ---");
        for (int i = 0; i < 8; i++) {
            lista.insertarUltimo(azar.nextInt(100));
        }
        lista.imprimir();

        System.out.println("\n--- Eliminando nodos > 50 ---");
        lista.eliminarMayores(50);
        lista.imprimir();
    }
}