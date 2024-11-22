/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package facade;

import daoInterfaces.IBookDAO;
import daoInterfaces.ILoanDAO;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import entityes.Book;
import entityes.Loan;
import entityes.User;
import exceptions.DAOException;
import exceptions.FacadeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class LendBookFCDTest {

    private ILoanDAO loanDAO;
    private IBookDAO bookDAO;
    private LendBookFCD lendBookFCD;

    @BeforeEach
    void setUp() {
        loanDAO = mock(ILoanDAO.class); // Simulamos el comportamiento del DAO de préstamos
        bookDAO = mock(IBookDAO.class); // Simulamos el comportamiento del DAO de libros
        lendBookFCD = new LendBookFCD(loanDAO, bookDAO);
    }

    @Test
    void lendBook_ValidLoanWithUser_Success() throws Exception {
        // Arrange
        Book book = new Book();
        book.setPrestado(false); // El libro no está prestado inicialmente

        // Crear un usuario válido
        User user = new User(1, "John Doe", "johndoe@example.com", "securepassword");

        // Crear un préstamo con un libro y un usuario válidos
        Loan loan = new Loan();
        loan.setLibro(book);
        loan.setUsuario(user); // Usuario válido
        loan.setFechaDevolucion(LocalDate.now().plusDays(7)); // Fecha de devolución válida

        // Act
        assertDoesNotThrow(() -> lendBookFCD.lendBook(loan)); // Verificamos que no lanza excepciones

        // Assert
        verify(bookDAO).updateBook(book); // Verificamos que se actualizó la disponibilidad del libro
        verify(loanDAO).addLoan(loan); // Verificamos que se registró el préstamo
        assertTrue(book.isPrestado()); // El estado del libro debería ser "prestado"
    }

    @Test
    void lendBook_NullLoan_ThrowsException() {
        // Arrange
        Loan loan = null;

        // Act & Assert
        assertThrows(FacadeException.class, () -> lendBookFCD.lendBook(loan));
    }

    @Test
    void lendBook_NullBookInLoan_ThrowsException() {
        // Arrange
        Loan loan = new Loan();
        loan.setLibro(null); // Sin libro asociado

        // Act & Assert
        assertThrows(FacadeException.class, () -> lendBookFCD.lendBook(loan));
    }

    @Test
    void lendBook_NullUserInLoan_ThrowsException() {
        // Arrange
        Book book = new Book();
        book.setPrestado(false); // El libro no está prestado inicialmente

        Loan loan = new Loan();
        loan.setLibro(book);
        loan.setUsuario(null); // Usuario nulo
        loan.setFechaDevolucion(LocalDate.now().plusDays(7)); 

        // Act & Assert
        assertThrows(FacadeException.class, () -> lendBookFCD.lendBook(loan));
    }

    @Test
    void lendBook_PastReturnDate_ThrowsException() {
        // Arrange
        User user = new User(1, "John Doe", "johndoe@example.com", "securepassword");
        Book book = new Book();
        book.setPrestado(false);

        Loan loan = new Loan();
        loan.setLibro(book);
        loan.setUsuario(user);
        loan.setFechaDevolucion(LocalDate.now().minusDays(1)); // Fecha de devolución en el pasado

        // Act & Assert
        assertThrows(FacadeException.class, () -> lendBookFCD.lendBook(loan));
        
    }

    @Test
    void lendBook_BookAlreadyLent_ThrowsException() {
        // Arrange
        User user = new User(1, "John Doe", "johndoe@example.com", "securepassword");
        Book book = new Book();
        book.setPrestado(true); // El libro ya está prestado

        Loan loan = new Loan();
        loan.setLibro(book);
        loan.setUsuario(user);
        loan.setFechaDevolucion(LocalDate.now().plusDays(7));

        // Act & Assert
        assertThrows(FacadeException.class, () -> lendBookFCD.lendBook(loan));
    }

    @Test
    void lendBook_BookDAOThrowsException_ThrowsFacadeException() throws Exception {
        // Arrange
        User user = new User(1, "John Doe", "johndoe@example.com", "securepassword");
        Book book = new Book();
        book.setPrestado(false);

        Loan loan = new Loan();
        loan.setLibro(book);
        loan.setUsuario(user);
        loan.setFechaDevolucion(LocalDate.now().plusDays(7));

        doThrow(new DAOException("Error en el DAO")).when(bookDAO).updateBook(book);

        // Act & Assert
        assertThrows(FacadeException.class, () -> lendBookFCD.lendBook(loan));
    }

    @Test
    void lendBook_LoanDAOThrowsException_ThrowsFacadeException() throws Exception {
        // Arrange
        User user = new User(1, "John Doe", "johndoe@example.com", "securepassword");
        Book book = new Book();
        book.setPrestado(false);

        Loan loan = new Loan();
        loan.setLibro(book);
        loan.setUsuario(user);
        loan.setFechaDevolucion(LocalDate.now().plusDays(7));

        doThrow(new DAOException("Error en el DAO")).when(loanDAO).addLoan(loan);

        // Act & Assert
        assertThrows(FacadeException.class, () -> lendBookFCD.lendBook(loan));
    }
}


