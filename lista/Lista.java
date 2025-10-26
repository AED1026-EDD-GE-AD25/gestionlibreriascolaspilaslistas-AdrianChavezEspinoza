package lista;

public class Lista<T> {

    private Nodo<T> cabeza;
    private int tamanio;

    public Lista(){
        cabeza = null;
        tamanio = 0;
    }

    public int getTamanio() {

        return tamanio;
    }

    public boolean esVacia(){

        return(cabeza == null);
    }

    public void agregar(T valor){
        Nodo<T> nuevo = new Nodo<T>();
        
        nuevo.setValor(valor);
        if(esVacia()){
            cabeza = nuevo;
        }else{
            Nodo<T> aux = cabeza;
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }

        tamanio++;
    }

    public void insertar(T valor, int posi) throws PosicionIlegalException{
        if(posi >= 0 && posi <= tamanio){
            Nodo<T> nuevo = new Nodo<T>();
            nuevo.setValor(valor);
            if(posi == 0){
                nuevo.setSiguiente(cabeza);
                cabeza = nuevo;
            }else{
                if(posi == tamanio){
                    Nodo<T> aux = cabeza;
                    while(aux.getSiguiente() != null){
                        aux = aux.getSiguiente();
                    }
                    aux.setSiguiente(nuevo);
                }else{
                    Nodo<T> aux = cabeza;
                    for(int i = 0; i <= posi-2; i++){
                        aux = aux.getSiguiente();
                    }
                    Nodo<T> sig = aux.getSiguiente();
                    aux.setSiguiente(nuevo);
                    nuevo.setSiguiente(sig);
                }
            }
            tamanio++;

        }else{
            throw new PosicionIlegalException();
        }
    }

    public void remover(int posi) throws PosicionIlegalException{
        if(posi >= 0 && posi < tamanio){
            if(posi == 0){
                cabeza = cabeza.getSiguiente();
            }else{
                Nodo<T> aux = cabeza;
                for(int i = 0; i <= posi-2; i++){
                    aux = aux.getSiguiente();
                }
                Nodo<T> prox = aux.getSiguiente();
                aux.setSiguiente(prox.getSiguiente());
            }
            tamanio--;

        }else{
            throw new PosicionIlegalException();
        }
        
    }

    public T getValor(int posi) throws PosicionIlegalException{
        if(posi >= 0 && posi < tamanio){
            if(posi == 0){
                return cabeza.getValor();
            }else{
                Nodo<T> aux = cabeza;
                for(int i = 0; i < posi; i++){
                    aux = aux.getSiguiente();
                }
                return aux.getValor();
            }
        }else{
            throw new PosicionIlegalException();
        }
    }

    public void limpiar(){
        cabeza = null;
        tamanio = 0;
    }

    public boolean contiene(T valor){
        
        Nodo<T> aux = cabeza;
        for (int i = 0; i < tamanio; i++){
            if(aux == valor){
                return true;
            }else{
                aux = aux.getSiguiente();
            }
        }

        return false;

    }

}
