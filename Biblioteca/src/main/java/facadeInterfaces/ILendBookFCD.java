package facadeInterfaces;

import entityes.Loan;
import exceptions.FacadeException;

/**
 * Interfaz que define las operaciones disponibles en la fachada para gestionar
 * préstamos de libros.
 */
public interface ILendBookFCD {

    /**
     * Método para registrar un préstamo de un libro.
     *
     * @param loan El objeto Loan que contiene los datos del préstamo.
     * @throws FacadeException Si ocurre un error durante el proceso de
     * préstamo.
     */
    void lendBook(Loan loan) throws FacadeException;
}
