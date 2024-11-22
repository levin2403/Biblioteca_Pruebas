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

    /**
     * Constructor para inicializar la fachada con una implementación de IBookDAO.
     *
     * @param bookDAO implementación de acceso a datos para libros.
     */
    public SearchByAuthorFCD(IBookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    /**
     * Busca libros por autor.
     *
     * @param author el nombre del autor a buscar.
     * @return una lista de libros asociados al autor.
     * @throws FacadeException si el autor es inválido o ocurre un error al acceder a los datos.
     */
    @Override
    public List<Book> searchByAuthor(String author) throws FacadeException {
        validateAuthorField(author);
        return performSearchByAuthor(author);
    }

    /**
     * Valida que el campo del autor no esté vacío ni sea nulo.
     *
     * @param author el nombre del autor a validar.
     * @throws FacadeException si el campo es inválido.
     */
    private void validateAuthorField(String author) throws FacadeException {
        if (author == null || author.trim().isEmpty()) {
            throw new FacadeException("El autor no puede estar vacío o contener solo espacios.");
        }
    }

    /**
     * Realiza la búsqueda de libros en la capa de datos.
     *
     * @param author el nombre del autor a buscar.
     * @return una lista de libros asociados al autor.
     * @throws FacadeException si ocurre un error en la capa de datos.
     */
    private List<Book> performSearchByAuthor(String author) throws FacadeException {
        try {
            return bookDAO.searchByAuthor(author);
        } catch (DAOException e) {
            throw new FacadeException("Error al buscar los libros del autor: " + author, e);
        }
    }
}

