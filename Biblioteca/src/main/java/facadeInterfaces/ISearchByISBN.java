package facadeInterfaces;

import entityes.Book;
import exceptions.FacadeException;

/**
 * Interfaz para la búsqueda de libros por ISBN.
 */
public interface ISearchByISBN {

    /**
     * Permite buscar un libro por su ISBN.
     *
     * @param isbn El ISBN del libro a buscar.
     * @return El libro con el ISBN proporcionado.
     * @throws FacadeException Si ocurre un error durante la operación.
     */
    Book searchByISBN(String isbn) throws FacadeException;
}
