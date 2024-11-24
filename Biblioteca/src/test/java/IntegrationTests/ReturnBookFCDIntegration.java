/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IntegrationTests;

import dao.BookDAO;
import dao.LoanDAO;
import dao.UserDAO;
import daoInterfaces.IBookDAO;
import daoInterfaces.ILoanDAO;
import entityes.Book;
import entityes.Loan;
import entityes.User;
import exceptions.DAOException;
import exceptions.FacadeException;
import facade.ReturnBookFCD;
import facadeInterfaces.IReturnBookFCD;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class ReturnBookFCDIntegration {

    /**
     * Instancia de la fachada a probar
     */
    private static IReturnBookFCD returnBookFCD;
    private static IBookDAO bookDAO;
    private static ILoanDAO loanDAO;
    private static UserDAO userDAO;

    @BeforeAll
    public static void initialConfig() {

        bookDAO = new BookDAO();
        loanDAO = new LoanDAO();
        userDAO = new UserDAO();

        returnBookFCD = new ReturnBookFCD(bookDAO, loanDAO);
    }

    @Test
    public void testReturnBookWithNullLoan() {
        Exception exception = assertThrows(FacadeException.class, () -> {
            returnBookFCD.returnBook(null);
        });
        assertEquals("El libro asociado al préstamo es nulo.",
                exception.getMessage());
    }

    @Test
    public void testReturnBookWithNullBook() {
        User user = new User("John Doe", "john.doe@gmail.com", "password123");
        Book book = null;
        Loan loan = new Loan(user, book, LocalDate.now().plusDays(10));

        Exception exception = assertThrows(FacadeException.class, () -> {
            returnBookFCD.returnBook(loan);
        });

        assertEquals("El libro asociado al préstamo es nulo.",
                exception.getMessage());
    }

    @Test
    public void testReturnBookWithNullUser() {
        Book book = new Book("978-3-16", "Cien años de soledad",
                "Gabriel García Márquez");
        Loan loan = new Loan(null, book, LocalDate.now().plusDays(10));

        Exception exception = assertThrows(FacadeException.class, () -> {
            returnBookFCD.returnBook(loan);
        });
        assertEquals("El usuario asociado al préstamo es nulo.",
                exception.getMessage());
    }

    @Test
    public void testReturnBookWithNullReturnDate() {
        Book book = new Book("978-3-16", "Cien años de soledad",
                "Gabriel García Márquez");
        User user = new User("John Doe", "john.doe@gmail.com", "password123");
        Loan loan = new Loan(user, book, null);

        Exception exception = assertThrows(FacadeException.class, () -> {
            returnBookFCD.returnBook(loan);
        });
        assertEquals("La fecha de devolución es nula.", exception.getMessage());
    }

    @Test
    public void testReturnBookWithNonExistentBook() throws DAOException {
        Book book = new Book("978-3-16", "Cien años de soledad",
                "Gabriel García Márquez");
        User user = new User("John Doe", "john.doe@gmail.com", "password123");
        Loan loan = new Loan(user, null, LocalDate.now().plusDays(10));

        Exception exception = assertThrows(FacadeException.class, () -> {
            returnBookFCD.returnBook(loan);
        });
        assertEquals("El libro asociado al préstamo es nulo.",
                exception.getMessage());
    }

    @Test
    public void testReturnBookWithValidData() throws FacadeException, DAOException {
        // Datos de prueba: Preparamos el libro y el préstamo
        Book book = new Book("978-3-16", "Cien años de soledad",
                "Gabriel García Márquez");
        book.setPrestado(true); // Marcamos el libro como prestado
        bookDAO.addBook(book); // Añadimos el libro

        User user = new User("John Doe", "john.doe@gmail.com",
                "password123");
        userDAO.addUser(user); // Añadimos el usuario

        Loan loan = new Loan(user, book, LocalDate.now().plusDays(10));
        loanDAO.addLoan(loan); // Añadimos el préstamo

        // Realizamos la devolución del libro
        returnBookFCD.returnBook(loan);

        // Verificación
        Book retrievedBook = bookDAO.searchByISBN("978-3-16");
        assertNotNull(retrievedBook);
        assertFalse(retrievedBook.isPrestado());

        Loan retrievedLoan = loanDAO.searchByBookAndUser(book, user);
        assertNotNull(retrievedLoan);
    }

}
