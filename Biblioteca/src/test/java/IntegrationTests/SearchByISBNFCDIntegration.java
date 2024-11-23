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
import facade.SearchByISBN;
import facadeInterfaces.ISearchByISBN;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SearchByISBNFCDIntegration {

    /**
     * Instancia de la fachada a probar
     */
    private static ISearchByISBN searchByISBNFCD;
    private static IBookDAO bookDAO;

    @BeforeAll
    public static void initialConfig() {
        // Asumimos que bookDAO es una instancia real obtenida de alguna manera
        bookDAO = new BookDAO();

        // Instanciamos la fachada
        searchByISBNFCD = new SearchByISBN(bookDAO);
    }

    @Test
    public void testSearchByISBNWithValidData() throws 
            FacadeException, DAOException {
        // Datos de prueba: Añadimos un libro
        Book book = new Book("978-3-16", "Cien años de soledad", 
                "Gabriel García Márquez");
        bookDAO.addBook(book);
        
        // Realizamos la búsqueda
        Book foundBook = searchByISBNFCD.searchByISBN("978-3-16");
        
        // Verificación
        assertNotNull(foundBook);
        assertEquals("Cien años de soledad", foundBook.getTitulo());
        assertEquals("Gabriel García Márquez", foundBook.getAutor());
        assertEquals("978-3-16", foundBook.getIsbn());
    }

    @Test
    public void testSearchByISBNWithEmptyISBN() {
        String isbn = "";
        Exception exception = assertThrows(FacadeException.class, () -> {
            searchByISBNFCD.searchByISBN(isbn);
        });
        assertEquals("El ISBN no puede estar vacío.", exception.getMessage());
    }

    @Test
    public void testSearchByISBNWithNullISBN() {
        String isbn = null;
        Exception exception = assertThrows(FacadeException.class, () -> {
            searchByISBNFCD.searchByISBN(isbn);
        });
        assertEquals("El ISBN no puede estar vacío.", exception.getMessage());
    }

    @Test
    public void testSearchByISBNWithInvalidFormat() {
        String isbn = "12345";
        Exception exception = assertThrows(FacadeException.class, () -> {
            searchByISBNFCD.searchByISBN(isbn);
        });
        assertEquals("El ISBN no sigue el formato 000-0-000", 
                exception.getMessage());
    }

    @Test
    public void testSearchByISBNWithNonExistentISBN() throws FacadeException {
        // Datos de prueba
        String isbn = "999-9-999";
        
        // Realizamos la búsqueda
        Exception exception = assertThrows(FacadeException.class, () -> {
            searchByISBNFCD.searchByISBN(isbn);
        });
        assertEquals("No se encontró un libro con el ISBN: " + isbn, 
                exception.getMessage());
    }
}

