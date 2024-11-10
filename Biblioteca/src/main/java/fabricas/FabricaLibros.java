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
                                            "Gabriel García Márquez", 
                                            "Un libro triste y con gran reflexion"));
            libroDAO.agregarLibro(new Libro("978-0-452", 
                                            "Orgullo y prejuicio", 
                                            "Jane Austen", 
                                            "Muy romantico y con clase"));
            libroDAO.agregarLibro(new Libro("978-1-566", 
                                            "1984", 
                                            "George Orwell", 
                                            "Muy buen libro"));
            libroDAO.agregarLibro(new Libro("978-0-743", 
                                            "El gran Gatsby", 
                                            "F. Scott Fitzgerald", 
                                            "Emocionante, muy recomendado"));
            libroDAO.agregarLibro(new Libro("978-0-670", 
                                            "Matar a un ruiseñor", 
                                            "Harper Lee", 
                                            "Un libro interesante y cargado de impacto social"));
            libroDAO.agregarLibro(new Libro("978-0-525", 
                                            "Don Quijote de la Mancha", 
                                            "Miguel de Cervantes", 
                                            "Altamente recomendado"));
            libroDAO.agregarLibro(new Libro("978-0-394", 
                                            "El guardián entre el centeno", 
                                            "J.D. Salinger", 
                                            "Cargado de fantasia y emocionante"));
            libroDAO.agregarLibro(new Libro("978-0-7432", 
                                            "El código Da Vinci", 
                                            "Dan Brown", 
                                            "Intrigante y con mucha accion"));
            libroDAO.agregarLibro(new Libro("978-1-4767", 
                                            "Inferno", 
                                            "Dan Brown", 
                                            "No echo para cualquiera"));
            libroDAO.agregarLibro(new Libro("978-0-141", 
                                            "Crimen y castigo", 
                                            "Fiódor Dostoyevski", 
                                            "Cargado de accion y grandes momentos emocionantes"));
                
            //imprimimos para verificar.
            for (Libro libro : libroDAO.obtenerLibros()) {
                System.out.println(libro.toString());
            }
            
        } catch (DAOException e) {
            System.out.println("Error al fabricar los libros ");
        }
    }
}

