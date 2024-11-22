/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package facade;

import com.valorationService.integration.ExternalSystemIntegration;
import dao.BookDAO;
import entityes.Book;
import entityes.Valoration;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import exceptions.FacadeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Collections;
import java.util.List;

public class AddBookFCDTest {

    /**
     * 
     */
    @Mock
    private BookDAO bookDAO;

    /**
     * 
     */
    @Mock
    private ExternalSystemIntegration externalSystem;

    /**
     * 
     */
    @InjectMocks
    private AddBookFCD addBookFCD;

    /**
     * 
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    /**
     * 
     * @throws Exception 
     */
    @Test
    public void testAddBook_Success() throws Exception {
        // Arrange
        Book book = new Book("123-4-567", "Título de prueba", 
                "Autor de prueba");
        Valoration valoration = new Valoration((byte)5, "");

        when(bookDAO.getBooks()).thenReturn(Collections.emptyList());
        when(externalSystem.getValoration(book.getTitulo(), 
                book.getAutor())).thenReturn(valoration);

        // Act
        assertDoesNotThrow(() -> addBookFCD.addBook(book));

        // Assert
        verify(bookDAO).addBook(book);
        assertEquals(valoration, book.getValoration());
    }

    /**
     * 
     */
    @Test
    public void testAddBook_EmptyISBN_ThrowsException() {
        // Arrange
        Book book = new Book("", "Título de prueba", "Autor de prueba");

        // Act & Assert
        FacadeException exception = assertThrows(FacadeException.class, 
                () -> addBookFCD.addBook(book));
        assertEquals("El ISBN no puede estar vacio", exception.getMessage());
    }

    /**
     * 
     */
    @Test
    public void testAddBook_EmptyTitulo_ThrowsException() {
        // Arrange
        Book book = new Book("123-4-567", "", "Autor de prueba");

        // Act & Assert
        FacadeException exception = assertThrows(FacadeException.class, 
                () -> addBookFCD.addBook(book));
        assertEquals("El titulo no puede estar vacio", exception.getMessage());
    }

    /**
     * 
     */
    @Test
    public void testAddBook_EmptyAutor_ThrowsException() {
        // Arrange
        Book book = new Book("123-4-567", "Título de prueba", "");

        // Act & Assert
        FacadeException exception = assertThrows(FacadeException.class, 
                () -> addBookFCD.addBook(book));
        assertEquals("El autor no puede estar vacio", exception.getMessage());
    }

    /**
     * 
     */
    @Test
    public void testAddBook_InvalidISBNFormat_ThrowsException() {
        // Arrange
        Book book = new Book("1234567", "Título de prueba", "Autor de prueba");

        // Act & Assert
        FacadeException exception = assertThrows(FacadeException.class, 
                () -> addBookFCD.addBook(book));
        assertEquals("El ISBN no sigue el formato 000-0-000", 
                exception.getMessage());
    }

    /**
     * 
     * @throws Exception 
     */
    @Test
    public void testAddBook_DuplicateISBN_ThrowsException() throws Exception {
        // Arrange
        Book existingBook = new Book("123-4-567", "Título existente", 
                "Autor existente");
        Book newBook = new Book("123-4-567", "Título nuevo", "Autor nuevo");

        when(bookDAO.getBooks()).thenReturn(List.of(existingBook));

        // Act & Assert
        FacadeException exception = assertThrows(FacadeException.class, 
                () -> addBookFCD.addBook(newBook));
        assertEquals("El isbn ya esta ocupado por otro libro", 
                exception.getMessage());
    }

    /**
     * 
     * @throws Exception 
     */
    @Test
    public void testAddBook_ExternalSystemFails_BookAddedWithoutValoration() 
            throws Exception {
        // Arrange
        Book book = new Book("123-4-567", "Título de prueba", 
                "Autor de prueba");

        // Configurar mocks
        when(bookDAO.getBooks()).thenReturn(Collections.emptyList());
        when(externalSystem.getValoration(book.getTitulo(), book.getAutor()))
                .thenThrow(new RuntimeException("Error externo"));

        // Act & Assert: Verificar que se lanza FacadeException
        assertThrows(FacadeException.class, () -> addBookFCD.addBook(book));
    }


    
}

