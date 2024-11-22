package facade;

import entityes.Loan;
import exceptions.FacadeException;
import daoInterfaces.ILoanDAO;
import facadeInterfaces.ILendBookFCD;

/**
 * Clase que implementa la fachada para registrar un préstamo de un libro. Esta
 * clase maneja la lógica de negocio para verificar, procesar y registrar el
 * préstamo en el sistema, actualizando el estado del libro y agregándolo a la
 * lista de préstamos.
 */
public class LendBookFCD implements ILendBookFCD {

    /**
     * El objeto DAO que maneja las operaciones de acceso a datos para los
     * préstamos. Es responsable de interactuar con la lista de préstamos en
     * memoria.
     */
    private final ILoanDAO loanDAO;

    /**
     * Constructor que inyecta las dependencias necesarias para la fachada.
     *
     * @param loanDAO Objeto DAO para realizar las operaciones de préstamo.
     */
    public LendBookFCD(ILoanDAO loanDAO) {
        this.loanDAO = loanDAO;
    }

    /**
     * Método que se encarga de registrar un préstamo de libro en el sistema.
     * Realiza la validación del préstamo antes de pasarlo al DAO para su
     * almacenamiento.
     *
     * @param loan El objeto Loan que representa el préstamo de un libro.
     * @throws FacadeException Si ocurre algún error durante el proceso de
     * préstamo. Se lanza si el préstamo es nulo o si ocurre un error al
     * registrar el préstamo.
     */
    @Override
    public void lendBook(Loan loan) throws FacadeException {
        // Validación previa para verificar que el préstamo no sea nulo.
        if (loan == null) {
            throw new FacadeException("El préstamo no puede ser nulo.");
        }

        try {
            // Se delega el proceso de agregar el préstamo al DAO.
            loanDAO.addLoan(loan);
        } catch (Exception ex) {
            // Si ocurre un error en el proceso del DAO, se captura y se lanza una excepción de fachada.
            throw new FacadeException("Error al registrar el préstamo: " + ex.getMessage(), ex);
        }
    }
}
