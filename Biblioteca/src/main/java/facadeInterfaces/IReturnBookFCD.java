package facadeInterfaces;

import entityes.Book;
import exceptions.FacadeException;

/**
 * Interfaz para la devolución de un libro.
 */
public interface IReturnBookFCD {

    /**
     * Permite devolver un libro al sistema.
     *
     * @param book El libro que se va a devolver.
     * @throws FacadeException Si ocurre un error durante la operación.
     */
    void returnBook(Book book) throws FacadeException;
}
