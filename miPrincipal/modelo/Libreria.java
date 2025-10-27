package miPrincipal.modelo;

import listaDoble.ListaDoble;
import listaDoble.PosicionIlegalException;
import pila.Pila;
import cola.Cola;
import lista.Lista;
import utilerias.Fecha;
import miPrincipal.servicio.ServicioDatos;
import java.util.Scanner;

public class Libreria{
    ServicioDatos dataService;
    ListaDoble<Libro> listaLibros;
    Cola<Libro> colaLibros;
    Pila<Libro> pilaLibrosEliminados;
    Scanner scanner; 

    public Libreria(){
        dataService = new ServicioDatos();
        scanner = new Scanner(System.in);
        listaLibros = new ListaDoble<>();
        colaLibros = new Cola<>();
        pilaLibrosEliminados = new Pila<>();

    }

    public void agregarLibro(Libro libro){
        
        listaLibros.agregar(libro);
        
    }

    public ListaDoble<Libro> obtenerLibros(){
       
		// Lista<Libro> lista = new Lista<>();
		
		// for(int i = 0; i < listaLibros.getTamanio(); i++){
		// 	lista.agregar(listaLibros.getValor(i));
		// }

		// try {
		// 	int tamanio = listaLibros.getTamanio(); 
			
		// 	for(int i = 0; i < tamanio; i++){
		// 		lista.agregar(listaLibros.getValor(i));
		// 	}

		// } catch (PosicionIlegalException e) {
		// 	System.out.println("Error interno al obtener libro: " + e.getMessage());
		// }

		return listaLibros;
        
    }

    public boolean agregarLibroCola(Libro libro){

		colaLibros.encolar(libro);
		return true;
        
    }

    public Libro obtenerLibroCola(){

		if(colaLibros.esVacia()){
			return null;
		}

		Libro libro = colaLibros.frente();
		colaLibros.desencolar();

		return libro;

    }

    public Libro obtenerLibroPila(){
        
		if(pilaLibrosEliminados.esVacia()){
			return null;
		}else{
			return pilaLibrosEliminados.cima();
		}

    }

	public Cola mostrarReservaLibros(){

		return colaLibros;
	}

    public Libro crearLibro(String titulo, String autor, String isbn){
        
		return new Libro(titulo, autor, isbn);
    }

    public Pedido crearPedido(Libro libro, Fecha fecha){

		return new Pedido(libro, fecha);

    }

    public boolean devolverLibro(Libro libro) throws PosicionIlegalException{

		if(libro == null){
			return false;
		}

		int indice = -1;

		for(int i = 0; i < listaLibros.getTamanio(); i++){
			if(listaLibros.getValor(i).equals(libro)){
				indice = i;
				break;
			}
		}

		if(indice != -1){
			listaLibros.remover(indice);
			return true;
		}

		return false;

	}

    public Libro eliminarUltimoLibro() throws PosicionIlegalException{

		if(listaLibros.getTamanio() == 0){
			throw new PosicionIlegalException();
		}

		int ultimo = listaLibros.getTamanio()-1;

		Libro elim = listaLibros.getValor(ultimo);
		listaLibros.remover(ultimo);
		pilaLibrosEliminados.apilar(elim);
		return elim;

    }

    public Libro deshacerEliminarLibro(){
        
		if(pilaLibrosEliminados.esVacia()){
			return null;
		}

		Libro recu = pilaLibrosEliminados.cima();
		pilaLibrosEliminados.retirar();
		listaLibros.agregar(recu);
		return recu;

    }

    public Libro buscarLibro(String isbn) throws PosicionIlegalException{

		Libro buscar = new Libro();

		for(int i = 0; i < listaLibros.getTamanio(); i++){
			if(listaLibros.getValor(i).getIsbn().equals(isbn)){
				buscar = listaLibros.getValor(i);
			}
		}

        return buscar;

    }

	// public boolean contiene(Libro libro) throws PosicionIlegalException{

	// 	if(libro == null){
	// 		return false;
	// 	}

	// 	for(int i = 0; i < listaLibros.getTamanio(); i++){
	// 		if(listaLibros.getValor(i).equals(libro)){
	// 			return true;
	// 		}
	// 	}

	// 	return false;

    // }
}