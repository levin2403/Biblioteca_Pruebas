/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package facade;

import daoInterfaces.IBookDAO;
import entityes.Book;
import exceptions.DAOException;
import exceptions.FacadeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * 
 * @author skevi
 */
class SearchByAuthorFCDTest {

    @Mock
    private IBookDAO bookDAO;

    @InjectMocks
    private SearchByAuthorFCD searchByAuthorFCD;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); 
    }

    @Test
    void searchByAuthor_validAuthor_returnsBooks() throws DAOException, 
            FacadeException {
        // Datos de prueba
        String author = "J.K. Rowling";
        List<Book> mockBooks = Arrays.asList(
            new Book("123-4567890123", "Harry Potter and the "
                    + "Sorcerer's Stone", author),
            new Book("123-4567890456", "Harry Potter and the "
                    + "Chamber of Secrets", author)
        );

        // Configurar comportamiento del mock
        when(bookDAO.searchByAuthor(author)).thenReturn(mockBooks);

        // Ejecutar el método
        List<Book> result = searchByAuthorFCD.searchByAuthor(author);

        // Verificar resultados
        assertNotNull(result, "El resultado no debe ser nulo");
        assertEquals(2, result.size(), "El número de libros devueltos "
                + "no coincide");
        assertEquals("Harry Potter and the Sorcerer's Stone", result.get(0).
                getTitulo(), "El título del primer libro no coincide");
        assertEquals("123-4567890123", result.get(0).getIsbn(), "El ISBN del "
                + "primer libro no coincide");
        assertEquals(author, result.get(0).getAutor(), "El autor del primer "
                + "libro no coincide");

        // Verificar interacción con el mock
        verify(bookDAO, times(1)).searchByAuthor(author);
    }


    @Test
    void searchByAuthor_emptyAuthor_throwsFacadeException() {
        String emptyAuthor = " ";

        // Ejecutar el método y verificar la excepción
        FacadeException exception = assertThrows(FacadeException.class, 
            () -> searchByAuthorFCD.searchByAuthor(emptyAuthor));

        assertEquals("El autor no puede estar vacío o contener solo espacios.", 
                exception.getMessage());

        // Verificar que no se interactuó con el mock
        verifyNoInteractions(bookDAO);
    }

    @Test
    void searchByAuthor_nullAuthor_throwsFacadeException() {
        String nullAuthor = null;

        // Ejecutar el método y verificar la excepción
        FacadeException exception = assertThrows(FacadeException.class, 
            () -> searchByAuthorFCD.searchByAuthor(nullAuthor));

        assertEquals("El autor no puede estar vacío o contener solo espacios.", 
                exception.getMessage());

        // Verificar que no se interactuó con el mock
        verifyNoInteractions(bookDAO);
    }

    @Test
    void searchByAuthor_daoThrowsException_throwsFacadeException() 
            throws DAOException {
        String author = "George Orwell";

        // Configurar el mock para lanzar una excepción
        when(bookDAO.searchByAuthor(author)).thenThrow(new 
        DAOException("Error en la base de datos"));

        // Ejecutar el método y verificar la excepción
        FacadeException exception = assertThrows(FacadeException.class, 
            () -> searchByAuthorFCD.searchByAuthor(author));

        assertTrue(exception.getMessage().contains("Error al buscar los "
                + "libros del autor"));
        assertTrue(exception.getCause() instanceof DAOException);

        // Verificar interacción con el mock
        verify(bookDAO, times(1)).searchByAuthor(author);
    }

    @Test
    void searchByAuthor_validAuthorNoBooks_returnsEmptyList() 
            throws DAOException, FacadeException {
        String author = "Unknown Author";

        // Configurar el mock para devolver una lista vacía
        when(bookDAO.searchByAuthor(author)).thenReturn(Collections.
                emptyList());

        // Ejecutar el método
        List<Book> result = searchByAuthorFCD.searchByAuthor(author);

        // Verificar resultados
        assertNotNull(result);
        assertTrue(result.isEmpty());

        // Verificar interacción con el mock
        verify(bookDAO, times(1)).searchByAuthor(author);
    }
}

