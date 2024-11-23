/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IntegrationTests;

import com.valorationService.factories.ValoratedBooksFactory;
import dao.BookDAO;
import daoInterfaces.IBookDAO;
import entityes.Book;
import exceptions.DAOException;
import exceptions.FacadeException;
import fabricas.FacadeFactory;
import facadeInterfaces.IAddBookFCD;
import valoration.Valorate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class AddBookFCDIntegration {

    /**
     * Instancia de la fachada a probar
     */
    private static IAddBookFCD addBookFCD;
    private static IBookDAO bookDAO;

    @BeforeAll
    public static void initialConfig() {
        // Instanciamos la fachada
        addBookFCD = FacadeFactory.fabricateAddBookFCD();
        
        // Fabricamos los libros valorados del sistema
        Valorate valorate = new Valorate();
        ValoratedBooksFactory valoratedFactory = 
                new ValoratedBooksFactory(valorate);
        valoratedFactory.fabricateValoratedBooks();
        
        // Asumimos que bookDAO es una instancia real obtenida de alguna manera
        bookDAO = new BookDAO();
    }

    @Test
    public void testAddBookWithValoration() 
            throws FacadeException, DAOException {
        // Datos de prueba
        Book book = new Book("978-3-160", "Cien años de soledad", 
                "Gabriel García Márquez");
        
        // Ejecutar el método que se está probando
        addBookFCD.addBook(book);
        
        // Verificación
        Book retrievedBook = bookDAO.searchByISBN("978-3-160");
        assertNotNull(retrievedBook);
        assertEquals("Cien años de soledad", retrievedBook.getTitulo());
        assertEquals("Gabriel García Márquez", retrievedBook.getAutor());
        assertNotNull(retrievedBook.getValoration());
        assertEquals((byte)5, retrievedBook.getValoration().getScore());
        assertEquals("Magnifico libro", retrievedBook.getValoration().
                getReview());
    }

    @Test
    public void testAddBookWithEmptyISBN() {
        Book book = new Book("", "Titulo", "Autor");
        Exception exception = assertThrows(FacadeException.class, () -> {
            addBookFCD.addBook(book);
        });
        assertEquals("El ISBN no puede estar vacio", exception.getMessage());
    }

    @Test
    public void testAddBookWithEmptyTitle() {
        Book book = new Book("978-3-16", "", "Autor");
        Exception exception = assertThrows(FacadeException.class, () -> {
            addBookFCD.addBook(book);
        });
        assertEquals("El titulo no puede estar vacio", exception.getMessage());
    }

    @Test
    public void testAddBookWithEmptyAuthor() {
        Book book = new Book("978-3-16", "Titulo", "");
        Exception exception = assertThrows(FacadeException.class, () -> {
            addBookFCD.addBook(book);
        });
        assertEquals("El autor no puede estar vacio", exception.getMessage());
    }

    @Test
    public void testAddBookWithInvalidISBN() {
        Book book = new Book("12345", "Titulo", "Autor");
        Exception exception = assertThrows(FacadeException.class, () -> {
            addBookFCD.addBook(book);
        });
        assertEquals("El ISBN no sigue el formato 000-0-000", 
                exception.getMessage());
    }

    @Test
    public void testAddBookWithDuplicateISBN() throws FacadeException {
        Book book1 = new Book("978-3-160", "asdasd", "asdasd");

        FacadeException exception = assertThrows(FacadeException.class, () -> {
            addBookFCD.addBook(book1);
        });

        // Verificamos que el mensaje de la excepción es el esperado
        assertEquals("El isbn ya esta ocupado por otro libro", exception.getMessage());
    }



    @Test
    public void testAddBookWithFailedValoration() {
        Book book = new Book("978-0-999", "TituloNoExistente", "AutorNoExistente");
        assertThrows(FacadeException.class, () -> {
            addBookFCD.addBook(book);
        });
    }
}

