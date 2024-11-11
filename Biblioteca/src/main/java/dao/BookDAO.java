package dao;


import entityes.Book;
import exceptions.DAOException;

/**
 * Clase que actúa como el Data Access Object (DAO) para la entidad Libro.
 * Esta clase proporciona métodos para buscar, agregar, actualizar y eliminar libros.
 * 
 * @author skevi
 */
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import daoInterfaces.IBookDAO;

/**
 * Clase que actúa como el Data Access Object (DAO) para la entidad Libro.
 * Esta clase proporciona métodos para gestionar libros, incluyendo búsqueda, 
 * adición, actualización y eliminación.
 * 
 */
public class BookDAO implements IBookDAO {
    
    /**
     * Lista que almacena los libros en memoria.
     * Representa la base de datos en esta implementación.
     */
    private static List<Book> books = new ArrayList<>(); 

    /**
     * 
     */
    public BookDAO() {
    }

    /**
     * Devuelve el libro con el titulo mas coincidente.
     * 
     * @param title El título del libro a buscar.
     * @return El libro encontrado o null si no se encuentra.
     * @throws exceptions.DAOException
     */
    @Override
    public List<Book> searchByTitle(String title) throws DAOException {
        try {
            if (title == null || title.isEmpty()) {
                throw new DAOException("El título no puede ser nulo o vacío");
            }

            List<Book> resultados = new ArrayList<>();
            String regex = ".*" + Pattern.quote(title) + ".*"; 
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE); 

            for (Book libro : books) {
                if (pattern.matcher(libro.getTitulo()).matches()) {
                    resultados.add(libro);
                }
            }

            return resultados;

        } catch (Exception ex) {
            throw new DAOException("Error al buscar libros por título", ex);
        }
    }

    
    /**
     * Devuelve el libro con el autor mas coincidente.
     * 
     * @param author El autor del libro a buscar.
     * @return El libro encontrado o null si no se encuentra.
     * @throws exceptions.DAOException
     */
    @Override
    public List<Book> searchByAuthor(String author) throws DAOException {
        try {
            if (author == null || author.isEmpty()) {
                throw new DAOException("El autor no puede ser nulo o vacío");
            }

            List<Book> resultados = new ArrayList<>();
            String regex = ".*" + Pattern.quote(author) + ".*"; 
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE); 

            for (Book libro : books) {
                if (pattern.matcher(libro.getAutor()).matches()) {
                    resultados.add(libro);
                }
            }

            return resultados;

        } catch (Exception ex) {
            throw new DAOException("Error al buscar libros por autor", ex);
        }
    }

    
    /**
     * Devuelve el libro con el ISBN mas coincidente.
     * 
     * @param isbn El ISBN del libro a buscar.
     * @return El libro encontrado o null si no se encuentra.
     * @throws exceptions.DAOException
     */
    @Override
    public Book searchByISBN(String isbn) throws DAOException {
        try {
            if (isbn == null || isbn.isEmpty()) {
                throw new DAOException("El ISBN no puede ser nulo o vacío");
            }

            for (Book libro : books) {
                if (libro.getIsbn().equals(isbn)) {
                    return libro; 
                }
            }

            return null; 

        } catch (Exception ex) {
            throw new DAOException("Error al buscar libro por ISBN", ex);
        }
    }

    
    /**
     * Agrega un nuevo libro a la lista de libros.
     * 
     * @param book El libro que se desea agregar.
     * @throws exceptions.DAOException
     */
    @Override
    public void addBook(Book book) throws DAOException {
        try{
        books.add(book); 
        
        }catch(Exception ex){
            throw new DAOException();
        }
    }
    
    /**
     * Actualiza la información de un libro existente en la lista.
     * 
     * @param book El libro con la información actualizada.
     * @throws exceptions.DAOException
     */
    @Override
    public void updateBook(Book book) throws DAOException {
        try {
            if (book == null) {
                throw new DAOException("El libro no puede ser nulo");
            }

            if (book.getIsbn() == null || book.getIsbn().isEmpty()) {
                throw new DAOException("El ISBN del libro no puede ser "
                        + "nulo o vacío");
            }

            Book libroExistente = searchByISBN(book.getIsbn());
            if (libroExistente != null) {
                // Actualizamos los atributos del libro existente
                libroExistente.setTitulo(book.getTitulo());
                libroExistente.setAutor(book.getAutor());
                libroExistente.setPrestado(book.isPrestado());
            } else {
                throw new DAOException("El libro con ISBN " + book.getIsbn() 
                        + " no existe en el catálogo");
            }

        } catch (Exception ex) {
            throw new DAOException("Error al actualizar el libro", ex);
        }
    }
    
    /**
     * Elimina un libro de la lista.
     * 
     * @param book El libro que se desea eliminar.
     * @throws exceptions.DAOException
     */
    @Override
    public void removeBook(Book book) throws DAOException {
        try {
            if (book == null) {
                throw new DAOException("El libro no puede ser nulo");
            }

            if (!books.contains(book)) {
                throw new DAOException("El libro no existe en el catálogo y "
                        + "no puede ser eliminado");
            }

            books.remove(book); // Elimina el libro de la lista

        } catch (Exception ex) {
            throw new DAOException("Error al intentar eliminar el libro", ex);
        }
    }

    
    /**
     * Metodo para obtener los libros exitstentes.
     * 
     * @return Lista con los libros existentes.
     * @throws exceptions.DAOException
     */
    @Override
    public List<Book> getBooks() throws DAOException {
        try {
            if (BookDAO.books == null) {
                throw new DAOException("La lista de libros "
                        + "no está inicializada.");
            }

            return BookDAO.books; 

        } catch (Exception ex) {
            throw new DAOException("Error al obtener los libros", ex);
        }
    }

    
}


