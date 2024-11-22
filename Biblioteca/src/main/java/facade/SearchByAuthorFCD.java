package facade;

import daoInterfaces.IBookDAO;
import entityes.Book;
import exceptions.DAOException;
import exceptions.FacadeException;
import facadeInterfaces.ISearchByAuthor;
import java.util.List;

/**
 * Implementación de la fachada para buscar libros por autor.
 */
public class SearchByAuthorFCD implements ISearchByAuthor {

    private final IBookDAO bookDAO;

    public SearchByAuthorFCD(IBookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public List<Book> searchByAuthor(String author) throws FacadeException {
        try {
            // Verificar que el autor no esté vacío
            if (author == null || author.isEmpty()) {
                throw new FacadeException("El autor no puede estar vacío.");
            }

            // Buscar los libros del autor en el sistema
            return bookDAO.searchByAuthor(author);

        } catch (DAOException e) {
            throw new FacadeException("Error al buscar los libros del autor " + author, e);
        }
    }
}
