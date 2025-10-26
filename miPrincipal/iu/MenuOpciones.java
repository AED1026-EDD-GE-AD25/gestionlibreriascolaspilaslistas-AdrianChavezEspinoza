package miPrincipal.iu;
import miPrincipal.servicio.ServicioDatos;
import miPrincipal.modelo.Libro;
import miPrincipal.modelo.Pedido;
import miPrincipal.modelo.Libreria;
import java.util.Scanner;
import utilerias.Fecha;
import listaDoble.ListaDoble;
import listaDoble.PosicionIlegalException;
import cola.Cola;
import pila.Pila;

import java.util.Scanner;

public class MenuOpciones{
    static Scanner scanner = new  Scanner(System.in);
    static private Libreria libreria = new Libreria();

    public static void agregarLibro(){
        
        System.out.print("Ingrese el título del libro para agregar: ");
        String tituloAgregar = scanner.nextLine();
        System.out.print("Ingrese el autor del libro para agregar: ");
        String autorAgregar = scanner.nextLine();
        System.out.print("Ingrese el ISBN del libro para agregar: ");
        String isbnAgregar = scanner.nextLine();
        Libro libroAgregar = libreria.crearLibro(tituloAgregar, autorAgregar, isbnAgregar);
        if(libroAgregar == null){
            System.out.println("Error: no fue posible crear el Libro");
        }else{
            libreria.agregarLibro(libroAgregar);
        }
        

    }
    
    public static void mostrarLibros() throws PosicionIlegalException{

        System.out.println("Lista de libros prestados:");
        libreria.obtenerLibros();

    }

    public static void agregarLibroCola(){
        
        System.out.print("Ingrese el título del libro para Reservar: ");
        String tituloReservar = scanner.nextLine();
        System.out.print("Ingrese el autor del libro para Reservar: ");
        String autorReservar = scanner.nextLine();
        System.out.print("Ingrese el ISBN del libro para Reservar: ");
        String isbnReservar = scanner.nextLine();
        Libro libroReservar = libreria.crearLibro(tituloReservar, autorReservar, isbnReservar);
        if(libroReservar == null){
            System.out.println("Error: no fue posible crear el Libro");
        }else{
            libreria.agregarLibroCola(libroReservar);  
        }
        
        
    }

    public static Libro obtenerLibroCola(){

       return libreria.obtenerLibroCola();
     
    }

    public static void mostrarReservaLibros(){
        
        System.out.println("Lista de libros reservados:");
        Cola reservaLibros = libreria.mostrarReservaLibros();
        for(int i = 0; i < reservaLibros.getTamanio(); i++){
            System.out.println(reservaLibros.frente());
            reservaLibros.desencolar();
        }
        

    }

    public static void crearPedido(){
        System.out.print("Ingrese el título del libro para el pedido:");
        String tituloPedido = scanner.nextLine();
        System.out.print("Ingrese el autor del libro para el pedido:");
        String autorPedido = scanner.nextLine();
        System.out.print("Ingrese el ISBN del libro para el pedido:");
        String isbnPedido = scanner.nextLine();
        Libro libroPedido = libreria.crearLibro(tituloPedido, autorPedido, isbnPedido);
        Pedido pedido=null;
        if (libroPedido!=null){
            pedido = libreria.crearPedido(libroPedido, new Fecha());
            if (pedido !=null)
                System.out.println("Pedido creado exitosamente: "+pedido);
            else
                System.out.println("No fue posible crear el pedido");
        }else{
            System.out.println("Error: no fue posible crear el Libro");
        }
       
    }

    public static void devolverLibro() throws PosicionIlegalException{
        
        System.out.print("Ingrese el título del libro para devolver: ");
        String tituloDevolver = scanner.nextLine();
        System.out.print("Ingrese el autor del libro para devolver: ");
        String autorDevolver = scanner.nextLine();
        System.out.print("Ingrese el ISBN del libro para devolver: ");
        String isbnDevolver = scanner.nextLine();
        Libro libroDevolver = libreria.crearLibro(tituloDevolver, autorDevolver, isbnDevolver);
        if(libroDevolver == null){
            System.out.println("Error: no fue posible crear el Libro");
        }else{
            libreria.devolverLibro(libroDevolver);
        }
        
    }

    public static Libro eliminarUltimoLibro() throws PosicionIlegalException{
       
        return libreria.eliminarUltimoLibro();

    }

    public static void deshacerEliminarLibro(){
        
        libreria.deshacerEliminarLibro();

    }
}
