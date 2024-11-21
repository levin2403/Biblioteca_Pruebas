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
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class RemoveBookFCDTest {

    private IBookDAO bookDAOMock;
    private RemoveBookFCD removeBookFCD;

    @BeforeEach
    public void setUp() {
        bookDAOMock = Mockito.mock(IBookDAO.class); // Crear el mock
        removeBookFCD = new RemoveBookFCD(bookDAOMock); // Instanciar la fachada con el mock
    }

    @Test
    public void testRemoveBook_validBook_shouldCallDAO() throws Exception {
        // Arrange
        Book book = new Book();
        book.setTitulo("Libro de prueba");
        book.setIsbn("123-456");
        book.setPrestado(false);

        // Act
        removeBookFCD.removeBook(book);

        // Assert
        verify(bookDAOMock, times(1)).removeBook(book); // Verificar que el DAO fue llamado
    }

    @Test
    public void testRemoveBook_bookIsNull_shouldThrowException() {
        // Act & Assert
        assertThrows(FacadeException.class, () -> {
            removeBookFCD.removeBook(null);
        });
    }

    @Test
    public void testRemoveBook_bookIsLent_shouldThrowException() {
        // Arrange
        Book book = new Book();
        book.setTitulo("Libro prestado");
        book.setIsbn("789-123");
        book.setPrestado(true);

        // Act & Assert
        assertThrows(FacadeException.class, () -> {
            removeBookFCD.removeBook(book);
        });
    }

    @Test
    public void testRemoveBook_DAOThrowsException_shouldWrapAndThrowFacadeException() throws Exception {
        // Arrange
        Book book = new Book();
        book.setTitulo("Libro con error");
        book.setIsbn("456-789");
        book.setPrestado(false);

        // Configurar el mock para lanzar una excepción
        doThrow(new DAOException("Error en la base de datos")).when(bookDAOMock).removeBook(book);

        // Act & Assert
        assertThrows(FacadeException.class, () -> {
            removeBookFCD.removeBook(book);
        });
    }

    @Test
    public void testRemoveBook_bookNotLent_shouldPass() throws Exception {
        // Arrange
        Book book = new Book();
        book.setTitulo("Libro disponible");
        book.setIsbn("321-654");
        book.setPrestado(false);

        // Configurar el mock para no lanzar excepciones
        doNothing().when(bookDAOMock).removeBook(book);

        // Act
        removeBookFCD.removeBook(book);

        // Assert
        verify(bookDAOMock, times(1)).removeBook(book); // Confirmar que se llamó al DAO
    }
    
}

