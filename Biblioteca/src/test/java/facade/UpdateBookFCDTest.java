/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package facade;

import com.valorationService.facadeInterfaces.IValorateFCD;
import daoInterfaces.IBookDAO;
import entityes.Book;
import entityes.Valoration;
import exceptions.FacadeException;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UpdateBookFCDTest {

    private UpdateBookFCD updateBookFCD;
    private IBookDAO bookDAOMock;
    private IValorateFCD valorateFCDMock;

    @BeforeEach
    public void setUp() {
        // Mock de las dependencias
        bookDAOMock = mock(IBookDAO.class);
        valorateFCDMock = mock(IValorateFCD.class);

        // Crear instancia de la fachada con las dependencias mockeadas
        updateBookFCD = new UpdateBookFCD(bookDAOMock, valorateFCDMock);
    }

    @Test
    public void testUpdateBook_ValidBook_ShouldUpdateBook() throws Exception {
        // Arrange
        Book book = new Book("123-4-567", "Título de prueba", 
                "Autor de prueba");
        Valoration valoration = new Valoration((byte)4, "magnifico");
        
        // Simula el comportamiento de obtener la valoración
        when(valorateFCDMock.getValoration(book.getTitulo(), 
                book.getAutor())).thenReturn(valoration);
        
        // Simula la actualización del libro
        doNothing().when(bookDAOMock).updateBook(book);

        // Act
        updateBookFCD.UpdateBook(book);

        // Assert
        verify(bookDAOMock, times(1)).updateBook(book); 
        assertEquals(valoration, book.getValoration()); 
    }

    @Test
    public void testUpdateBook_EmptyISBN_ShouldThrowFacadeException() {
        // Arrange
        Book book = new Book("", "Título de prueba", "Autor de prueba");

        // Act & Assert
        FacadeException exception = assertThrows(FacadeException.class, 
                () -> updateBookFCD.UpdateBook(book));
        assertEquals("El ISBN no puede estar vacio", exception.getMessage());
    }

    @Test
    public void testUpdateBook_EmptyTitle_ShouldThrowFacadeException() {
        // Arrange
        Book book = new Book("123-4-567", "", "Autor de prueba");

        // Act & Assert
        assertThrows(FacadeException.class,
                () -> updateBookFCD.UpdateBook(book));
    }

    @Test
    public void testUpdateBook_EmptyAuthor_ShouldThrowFacadeException() {
        // Arrange
        Book book = new Book("123-4-567", "Título de prueba", "");

        // Act & Assert
        assertThrows(FacadeException.class, 
                () -> updateBookFCD.UpdateBook(book));
    }

    @Test
    public void testUpdateBook_ValorateThrowsException_ShouldSaveBookWithoutValoration() 
            throws Exception {
        // Arrange
        Book book = new Book("123-4-567", "Título de prueba", 
                "Autor de prueba");

        // Simula que el servicio de valoración falla
        when(valorateFCDMock.getValoration(book.getTitulo(), book.getAutor()))
            .thenThrow(new Exception("Error al obtener valoración"));

        // Simula que el método updateBook del DAO no haga nada
        doNothing().when(bookDAOMock).updateBook(book);

        // Act & Assert
        // Espera que se lance una excepción de tipo FacadeException
        assertThrows(FacadeException.class, () -> {
            updateBookFCD.UpdateBook(book);
        });

        // Verifica que el método updateBook fue llamado exactamente UNA vez
        verify(bookDAOMock, times(1)).updateBook(book); 

        // Verifica que el libro se guarda sin valoración
        assertNull(book.getValoration()); 
    }



    @Test
    public void testUpdateBook_ValorateThrowsException_() throws Exception {
        // Arrange
        Book book = new Book("123-4-567", "Título de prueba", 
                "Autor de prueba");
        
        // Simula que el servicio de valoración falla
        when(valorateFCDMock.getValoration(book.getTitulo(), book.getAutor()))
            .thenThrow(new Exception("Error al obtener valoración"));

        // Act & Assert
        assertThrows(FacadeException.class, 
                () -> updateBookFCD.UpdateBook(book));
    }
}

