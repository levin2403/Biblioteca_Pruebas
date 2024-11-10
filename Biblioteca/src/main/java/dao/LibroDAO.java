package dao;


import daoInterfaces.ILibroDAO;
import entityes.Libro;
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

/**
 * Clase que actúa como el Data Access Object (DAO) para la entidad Libro.
 * Esta clase proporciona métodos para gestionar libros, incluyendo búsqueda, 
 * adición, actualización y eliminación.
 * 
 */
public class LibroDAO implements ILibroDAO {
    
    /**
     * Lista que almacena los libros en memoria.
     * Representa la base de datos en esta implementación.
     */
    private static List<Libro> libros = new ArrayList<>(); 

    /**
     * 
     */
    public LibroDAO() {
    }

    /**
     * Devuelve el libro con el titulo mas coincidente.
     * 
     * @param titulo El título del libro a buscar.
     * @return El libro encontrado o null si no se encuentra.
     * @throws exceptions.DAOException
     */
    @Override
    public List<Libro> buscarPorTitulo(String titulo) throws DAOException {
        try {
            if (titulo == null || titulo.isEmpty()) {
                throw new DAOException("El título no puede ser nulo o vacío");
            }

            List<Libro> resultados = new ArrayList<>();
            String regex = ".*" + Pattern.quote(titulo) + ".*"; 
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE); 

            for (Libro libro : libros) {
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
     * @param autor El autor del libro a buscar.
     * @return El libro encontrado o null si no se encuentra.
     * @throws exceptions.DAOException
     */
    @Override
    public List<Libro> buscarPorAutor(String autor) throws DAOException {
        try {
            if (autor == null || autor.isEmpty()) {
                throw new DAOException("El autor no puede ser nulo o vacío");
            }

            List<Libro> resultados = new ArrayList<>();
            String regex = ".*" + Pattern.quote(autor) + ".*"; 
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE); 

            for (Libro libro : libros) {
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
    public Libro buscarPorISBN(String isbn) throws DAOException {
        try {
            if (isbn == null || isbn.isEmpty()) {
                throw new DAOException("El ISBN no puede ser nulo o vacío");
            }

            for (Libro libro : libros) {
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
     * @param libro El libro que se desea agregar.
     * @throws exceptions.DAOException
     */
    @Override
    public void agregarLibro(Libro libro) throws DAOException {
        try{
        libros.add(libro); 
        
        }catch(Exception ex){
            throw new DAOException();
        }
    }
    
    /**
     * Actualiza la información de un libro existente en la lista.
     * 
     * @param libro El libro con la información actualizada.
     * @throws exceptions.DAOException
     */
    @Override
    public void actualizarLibro(Libro libro) throws DAOException {
        try {
            if (libro == null) {
                throw new DAOException("El libro no puede ser nulo");
            }

            if (libro.getIsbn() == null || libro.getIsbn().isEmpty()) {
                throw new DAOException("El ISBN del libro no puede ser "
                        + "nulo o vacío");
            }

            Libro libroExistente = buscarPorISBN(libro.getIsbn());
            if (libroExistente != null) {
                // Actualizamos los atributos del libro existente
                libroExistente.setTitulo(libro.getTitulo());
                libroExistente.setAutor(libro.getAutor());
                libroExistente.setPrestado(libro.isPrestado());
            } else {
                throw new DAOException("El libro con ISBN " + libro.getIsbn() 
                        + " no existe en el catálogo");
            }

        } catch (Exception ex) {
            throw new DAOException("Error al actualizar el libro", ex);
        }
    }
    
    /**
     * Elimina un libro de la lista.
     * 
     * @param libro El libro que se desea eliminar.
     * @throws exceptions.DAOException
     */
    @Override
    public void eliminarLibro(Libro libro) throws DAOException {
        try {
            if (libro == null) {
                throw new DAOException("El libro no puede ser nulo");
            }

            if (!libros.contains(libro)) {
                throw new DAOException("El libro no existe en el catálogo y "
                        + "no puede ser eliminado");
            }

            libros.remove(libro); // Elimina el libro de la lista

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
    public List<Libro> obtenerLibros() throws DAOException {
        try {
            if (LibroDAO.libros == null) {
                throw new DAOException("La lista de libros "
                        + "no está inicializada.");
            }

            return LibroDAO.libros; 

        } catch (Exception ex) {
            throw new DAOException("Error al obtener los libros", ex);
        }
    }

    
}


