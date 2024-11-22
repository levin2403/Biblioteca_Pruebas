/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package facade;

import daoInterfaces.IBookDAO;
import entityes.Book;
import exceptions.DAOException;
import exceptions.FacadeException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class SearchByISBNTest {

    @Mock
    private IBookDAO bookDAO; // Mock para la dependencia DAO

    @InjectMocks
    private SearchByISBN searchByISBN; // Clase a probar

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializar los mocks
    }

    @Test
    void searchByISBN_validISBN_returnsBook() throws DAOException, 
            FacadeException {
        // Datos de prueba
        String isbn = "123-4-567";
        Book mockBook = new Book(isbn, "Libro de prueba", "Autor de prueba");

        // Configurar el comportamiento del mock
        when(bookDAO.searchByISBN(isbn)).thenReturn(mockBook);

        // Ejecutar el método
        Book result = searchByISBN.searchByISBN(isbn);

        // Verificar resultados
        assertNotNull(result);
        assertEquals(isbn, result.getIsbn());
        assertEquals("Libro de prueba", result.getTitulo());
        assertEquals("Autor de prueba", result.getAutor());

        // Verificar interacción con el mock
        verify(bookDAO, times(1)).searchByISBN(isbn);
    }

    @Test
    void searchByISBN_invalidFormat_throwsFacadeException() {
        // Datos de prueba: ISBN con formato incorrecto
        String invalidISBN = "1234567";

        // Ejecutar y verificar que se lanza la excepción
        assertThrows(FacadeException.class, () -> {
            searchByISBN.searchByISBN(invalidISBN);
        });

        // Verificar que el DAO no fue llamado
        verifyNoInteractions(bookDAO);
    }

    @Test
    void searchByISBN_nullOrEmptyISBN_throwsFacadeException() {
        // Prueba con un ISBN nulo
        FacadeException nullException = 
                assertThrows(FacadeException.class, () -> {
            searchByISBN.searchByISBN(null);
        });
        assertEquals("El ISBN no puede estar vacío.", 
                nullException.getMessage());

        // Prueba con un ISBN vacío
        FacadeException emptyException = 
                assertThrows(FacadeException.class, () -> {
            searchByISBN.searchByISBN("   ");
        });
        assertEquals("El ISBN no puede estar vacío.", 
                emptyException.getMessage());

        // Verificar que el DAO no fue llamado
        verifyNoInteractions(bookDAO);
    }

    @Test
    void searchByISBN_nonexistentISBN_throwsFacadeException() 
            throws DAOException {
        // Datos de prueba
        String isbn = "123-4-567";

        // Configurar el mock para devolver null (libro no encontrado)
        when(bookDAO.searchByISBN(isbn)).thenReturn(null);

        // Ejecutar y verificar que se lanza la excepción
        assertThrows(FacadeException.class, () -> {
            searchByISBN.searchByISBN(isbn);
        });

        // Verificar interacción con el mock
        verify(bookDAO, times(1)).searchByISBN(isbn);
    }

    @Test
    void searchByISBN_daoException_throwsFacadeException() throws DAOException {
        // Datos de prueba
        String isbn = "123-4-567";

        // Configurar el mock para lanzar una DAOException
        when(bookDAO.searchByISBN(isbn)).thenThrow(new 
        DAOException("Error de acceso a datos"));

        // Ejecutar y verificar que se lanza la excepción
        FacadeException exception = assertThrows(FacadeException.class, () -> {
            searchByISBN.searchByISBN(isbn);
        });

        // Verificar el mensaje de la excepción
        assertTrue(exception.getMessage().contains("Error al buscar el "
                + "libro con ISBN"));
        assertNotNull(exception.getCause());
        assertEquals("Error de acceso a datos", exception.getCause().
                getMessage());

        // Verificar interacción con el mock
        verify(bookDAO, times(1)).searchByISBN(isbn);
    }
}

