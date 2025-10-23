package pila;

public class Pila<T> {

    private Nodo<T> Cabeza;
    private int Tamanio;

    public Pila() {
        Cabeza = null;
        Tamanio = 0;

    }

    public int getTamanio() {

        return Tamanio;
    }

    public boolean esVacia(){

        return(Cabeza == null);
    }

    public int buscar(T valor){
        int posi = -1;

        Pila<T> buscar = new Pila<T>();
        // Pila<T> aux = new Pila<T>();
        buscar.apilar(valor);

        for(int i = 0; i < Tamanio; i++){
            if(buscar.cima() == Cabeza){
                posi = i;
            }else{
                buscar.retirar();
            }
        }

        return posi;
    }

    public void apilar(T valor){
        Nodo<T> nuevo = new Nodo<T>();
        
        nuevo.setValor(valor);
        if(esVacia()){
            Cabeza = nuevo;
        }else{
            nuevo.setSiguiente(Cabeza);
            Cabeza = nuevo;
        }

        Tamanio++;
    }

    public void retirar(){
        if(!esVacia()){
            Cabeza = Cabeza.getSiguiente();
            Tamanio--;
        }
    }

    public T cima(){
        if(!esVacia()){
            return Cabeza.getValor();
        }else{
            return null;
        }
    }

}
