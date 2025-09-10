package IA;
import java.util.Scanner;

public class ArbolBinario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arbol arbol = new Arbol();

        System.out.println("Ingresa números para el árbol (0 para terminar):");
        int numero;
        while (true) {
            System.out.print("Número: ");
            numero = scanner.nextInt();
            if (numero == 0) break;
            arbol.insertar(numero);
        }

        System.out.println("\nRecorrido inOrden del árbol:");
        arbol.mostrarInOrden();

        scanner.close();
    }
}


class Arbol {
    private Nodo raiz;

    
    private static class Nodo {
        int valor;
        Nodo izquierdo;
        Nodo derecho;

        Nodo(int valor) {
            this.valor = valor;
        }
    }

    
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private Nodo insertarRecursivo(Nodo actual, int valor) {
        if (actual == null) {
            return new Nodo(valor);
        }

        if (valor < actual.valor) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, valor);
        } else {
            actual.derecho = insertarRecursivo(actual.derecho, valor);
        }

        return actual;
    }


    public void mostrarInOrden() {
        recorrerInOrden(raiz);
    }

    private void recorrerInOrden(Nodo nodo) {
        if (nodo == null) return;
        recorrerInOrden(nodo.izquierdo);
        System.out.println(nodo.valor);
        recorrerInOrden(nodo.derecho);
    }
}
