package facadeInterfaces;

import entityes.Book;
import exceptions.FacadeException;
import java.util.List;

/**
 * Interfaz para la búsqueda de libros por título.
 */
public interface ISearchByTitle {

    /**
     * Permite buscar libros por el título.
     *
     * @param title El título de los libros a buscar.
     * @return Una lista de libros que coinciden con el título.
     * @throws FacadeException Si ocurre un error durante la operación.
     */
    List<Book> searchByTitle(String title) throws FacadeException;
}
