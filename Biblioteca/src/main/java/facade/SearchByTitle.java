package facade;

import daoInterfaces.IBookDAO;
import entityes.Book;
import exceptions.DAOException;
import exceptions.FacadeException;
import facadeInterfaces.ISearchByTitle;
import java.util.List;

/**
 * Implementación de la fachada para buscar libros por título.
 */
public class SearchByTitle implements ISearchByTitle {

    private final IBookDAO bookDAO;

    public SearchByTitle(IBookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public List<Book> searchByTitle(String title) throws FacadeException {
        try {
            // Verificar que el título no esté vacío
            if (title == null || title.isEmpty()) {
                throw new FacadeException("El título no puede estar vacío.");
            }

            // Buscar los libros por título en el sistema
            return bookDAO.searchByTitle(title);

        } catch (DAOException e) {
            throw new FacadeException("Error al buscar los libros con el título " + title, e);
        }
    }
}
    