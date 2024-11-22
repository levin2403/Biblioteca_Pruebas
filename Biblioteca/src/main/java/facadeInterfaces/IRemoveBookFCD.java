package facadeInterfaces;

import entityes.Book;
import exceptions.FacadeException;

/**
 * Interfaz que define el contrato para la eliminación de un libro.
 */
public interface IRemoveBookFCD {

    /**
     * Elimina un libro del sistema.
     *
     * @param book El libro que se desea eliminar.
     * @throws FacadeException Si ocurre un error durante la operación.
     */
    public void removeBook(Book book) throws FacadeException;
}
