/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package facade;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import daoInterfaces.IBookDAO;
import entityes.Book;
import exceptions.DAOException;
import exceptions.FacadeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class SearchByTitleTest {

    private IBookDAO bookDAO; // Mock del DAO
    private SearchByTitle searchByTitle; // Objeto a probar

    @BeforeEach
    void setUp() {
        bookDAO = mock(IBookDAO.class); // Crear mock
        searchByTitle = new SearchByTitle(bookDAO); // Inyectar mock
    }

    @Test
    void searchByTitle_validTitle_returnsBooks() throws DAOException, FacadeException {
        // Datos de prueba
        String title = "Harry Potter";
        List<Book> mockBooks = Arrays.asList(new Book("123-4-567", "Harry Potter 1", "J.K. Rowling"),
                                             new Book("234-5-678", "Harry Potter 2", "J.K. Rowling"));

        // Configurar comportamiento del mock
        when(bookDAO.searchByTitle(title)).thenReturn(mockBooks);

        // Ejecutar el método
        List<Book> result = searchByTitle.searchByTitle(title);

        // Verificar resultados
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Harry Potter 1", result.get(0).getTitulo());

        // Verificar interacción con el mock
        verify(bookDAO, times(1)).searchByTitle(title);
    }

    @Test
    void searchByTitle_emptyTitle_throwsFacadeException() throws DAOException {
        // Datos de prueba
        String title = "  "; // Título vacío o solo espacios

        // Ejecutar y verificar excepciones
        assertThrows(FacadeException.class, () -> 
                searchByTitle.searchByTitle(title));


        // Verificar que el DAO no fue invocado
        verify(bookDAO, never()).searchByTitle(anyString());
    }

    @Test
    void searchByTitle_nullTitle_throwsFacadeException() throws DAOException {
        // Datos de prueba
        String title = null;

        // Ejecutar y verificar excepciones
        assertThrows(FacadeException.class, () -> searchByTitle.
                searchByTitle(title));

        // Verificar que el DAO no fue invocado
        verify(bookDAO, never()).searchByTitle(anyString());
    }

    @Test
    void searchByTitle_noBooksFound_returnsEmptyList() throws DAOException, FacadeException {
        // Datos de prueba
        String title = "Nonexistent Book";

        // Configurar comportamiento del mock
        when(bookDAO.searchByTitle(title)).thenReturn(Collections.emptyList());

        // Ejecutar el método
        List<Book> result = searchByTitle.searchByTitle(title);

        // Verificar resultados
        assertNotNull(result);
        assertTrue(result.isEmpty());

        // Verificar interacción con el mock
        verify(bookDAO, times(1)).searchByTitle(title);
    }

    @Test
    void searchByTitle_daoThrowsException_throwsFacadeException() throws DAOException {
        // Datos de prueba
        String title = "Faulty Book";

        // Configurar comportamiento del mock para lanzar excepción
        when(bookDAO.searchByTitle(title)).thenThrow(new DAOException("DAO error"));

        // Ejecutar y verificar excepciones
        assertThrows(FacadeException.class, () -> searchByTitle.searchByTitle(title));

        // Verificar interacción con el mock
        verify(bookDAO, times(1)).searchByTitle(title);
    }
}

