/////////////// main ////////
package IA;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArbolBinario<Integer> arbol = new ArbolBinario<>();

        System.out.println("Ingrese números para el árbol binario (0 para terminar):");
        int valor;
        while (true) {
            System.out.print("Valor: ");
            valor = sc.nextInt();
            if (valor == 0) break;
            arbol.insertar(valor);
        }

        System.out.println("Recorrido inOrden:");
        arbol.imprimir();
        sc.close();
    }
}

////////// clase nodo/////////
package IA;

public class Nodo<T extends Comparable<T>> {
    private T data;
    private Nodo<T> izquierdo;
    private Nodo<T> derecho;

    public Nodo(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Nodo<T> getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo<T> izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo<T> getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo<T> derecho) {
        this.derecho = derecho;
    }
}

///////// clase arbol ///////
package IA;

public class ArbolBinario<T extends Comparable<T>> {
    private Nodo<T> raiz;

    public ArbolBinario() {}

    public boolean isEmpty() {
        return this.raiz == null;
    }

    public boolean exists(T valor) {
        return buscar(valor) != null;
    }

    public void insertar(T data) {
        if (isEmpty()) {
            this.raiz = new Nodo<>(data);
            return;
        }
        insertar(this.raiz, new Nodo<>(data));
    }

    private void insertar(Nodo<T> raiz, Nodo<T> hijo) {
        if (hijo.getData().compareTo(raiz.getData()) < 0) {
            if (raiz.getIzquierdo() == null) {
                raiz.setIzquierdo(hijo);
            } else {
                insertar(raiz.getIzquierdo(), hijo);
            }
        } else {
            if (raiz.getDerecho() == null) {
                raiz.setDerecho(hijo);
            } else {
                insertar(raiz.getDerecho(), hijo);
            }
        }
    }

    public T buscar(T seeked) {
        return buscar(this.raiz, seeked);
    }

    private T buscar(Nodo<T> nodo, T seeked) {
        if (nodo == null) return null;
        if (nodo.getData().equals(seeked)) return nodo.getData();
        if (seeked.compareTo(nodo.getData()) < 0) {
            return buscar(nodo.getIzquierdo(), seeked);
        } else {
            return buscar(nodo.getDerecho(), seeked);
        }
    }

    public void imprimir() {
        if (!isEmpty()) {
            imprimir(this.raiz);
        }
    }

    private void imprimir(Nodo<T> nodo) {
        if (nodo == null) return;
        imprimir(nodo.getIzquierdo());
        System.out.println(nodo.getData());
        imprimir(nodo.getDerecho());
    }
}

