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
        validateTitle(title);
        return performSearch(title);
    }

    /**
     * Valida el título proporcionado.
     *
     * @param title El título a validar.
     * @throws FacadeException Si el título no es válido.
     */
    private void validateTitle(String title) throws FacadeException {
        if (title == null || title.trim().isEmpty()) {
            throw new FacadeException("El título no puede estar vacío.");
        }
        // Validación opcional: título no debe ser demasiado largo
        if (title.length() > 255) {
            throw new FacadeException("El título es demasiado largo.");
        }
    }

    /**
     * Realiza la búsqueda de libros por título utilizando el DAO.
     *
     * @param title El título de los libros a buscar.
     * @return Lista de libros que coinciden con el título.
     * @throws FacadeException Si ocurre un error en la capa DAO.
     */
    private List<Book> performSearch(String title) throws FacadeException {
        try {
            return bookDAO.searchByTitle(title);
        } catch (DAOException e) {
            throw new FacadeException("Error al buscar los libros con "
                    + "el título '" + title + "'.", e);
        }
    }
    
}

    