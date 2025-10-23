package pila;

public class Nodo<T> {

    private T Valor;
    private Nodo<T> Siguiente;

    public Nodo(){
        Valor = null;
        Siguiente = null;

    }

    public T getValor() {
        return Valor;
    }

    public Nodo<T> getSiguiente() {
        return Siguiente;
    }

    public void setValor(T valor) {
        Valor = valor;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        Siguiente = siguiente;
    }

}
