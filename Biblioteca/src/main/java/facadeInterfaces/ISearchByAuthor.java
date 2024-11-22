package facadeInterfaces;

import entityes.Book;
import exceptions.FacadeException;
import java.util.List;

/**
 * Interfaz para la búsqueda de libros por autor.
 */
public interface ISearchByAuthor {

    /**
     * Permite buscar libros por el autor.
     *
     * @param author El autor de los libros a buscar.
     * @return Una lista de libros del autor.
     * @throws FacadeException Si ocurre un error durante la operación.
     */
    List<Book> searchByAuthor(String author) throws FacadeException;
}
