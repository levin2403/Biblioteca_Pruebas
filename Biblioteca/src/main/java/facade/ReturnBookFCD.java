package facade;

import daoInterfaces.IBookDAO;
import entityes.Book;
import exceptions.DAOException;
import exceptions.FacadeException;
import facadeInterfaces.IReturnBookFCD;

/**
 * Implementación de la fachada para devolver un libro al sistema.
 */
public class ReturnBookFCD implements IReturnBookFCD {

    private final IBookDAO bookDAO;

    public ReturnBookFCD(IBookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public void returnBook(Book book) throws FacadeException {
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

            // Marcar el libro como no prestado
            libroExistente.setPrestado(false);
            bookDAO.updateBook(libroExistente);

        } catch (DAOException e) {
            throw new FacadeException("Error al devolver el libro con ISBN " + book.getIsbn(), e);
        }
    }
}
