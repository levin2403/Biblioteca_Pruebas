/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabricas;

import dao.LibroDAO;
import daoInterfaces.ILibroDAO;
import entityes.Libro;
import exceptions.DAOException;

/**
 *
 * @author skevi
 */
public class FabricaLibros {

    /**
     * DAO para gestionar los libros.
     */
    private ILibroDAO libroDAO;

    /**
     * Constructor que inicializa la instancia de LibroDAO.
     * 
     */
    public FabricaLibros() {
        this.libroDAO = new LibroDAO();
    }

    /**
     * Fabrica diez libros y los añade a la lista de libroDAO.
     */
    public void fabricarLibros() {
        try {
            libroDAO.agregarLibro(new Libro("978-3-16", 
                                            "Cien años de soledad", 
                                            "Gabriel García Márquez"));
            libroDAO.agregarLibro(new Libro("978-0-452", 
                                            "Orgullo y prejuicio", 
                                            "Jane Austen"));
            libroDAO.agregarLibro(new Libro("978-1-566", 
                                            "1984", 
                                            "George Orwell"));
            libroDAO.agregarLibro(new Libro("978-0-743", 
                                            "El gran Gatsby", 
                                            "F. Scott Fitzgerald"));
            libroDAO.agregarLibro(new Libro("978-0-670", 
                                            "Matar a un ruiseñor", 
                                            "Harper Lee"));
            libroDAO.agregarLibro(new Libro("978-0-525", 
                                            "Don Quijote de la Mancha", 
                                            "Miguel de Cervantes"));
            libroDAO.agregarLibro(new Libro("978-0-394", 
                                            "El guardián entre el centeno", 
                                            "J.D. Salinger"));
            libroDAO.agregarLibro(new Libro("978-0-7432", 
                                            "El código Da Vinci", 
                                            "Dan Brown"));
            libroDAO.agregarLibro(new Libro("978-1-4767", 
                                            "Inferno", 
                                            "Dan Brown"));
            libroDAO.agregarLibro(new Libro("978-0-141", 
                                            "Crimen y castigo", 
                                            "Fiódor Dostoyevski"));
                
            //imprimimos para verificar.
            for (Libro libro : libroDAO.obtenerLibros()) {
                System.out.println(libro.toString());
            }
            
        } catch (DAOException e) {
            System.out.println("Error al fabricar los libros ");
        }
    }
}

