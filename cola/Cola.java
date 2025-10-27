package cola;

public class Cola<T> {

    private Nodo<T> cabeza;
    private Nodo<T> cola;
    private int tamanio;

    public Cola(){
        cabeza = null;
        cola = null;
        tamanio = 0;
    }

    public int getTamanio() {

        return tamanio;
    }

    public boolean esVacia(){

        return(cabeza == null);
    }

    public void encolar(T valor){
        Nodo<T> nuevo = new Nodo<T>();
        
        nuevo.setValor(valor);
        if(esVacia()){
            cabeza = nuevo;
            cola = nuevo;
        }else{
            cola.setSiguiente(nuevo);
            cola = nuevo;
        }

        tamanio++;
    }

    public void desencolar(){
        if(!esVacia()){
            if(cabeza == cola){
                cabeza = null;
                cola = null;
            }else{
                cabeza = cabeza.getSiguiente();
            }

            tamanio--;
        }
        

    }

    public T frente(){
        if(!esVacia()){
            return cabeza.getValor();
        }else{
            return null;
        }

    }

}
