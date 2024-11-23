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
import daoInterfaces.IUserDAO;
import entityes.Book;
import entityes.Loan;
import entityes.User;
import exceptions.DAOException;
import exceptions.FacadeException;
import facade.LendBookFCD;
import facadeInterfaces.ILendBookFCD;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class LendBookFCDIntegration {

    /**
     * Instancia de la fachada a probar
     */
    private static ILendBookFCD lendBookFCD;
    private static ILoanDAO loanDAO;
    private static IBookDAO bookDAO;
    private static IUserDAO userDAO;

    @BeforeAll
    public static void initialConfig() {
        // Asumimos que loanDAO y bookDAO son instancias reales 
        // obtenidas de alguna manera
        loanDAO = new LoanDAO();
        bookDAO = new BookDAO();
        userDAO = new UserDAO();

        // Instanciamos la fachada
        lendBookFCD = new LendBookFCD(loanDAO, bookDAO);
    }

    @Test
    public void testLendBookWithValidData() 
            throws FacadeException, DAOException {
        // Datos de prueba: Preparamos el libro y el usuario
        Book book = new Book("978-3-16", "Cien años de soledad", 
                "Gabriel García Márquez");
        User user = new User("John Doe", "john.doe@gmail.com", 
                "password123");
        bookDAO.addBook(book); // Añadimos el libro
        userDAO.addUser(user); // Añadimos el usuario
        
        // Creamos el préstamo
        Loan loan = new Loan(user, book, LocalDate.now().plusDays(10));

        // Realizamos el préstamo
        lendBookFCD.lendBook(loan);
        
        // Verificación
        Loan retrievedLoan = loanDAO.searchByBookAndUser(book, user);
        assertNotNull(retrievedLoan);
        assertEquals(book.getIsbn(), retrievedLoan.getLibro().getIsbn());
        assertEquals(user.getCorreo(), retrievedLoan.getUsuario().
                getCorreo());
        assertEquals(LocalDate.now().plusDays(10), retrievedLoan.
                getFechaDevolucion());
        assertTrue(book.isPrestado());
    }

    @Test
    public void testLendBookWithNullLoan() {
        Exception exception = assertThrows(FacadeException.class, () -> {
            lendBookFCD.lendBook(null);
        });
        assertEquals("El préstamo no puede ser nulo.", exception.getMessage());
    }

    @Test
    public void testLendBookWithNullBook() {
        User user = new User("John Doe", "john.doe@gmail.com", "password123");
        Loan loan = new Loan(user, null, LocalDate.now().plusDays(10));

        Exception exception = assertThrows(FacadeException.class, () -> {
            lendBookFCD.lendBook(loan);
        });
        assertEquals("El libro en el préstamo no puede ser nulo.", 
                exception.getMessage());
    }

    @Test
    public void testLendBookWithNullUser() {
        Book book = new Book("978-3-16", "Cien años de soledad", 
                "Gabriel García Márquez");
        Loan loan = new Loan(null, book, LocalDate.now().plusDays(10));

        Exception exception = assertThrows(FacadeException.class, () -> {
            lendBookFCD.lendBook(loan);
        });
        assertEquals("El usuario en el préstamo no puede ser nulo.", 
                exception.getMessage());
    }

    @Test
    public void testLendBookWithNullReturnDate() {
        Book book = new Book("978-3-16", "Cien años de soledad", 
                "Gabriel García Márquez");
        User user = new User("John Doe", "john.doe@gmail.com", 
                "password123");
        Loan loan = new Loan(user, book, null);

        Exception exception = assertThrows(FacadeException.class, () -> {
            lendBookFCD.lendBook(loan);
        });
        assertEquals("La fecha de devolución no puede ser nula.", 
                exception.getMessage());
    }

    @Test
    public void testLendBookWithPastReturnDate() {
        Book book = new Book("978-3-16", "Cien años de soledad", 
                "Gabriel García Márquez");
        User user = new User("John Doe", "john.doe@gmail.com", 
                "password123");
        Loan loan = new Loan(user, book, LocalDate.now().minusDays(1));

        Exception exception = assertThrows(FacadeException.class, () -> {
            lendBookFCD.lendBook(loan);
        });
        assertEquals("La fecha de devolución no puede ser anterior a la "
                + "fecha actual.", exception.getMessage());
    }

    @Test
    public void testLendBookAlreadyLent() throws FacadeException, DAOException {
        // Datos de prueba: Preparamos el libro y el usuario
        Book book = new Book("978-3-16", "Cien años de soledad", 
                "Gabriel García Márquez");
        User user = new User("John Doe", "john.doe@gmail.com", 
                "password123");
        book.setPrestado(true); // Marcamos el libro como prestado
        bookDAO.addBook(book); // Añadimos el libro
        userDAO.addUser(user); // Añadimos el usuario
        
        // Creamos el préstamo
        Loan loan = new Loan(user, book, LocalDate.now().plusDays(10));

        Exception exception = assertThrows(FacadeException.class, () -> {
            lendBookFCD.lendBook(loan);
        });
        assertEquals("El libro ya está prestado.", exception.getMessage());
    }
    
}

