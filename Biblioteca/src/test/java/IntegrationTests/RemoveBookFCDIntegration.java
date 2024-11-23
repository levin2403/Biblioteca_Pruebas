/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IntegrationTests;

import dao.BookDAO;
import daoInterfaces.IBookDAO;
import entityes.Book;
import exceptions.DAOException;
import exceptions.FacadeException;
import facade.RemoveBookFCD;
import facadeInterfaces.IRemoveBookFCD;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RemoveBookFCDIntegration {

    /**
     * Instancia de la fachada a probar
     */
    private static IRemoveBookFCD removeBookFCD;
    private static IBookDAO bookDAO;

    @BeforeAll
    public static void initialConfig() {
        // Asumimos que bookDAO es una instancia real obtenida de alguna manera
        bookDAO = new BookDAO();
        
        // Instanciamos la fachada
        removeBookFCD = new RemoveBookFCD(bookDAO);
    }

    @Test
    public void testRemoveBookWithValidData() 
            throws FacadeException, DAOException {
        // Datos de prueba: Preparamos el libro
        Book book = new Book("978-3-16", "Cien años de soledad", 
                "Gabriel García Márquez");
        bookDAO.addBook(book); // Añadimos el libro
        
        // Eliminamos el libro
        removeBookFCD.removeBook(book);
        
        // Verificación
        Book retrievedBook = bookDAO.searchByISBN("978-3-16");
        assertNull(retrievedBook); // Verificamos que el libro ya no exista
    }

    @Test
    public void testRemoveBookWithNullBook() {
        Exception exception = assertThrows(FacadeException.class, () -> {
            removeBookFCD.removeBook(null);
        });
        assertEquals("El libro proporcionado es nulo.", 
                exception.getMessage());
    }

    @Test
    public void testRemoveBookThatIsLent() 
            throws FacadeException, DAOException {
        // Datos de prueba: Preparamos el libro prestado
        Book book = new Book("978-3-16", "Cien años de soledad", 
                "Gabriel García Márquez");
        book.setPrestado(true); // Marcamos el libro como prestado
        bookDAO.addBook(book); // Añadimos el libro
        
        Exception exception = assertThrows(FacadeException.class, () -> {
            removeBookFCD.removeBook(book);
        });
        assertEquals("No se puede eliminar un libro que se encuentra "
                + "prestado.", exception.getMessage());
    }
}

