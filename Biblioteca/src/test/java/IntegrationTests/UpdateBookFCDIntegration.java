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
import facadeInterfaces.IUpdateBookFCD;
import valoration.Valorate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UpdateBookFCDIntegration {

    /**
     * Instancia de la fachada a probar
     */
    private static IUpdateBookFCD updateBookFCD;
    private static IBookDAO bookDAO;

    @BeforeAll
    public static void initialConfig() {
        // Instanciamos la fachada
        updateBookFCD = FacadeFactory.fabricateUpdateBookFCD();
        
        // Fabricamos los libros valorados del sistema
        Valorate valorate = new Valorate();
        ValoratedBooksFactory valoratedFactory = 
                new ValoratedBooksFactory(valorate);
        valoratedFactory.fabricateValoratedBooks();
        
        // Asumimos que bookDAO es una instancia real obtenida de 
        // alguna manera
        bookDAO = new BookDAO();
    }
    
        @Test
    public void testUpdateBookWithFailedValoration() throws DAOException {
        // Datos de prueba: Primero añadimos el libro al sistema
        Book initialBook = new Book("978-3-160", "Orgullo y prejuicio", 
                "Jane Austen");

        // Añadir el libro inicial
        bookDAO.addBook(initialBook);
        
        Book book = new Book("978-3-160", "TituloNoExistente", 
                "AutorNoExistente");
        Exception exception = assertThrows(FacadeException.class, () -> {
            updateBookFCD.UpdateBook(book);
        });
        
        assertEquals("La valoracion para el libro con los campos "
                + "proporcionados no ha sido encontrado", 
                exception.getMessage());
    }

    @Test
    public void testUpdateBookWithValoration() 
            throws FacadeException, DAOException {
        // Datos de prueba: Primero añadimos el libro al sistema
        Book initialBook = new Book("978-3-160", "Orgullo y prejuicio", 
                "Jane Austen");
        
        Book bookToUpdate = new Book("978-3-160", "1984", "George Orwell");

        // Añadir el libro inicial
        bookDAO.addBook(initialBook);

        // Actualizar el libro
        updateBookFCD.UpdateBook(bookToUpdate);
        
        for (Book book : bookDAO.getBooks()) {
            System.out.println(book.toString());
        }

        // Verificación
        Book retrievedBook = bookDAO.searchByISBN("978-3-160");
        assertNotNull(retrievedBook);
        assertEquals("1984", retrievedBook.getTitulo());
        assertEquals("George Orwell", retrievedBook.getAutor());
        assertNotNull(retrievedBook.getValoration());
        assertEquals((byte)5, retrievedBook.getValoration().getScore());
        assertEquals("Magnífico libro", retrievedBook.getValoration().
                getReview());
    }


    @Test
    public void testUpdateBookWithEmptyISBN() {
        Book book = new Book("", "Titulo", "Autor");
        Exception exception = assertThrows(FacadeException.class, () -> {
            updateBookFCD.UpdateBook(book);
        });
        assertEquals("El ISBN no puede estar vacio", exception.getMessage());
    }

    @Test
    public void testUpdateBookWithEmptyTitle() {
        Book book = new Book("978-3-16", "", "Autor");
        Exception exception = assertThrows(FacadeException.class, () -> {
            updateBookFCD.UpdateBook(book);
        });
        assertEquals("El titulo no puede estar vacio", exception.getMessage());
    }

    @Test
    public void testUpdateBookWithEmptyAuthor() {
        Book book = new Book("978-3-16", "Titulo", "");
        Exception exception = assertThrows(FacadeException.class, () -> {
            updateBookFCD.UpdateBook(book);
        });
        assertEquals("El autor no puede estar vacio", exception.getMessage());
    }
    
}

