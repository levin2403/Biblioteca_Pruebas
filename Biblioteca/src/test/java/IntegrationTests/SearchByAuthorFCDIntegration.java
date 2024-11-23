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
import facade.SearchByAuthorFCD;
import facadeInterfaces.ISearchByAuthor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class SearchByAuthorFCDIntegration {

    /**
     * Instancia de la fachada a probar
     */
    private static ISearchByAuthor searchByAuthorFCD;
    private static IBookDAO bookDAO;

    @BeforeAll
    public static void initialConfig() {
        // Asumimos que bookDAO es una instancia real obtenida de alguna manera
        bookDAO = new BookDAO();

        // Instanciamos la fachada
        searchByAuthorFCD = new SearchByAuthorFCD(bookDAO);
    }

    @Test
    public void testSearchByAuthorWithValidData() throws FacadeException, 
            DAOException {
        // Datos de prueba: Añadimos algunos libros
        Book book1 = new Book("978-1-566", "1984", "George Orwell");
        Book book2 = new Book("948-1-741", "1984", "George Orwell");
        bookDAO.addBook(book1); 
        bookDAO.addBook(book2);
        
        // Realizamos la búsqueda
        List<Book> books = searchByAuthorFCD.searchByAuthor("George Orwell");
        
        // Verificación
        assertNotNull(books);
        assertEquals(2, books.size());
        assertEquals("1984", books.get(0).getTitulo());
        assertEquals("George Orwell", books.get(0).getAutor());
        assertEquals("1984", books.get(1).getTitulo());
        assertEquals("George Orwell", books.get(1).getAutor());
    }

    @Test
    public void testSearchByAuthorWithEmptyAuthor() {
        String author = "";
        Exception exception = assertThrows(FacadeException.class, () -> {
            searchByAuthorFCD.searchByAuthor(author);
        });
        assertEquals("El autor no puede estar vacío o contener solo espacios.", 
                exception.getMessage());
    }

    @Test
    public void testSearchByAuthorWithNullAuthor() {
        String author = null;
        Exception exception = assertThrows(FacadeException.class, () -> {
            searchByAuthorFCD.searchByAuthor(author);
        });
        assertEquals("El autor no puede estar vacío o contener solo espacios.", 
                exception.getMessage());
    }

    @Test
    public void testSearchByAuthorWithNonExistentAuthor() 
            throws FacadeException {
        // Datos de prueba
        String author = "Autor No Existente";
        
        // Realizamos la búsqueda
        List<Book> books = searchByAuthorFCD.searchByAuthor(author);
        
        // Verificación
        assertNotNull(books);
        assertTrue(books.isEmpty());
    }
}
