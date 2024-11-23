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

    /**
     * Constructor que inyecta la dependencia del DAO de libros.
     *
     * @param bookDAO Implementación del DAO para manejar libros.
     */
    public SearchByISBN(IBookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    /**
     * Busca un libro en el sistema por su ISBN.
     *
     * @param isbn Código ISBN del libro a buscar.
     * @return Libro encontrado, o lanza una excepción si no existe.
     * @throws FacadeException Si ocurre un error o el ISBN es inválido.
     */
    @Override
    public Book searchByISBN(String isbn) throws FacadeException {
        verifyField(isbn);
        return search(isbn);
    }

    /**
     * Verifica que el campo ISBN no sea nulo ni esté vacío.
     *
     * @param isbn Código ISBN a verificar.
     * @throws FacadeException Si el ISBN es inválido.
     */
    private void verifyField(String isbn) throws FacadeException {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new FacadeException("El ISBN no puede estar vacío.");
        }
        // Validación adicional de formato (opcional)
        if (!isbn.matches("^\\d{3}-\\d-\\d{3}$")) {
            throw new FacadeException("El ISBN no sigue el formato 000-0-000");
        }
    }

    /**
     * Realiza la búsqueda del libro en el DAO.
     *
     * @param isbn Código ISBN del libro a buscar.
     * @return Libro encontrado.
     * @throws FacadeException Si ocurre un error en el DAO o no se 
     * encuentra el libro.
     */
    private Book search(String isbn) throws FacadeException {
        try {
            // Buscar el libro por ISBN en el sistema
            Book book = bookDAO.searchByISBN(isbn);

            if (book == null) {
                throw new FacadeException("No se encontró un libro con "
                        + "el ISBN: " + isbn);
            }

            return book;
        } catch (DAOException e) {
            throw new FacadeException("Error al buscar el libro con "
                    + "ISBN: " + isbn, e);
        }
    }
    
}

