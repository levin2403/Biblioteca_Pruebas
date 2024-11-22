package facadeInterfaces;

import entityes.Loan;
import exceptions.FacadeException;

/**
 * Interfaz para la devolución de un libro.
 */
public interface IReturnBookFCD {

    /**
     * Permite devolver un libro al sistema.
     *
     * @param loan
     * @throws FacadeException Si ocurre un error durante la operación.
     */
    void returnBook(Loan loan) throws FacadeException;
}
