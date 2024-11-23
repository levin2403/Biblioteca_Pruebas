package facade;

import daoInterfaces.IBookDAO;
import daoInterfaces.ILoanDAO;
import entityes.Book;
import entityes.Loan;
import exceptions.DAOException;
import exceptions.FacadeException;
import facadeInterfaces.IReturnBookFCD;

/**
 * Implementación de la fachada para devolver un libro al sistema.
 */
public class ReturnBookFCD implements IReturnBookFCD {

    /**
     * DAO para interactuar con los libros.
     */
    private final IBookDAO bookDAO;

    /**
     * DAO para interactuar con los préstamos.
     */
    private final ILoanDAO loanDAO;

    /**
     * Constructor que inicializa la fachada con los DAOs necesarios.
     *
     * @param bookDAO DAO para interactuar con los libros.
     * @param loanDAO DAO para interactuar con los préstamos.
     */
    public ReturnBookFCD(IBookDAO bookDAO, ILoanDAO loanDAO) {
        this.bookDAO = bookDAO;
        this.loanDAO = loanDAO;
    }

    /**
     * Devuelve un libro al sistema.
     *
     * @param loan el préstamo que se va a devolver.
     * @throws FacadeException si el préstamo es nulo o contiene campos 
     * inválidos, o si ocurre un error al interactuar con los DAOs.
     */
    @Override
    public void returnBook(Loan loan) throws FacadeException {
        verifyFields(loan);  // Verifica los campos del préstamo
        performBookReturning(loan);  // Realiza la devolución del libro
    }

    /**
     * Verifica que los campos del préstamo sean válidos.
     *
     * @param loan el préstamo a verificar.
     * @throws FacadeException si algún campo del préstamo es inválido.
     */
    private void verifyFields(Loan loan) throws FacadeException {
        if (loan == null) {
            throw new FacadeException("El libro asociado al "
                    + "préstamo es nulo.");
        }
        // Verificar si el libro existe
        if (loan.getLibro() == null) {
            throw new FacadeException("El libro asociado al "
                    + "préstamo es nulo.");
        }
        // Verificar si el usuario existe
        if (loan.getUsuario() == null) {
            throw new FacadeException("El usuario asociado al "
                    + "préstamo es nulo.");
        }
        // Verificar si la fecha de devolución es válida
        if (loan.getFechaDevolucion() == null) {
            throw new FacadeException("La fecha de devolución es nula.");
        }
    }


    /**
     * Realiza la devolución del libro, marcándolo como no prestado y 
     * registrando la devolución en el préstamo.
     *
     * @param loan el préstamo que se va a devolver.
     * @throws FacadeException si ocurre un error al 
     * interactuar con los DAOs.
     */
    private void performBookReturning(Loan loan) throws FacadeException {
        try {
            // Buscar el libro en el sistema
            Book libroExistente = bookDAO.searchByISBN(loan.
                    getLibro().getIsbn());

            // Verificar si el libro existe
            if (libroExistente == null) {
                throw new FacadeException("El libro con ISBN " + 
                        loan.getLibro().getIsbn() + " no se encuentra "
                                + "en el sistema.");
            }

            // Marcar el libro como no prestado
            libroExistente.setPrestado(false);
            bookDAO.updateBook(libroExistente);

            // Registrar la devolución del libro en el sistema de préstamos
            loanDAO.registerReturn(loan);

        } catch (DAOException e) {
            // Captura y relanza cualquier excepción del DAO como 
            // una FacadeException
            throw new FacadeException("Error al devolver el libro con ISBN " + 
                    loan.getLibro().getIsbn(), e);
        }
    }
    
}

