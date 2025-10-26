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

    public Lista obtenerLibros() throws PosicionIlegalException{
       
		Lista<Libro> lista = new Lista<>();
        try{
           for(int i = 0; i < listaLibros.getTamanio(); i++){
                lista.agregar(listaLibros.getValor(i));
            } 
        }catch(PosicionIlegalException e){
            e.getMessage();
        }

		return lista;
        
    }

    public boolean agregarLibroCola(Libro libro){

        if(listaLibros.contiene(libro)){
            colaLibros.encolar(libro);
            System.out.println("Se ha reservado el libro " + libro);
            return true;
        }else{
            System.out.println("No se ha encontrado el libro " + libro);
            return false;
        }
        
    }

    public Libro obtenerLibroCola(){

		return colaLibros.frente();

    }

    public Libro obtenerLibroPila(){
        
		return null;

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

    public boolean devolverLibro(Libro libro){

		return false;
       

    }

    public Libro eliminarUltimoLibro() throws PosicionIlegalException{

		Libro elim = new Libro();

		try{
			elim = listaLibros.getValor(listaLibros.getTamanio()-1);
			listaLibros.remover(listaLibros.getTamanio()-1);
			pilaLibrosEliminados.apilar(elim);
			
		}catch(PosicionIlegalException e){
			e.getMessage();
		}
		
		return elim;
    }

    public Libro deshacerEliminarLibro(){
        
		Libro recu = new Libro();

		recu = pilaLibrosEliminados.cima();
		pilaLibrosEliminados.retirar();
		listaLibros.agregar(recu);
		return recu;

    }

    public Libro buscarLibro(String isbn) throws PosicionIlegalException{

		Libro buscar = new Libro();

		try{
			for(int i = 0; i < listaLibros.getTamanio(); i++){
				if(listaLibros.getValor(i).getIsbn().equals(isbn)){
					buscar = listaLibros.getValor(i);
				}
			}
		}catch(PosicionIlegalException e){
			e.getMessage();
		}

        return buscar;

    }
}