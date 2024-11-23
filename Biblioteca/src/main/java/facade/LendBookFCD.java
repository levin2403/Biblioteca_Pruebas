package facade;

import daoInterfaces.IBookDAO;
import entityes.Loan;
import exceptions.FacadeException;
import daoInterfaces.ILoanDAO;
import entityes.Book;
import exceptions.DAOException;
import facadeInterfaces.ILendBookFCD;
import java.time.LocalDate;

/**
 * 
 * @author skevi
 */
public class LendBookFCD implements ILendBookFCD {

    private final ILoanDAO loanDAO;
    private final IBookDAO bookDAO;

    public LendBookFCD(ILoanDAO loanDAO, IBookDAO bookDAO) {
        this.loanDAO = loanDAO;
        this.bookDAO = bookDAO;
    }

    @Override
    public void lendBook(Loan loan) throws FacadeException {
        validateLoan(loan); 
        validateLoanDate(loan); 
        updateBookAvailability(loan); 
        registerLoan(loan); 
    }

    private void validateLoan(Loan loan) throws FacadeException {
        if (loan == null) {
            throw new FacadeException("El préstamo no puede ser nulo.");
        }
        if (loan.getLibro() == null) {
            throw new FacadeException("El libro en el préstamo no puede "
                    + "ser nulo.");
        }
        if (loan.getUsuario() == null) {
            throw new FacadeException("El usuario en el préstamo no puede "
                    + "ser nulo.");
        }
        if (loan.getFechaDevolucion() == null) {
            throw new FacadeException("La fecha de devolución no puede "
                    + "ser nula.");
        }
    }

    private void validateLoanDate(Loan loan) throws FacadeException {
        if (loan.getFechaDevolucion().isBefore(LocalDate.now())) {
            throw new FacadeException("La fecha de devolución no puede "
                    + "ser anterior a la fecha actual.");
        }
    }

    private void updateBookAvailability(Loan loan) throws FacadeException {
        try {
            Book book = loan.getLibro();
            if (book.isPrestado()) {
                throw new FacadeException("El libro ya está prestado.");
            }
            book.setPrestado(true);
            bookDAO.updateBook(book);
        } catch (DAOException ex) {
            throw new FacadeException("Error al actualizar la "
                    + "disponibilidad del libro.", ex);
        }
    }

    private void registerLoan(Loan loan) throws FacadeException {
        try {
            loanDAO.addLoan(loan);
        } catch (DAOException ex) {
            throw new FacadeException("Error al registrar el préstamo.", ex);
        }
    }
}

