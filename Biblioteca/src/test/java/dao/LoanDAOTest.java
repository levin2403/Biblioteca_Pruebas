package dao;

import entityes.Book;
import entityes.Loan;
import entityes.User;
import exceptions.DAOException;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase para realizar pruebas unitarias a LoanDAO.
 */
public class LoanDAOTest {

    private LoanDAO loanDAO;

    @BeforeEach
    void setUp() {
        loanDAO = new LoanDAO();
    }

    @AfterEach
    void tearDown() {
        try {
            // Asegurar que todos los préstamos sean devueltos
            List<Loan> loans = loanDAO.getLoans();
            for (Loan loan : loans) {
                loanDAO.registerReturn(loan);
            }
        } catch (DAOException e) {
            System.err.println("Error al limpiar préstamos: " + e.getMessage());
        } finally {
            // Reiniciar cualquier estado en el DAO
            loanDAO.reset();
        }
    }

    /**
     * Verifica que un préstamo se registre correctamente y que el libro se
     * marque como prestado.
     */
    @Test
    void testAddLoan() throws DAOException {
        Book book = new Book("123-456-789", "Clean Code", "Robert C. Martin");
        User user = new User(1, "Carlos Ramirez", "carlos@example.com", "password123");
        Loan loan = new Loan(user, book, LocalDate.of(2024, 12, 20));

        assertDoesNotThrow(() -> loanDAO.addLoan(loan), "No debería lanzar excepción al agregar un préstamo válido.");

        List<Loan> loans = loanDAO.getLoans();
        assertTrue(loans.contains(loan), "El préstamo debe ser agregado a la lista de préstamos.");
        assertTrue(book.isPrestado(), "El libro debe estar marcado como prestado.");
    }

    /**
     * Verifica que no se pueda agregar un préstamo nulo.
     */
    @Test
    void testAddLoanWithNullLoan() {
        assertThrows(DAOException.class, () -> loanDAO.addLoan(null), "No debería permitir un préstamo nulo.");
    }

    /**
     * Verifica que un libro pueda ser devuelto correctamente.
     */
    @Test
    void testRegisterReturn() throws DAOException {
        Book book = new Book("987-654-321", "The Pragmatic Programmer", "Andy Hunt");
        User user = new User(2, "Ana Torres", "ana@example.com", "password456");
        Loan loan = new Loan(user, book, LocalDate.of(2024, 12, 1));

        loanDAO.addLoan(loan);
        assertTrue(book.isPrestado(), "El libro debe estar prestado después de agregar el préstamo.");

        loanDAO.registerReturn(loan);
        assertFalse(book.isPrestado(), "El libro debe estar marcado como no prestado después de la devolución.");
    }

    /**
     * Verifica que no se pueda registrar una devolución con un préstamo nulo.
     */
    @Test
    void testRegisterReturnWithNullLoan() {
        assertThrows(DAOException.class, () -> loanDAO.registerReturn(null),
                "No debería permitir una devolución de préstamo nulo.");
    }

    /**
     * Verifica que se obtengan correctamente todos los préstamos registrados.
     */
    @Test
    void testGetLoans() throws DAOException {
        Book book1 = new Book("111-111-111", "Effective Java", "Joshua Bloch");
        User user1 = new User(3, "Carlos Ramirez", "carlos@example.com", "password123");

        Book book2 = new Book("222-222-222", "Refactoring", "Martin Fowler");
        User user2 = new User(4, "Ana Torres", "ana@example.com", "password456");

        Loan loan1 = new Loan(user1, book1, LocalDate.of(2024, 12, 15));
        Loan loan2 = new Loan(user2, book2, LocalDate.of(2024, 12, 18));

        loanDAO.addLoan(loan1);
        loanDAO.addLoan(loan2);

        List<Loan> loans = loanDAO.getLoans();
        assertEquals(2, loans.size(), "Debería haber dos préstamos registrados.");
        assertTrue(loans.contains(loan1), "El primer préstamo debe estar en la lista.");
        assertTrue(loans.contains(loan2), "El segundo préstamo debe estar en la lista.");
    }

    /**
     * Verifica que si no hay préstamos registrados, la lista esté vacía.
     */
    @Test
    void testGetLoansWhenNoLoansExist() throws DAOException {
        List<Loan> loans = loanDAO.getLoans();
        assertTrue(loans.isEmpty(), "La lista de préstamos debería estar vacía cuando no se ha registrado ningún préstamo.");
    }

}
