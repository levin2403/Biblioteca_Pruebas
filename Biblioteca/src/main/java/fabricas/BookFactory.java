/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabricas;

import dao.BookDAO;
import entityes.Book;
import exceptions.DAOException;
import daoInterfaces.IBookDAO;
import entityes.Valoration;

/**
 *
 * @author skevi
 */
public class BookFactory {

    /**
     * DAO para gestionar los libros.
     */
    private IBookDAO libroDAO;

    /**
     * Constructor que inicializa la instancia de BookDAO.
     * 
     */
    public BookFactory() {
        this.libroDAO = new BookDAO();
    }

    /**
     * Fabrica diez libros y los añade a la lista de libroDAO.
     */
    public void fabricateBooks() {
        try {
            
            Valoration valoration1 = new Valoration((byte)5, "Maginifico libro");
            Valoration valoration2 = new Valoration((byte)3, "Un libro emocionante");
            Valoration valoration3 = new Valoration((byte)4, "Triste y emotivo en toda la historia");
            Valoration valoration4 = new Valoration((byte)2, "Cargado de emotividad y reflexion");
            Valoration valoration5 = new Valoration((byte)4, "Muy interesante y conmovedor");
//            Valoration valoration6 = new Valoration((byte)3, "lleno de emotividad");
            
            
            libroDAO.addBook(new Book("978-3-16", 
                                            "Cien años de soledad", 
                                            "Gabriel García Márquez",
                                             valoration1));
            libroDAO.addBook(new Book("978-0-452", 
                                            "Orgullo y prejuicio", 
                                            "Jane Austen",
                                             valoration2));
            libroDAO.addBook(new Book("978-1-566", 
                                            "1984", 
                                            "George Orwell",
                                             valoration3));
            libroDAO.addBook(new Book("978-0-743", 
                                            "El gran Gatsby", 
                                            "F. Scott Fitzgerald",
                                             valoration4));
            libroDAO.addBook(new Book("938-0-143", 
                                            "El gran Gatsby", 
                                            "F. Scott Fitzgerald",
                                             valoration4));
            libroDAO.addBook(new Book("978-0-525", 
                                            "Don Quijote de la Mancha", 
                                            "Miguel de Cervantes",
                                             valoration3));
            libroDAO.addBook(new Book("948-1-741", 
                                            "1984", 
                                            "George Orwell",
                                             valoration3));
            libroDAO.addBook(new Book("578-0-123", 
                                            "Orgullo y prejuicio", 
                                            "Jane Austen",
                                             valoration2));
            libroDAO.addBook(new Book("978-1-4767", 
                                            "Inferno", 
                                            "Dan Brown",
                                             valoration5));
            libroDAO.addBook(new Book("978-0-452", 
                                            "Orgullo y prejuicio", 
                                            "Jane Austen",
                                             valoration2));
                
            //imprimimos para verificar.
            for (Book libro : libroDAO.getBooks()) {
                System.out.println(libro.toString());
            }
            
        } catch (DAOException e) {
            System.out.println("Error al fabricar los libros ");
        }
    }
}

