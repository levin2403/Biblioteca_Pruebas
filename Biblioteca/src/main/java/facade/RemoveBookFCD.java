package facade;

import daoInterfaces.IBookDAO;
import entityes.Book;
import exceptions.DAOException;
import exceptions.FacadeException;
import facadeInterfaces.IRemoveBookFCD;

/**
 * Implementación de la fachada que maneja la eliminación de un libro.
 */
public class RemoveBookFCD implements IRemoveBookFCD {

    private final IBookDAO bookDAO;

    /**
     * Constructor con inyección de dependencias.
     *
     * @param bookDAO El DAO que maneja la persistencia de libros.
     */
    public RemoveBookFCD(IBookDAO bookDAO) {
        this.bookDAO = bookDAO; // Se inyecta el DAO de libros
    }

    @Override
    public void removeBook(Book book) throws FacadeException {
        try {
            // Verificar si el libro existe
            if (book == null || book.getIsbn() == null || book.getIsbn().isEmpty()) {
                throw new FacadeException("El libro o el ISBN proporcionado no son válidos.");
            }

            // Buscar el libro en el sistema
            Book libroExistente = bookDAO.searchByISBN(book.getIsbn());

            if (libroExistente == null) {
                throw new FacadeException("El libro con ISBN " + book.getIsbn() + " no se encuentra en el sistema.");
            }

            // Si el libro existe, proceder a eliminarlo
            bookDAO.removeBook(libroExistente);

        } catch (DAOException e) {
            throw new FacadeException("Error al eliminar el libro con ISBN " + book.getIsbn(), e);
        }
    }
}
