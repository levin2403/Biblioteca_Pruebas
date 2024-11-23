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
import facade.SearchByTitle;
import facadeInterfaces.ISearchByTitle;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class SearchByTitleFCDIntegration {

    /**
     * Instancia de la fachada a probar
     */
    private static ISearchByTitle searchByTitleFCD;
    private static IBookDAO bookDAO;

    @BeforeAll
    public static void initialConfig() {
        // Asumimos que bookDAO es una instancia real obtenida de alguna manera
        bookDAO = new BookDAO();

        // Instanciamos la fachada
        searchByTitleFCD = new SearchByTitle(bookDAO);
    }

    @Test
    public void testSearchByTitleWithValidData() throws DAOException, 
            FacadeException {
        // Datos de prueba: Añadimos algunos libros
        Book book1 = new Book("978-1-566", "1984", "George Orwell");
        Book book2 = new Book("948-1-741", "Animal Farm", "George Orwell");
        bookDAO.addBook(book1); 
        bookDAO.addBook(book2);
        
        // Realizamos la búsqueda
        List<Book> books = searchByTitleFCD.searchByTitle("1984");
        
        // Verificación
        assertNotNull(books);
        assertEquals(1, books.size());
        assertEquals("1984", books.get(0).getTitulo());
        assertEquals("George Orwell", books.get(0).getAutor());
    }

    @Test
    public void testSearchByTitleWithEmptyTitle() {
        String title = "";
        Exception exception = assertThrows(FacadeException.class, () -> {
            searchByTitleFCD.searchByTitle(title);
        });
        assertEquals("El título no puede estar vacío.", exception.getMessage());
    }

    @Test
    public void testSearchByTitleWithNullTitle() {
        String title = null;
        Exception exception = assertThrows(FacadeException.class, () -> {
            searchByTitleFCD.searchByTitle(title);
        });
        assertEquals("El título no puede estar vacío.", exception.getMessage());
    }

    @Test
    public void testSearchByTitleWithTooLongTitle() {
        // Generamos un título demasiado largo
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 300; i++) {
            sb.append("a");
        }
        String title = sb.toString();
        
        Exception exception = assertThrows(FacadeException.class, () -> {
            searchByTitleFCD.searchByTitle(title);
        });
        assertEquals("El título es demasiado largo.", exception.getMessage());
    }

    @Test
    public void testSearchByTitleWithNonExistentTitle() throws FacadeException {
        // Datos de prueba
        String title = "Título No Existente";
        
        // Realizamos la búsqueda
        List<Book> books = searchByTitleFCD.searchByTitle(title);
        
        // Verificación
        assertNotNull(books);
        assertTrue(books.isEmpty());
    }
}

