/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package facade;

import daoInterfaces.IBookDAO;
import daoInterfaces.ILoanDAO;
import entityes.Book;
import entityes.Loan;
import entityes.User;
import exceptions.DAOException;
import exceptions.FacadeException;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDate;

public class ReturnBookFCDTest {

    @Mock
    private IBookDAO bookDAO;
    
    @Mock
    private ILoanDAO loanDAO;
    
    private ReturnBookFCD returnBookFCD;
    
    private Loan loan;
    private Book book;

    @BeforeEach
    void setUp() {
        // Inicializamos los mocks de los DAOs
        MockitoAnnotations.openMocks(this);
        
        // Creamos el libro con los atributos actualizados
        book = new Book("1234567890", "Ejemplo de libro", "Autor de Ejemplo",
                false);
        
        // Creamos el préstamo asociado a un usuario, libro y fecha de 
        //devolución
        loan = new Loan(new User("user1", "Usuario Ejemplo", 
                "usuario@ejemplo.com"), book, LocalDate.of(2024, 12, 31));

        // Inicializamos la fachada
        returnBookFCD = new ReturnBookFCD(bookDAO, loanDAO);
    }

    @Test
    void testReturnBookSuccessfully() throws FacadeException, DAOException {
        // Configuramos el comportamiento esperado de los mocks
        when(bookDAO.searchByISBN(book.getIsbn())).thenReturn(book);
        
        // Llamamos al método de la fachada
        returnBookFCD.returnBook(loan);
        
        // Verificamos que los métodos DAO fueron llamados correctamente
        verify(bookDAO).updateBook(book);
        verify(loanDAO).registerReturn(loan);
        
        // Aseguramos que el libro fue marcado como no prestado
        assertFalse(book.isPrestado(), "El libro debería estar marcado "
                + "como no prestado.");
    }

    @Test
    void testReturnBookWithNullBook() {
        // Configuramos un préstamo con un libro nulo
        loan.setLibro(null);
        
        // Verificamos que se lance una FacadeException
        assertThrows(FacadeException.class, () -> {
            returnBookFCD.returnBook(loan);
        });
    }

    @Test
    void testReturnBookWithNullUser() {
        // Configuramos un préstamo con un usuario nulo
        loan.setUsuario(null);
        
        // Verificamos que se lance una FacadeException
        assertThrows(FacadeException.class, () -> {
            returnBookFCD.returnBook(loan);
        });
    }

    @Test
    void testReturnBookWithNullReturnDate() {
        // Configuramos un préstamo sin fecha de devolución
        loan.setFechaDevolucion(null);
        
        // Verificamos que se lance una FacadeException
        assertThrows(FacadeException.class, () -> {
            returnBookFCD.returnBook(loan);
        });
    }

    @Test
    void testReturnBookBookNotFound() throws FacadeException, DAOException {
        // Configuramos el mock para que no encuentre el libro
        when(bookDAO.searchByISBN(book.getIsbn())).thenReturn(null);
        
        // Verificamos que se lance una FacadeException cuando 
        // el libro no se encuentra
        assertThrows(FacadeException.class, () -> {
            returnBookFCD.returnBook(loan);
        });
    }

    @Test
    void testReturnBookWithDAOException() throws DAOException {
        // Configuramos el mock para que lance una DAOException
        when(bookDAO.searchByISBN(book.getIsbn())).
                thenThrow(new DAOException("Error en DAO"));
        
        // Verificamos que se lance una FacadeException
        assertThrows(FacadeException.class, () -> {
            returnBookFCD.returnBook(loan);
        });
    }
}


