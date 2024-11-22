package facade;

import daoInterfaces.IBookDAO;
import entityes.Book;
import exceptions.DAOException;
import exceptions.FacadeException;
import facadeInterfaces.ISearchByISBN;

/**
 * Implementación de la fachada para buscar un libro por ISBN.
 */
public class SearchByISBN implements ISearchByISBN {

    private final IBookDAO bookDAO;

    public SearchByISBN(IBookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public Book searchByISBN(String isbn) throws FacadeException {
        try {
            // Verificar que el ISBN no esté vacío
            if (isbn == null || isbn.isEmpty()) {
                throw new FacadeException("El ISBN no puede estar vacío.");
            }

            // Buscar el libro por ISBN en el sistema
            Book book = bookDAO.searchByISBN(isbn);

            if (book == null) {
                throw new FacadeException("No se encontró un libro con el ISBN proporcionado.");
            }

            return book;

        } catch (DAOException e) {
            throw new FacadeException("Error al buscar el libro con ISBN " + isbn, e);
        }
    }
}
