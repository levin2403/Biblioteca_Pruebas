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

/**
 * Clase que actúa como el Data Access Object (DAO) para la entidad Libro.
 * Esta clase proporciona métodos para gestionar libros, incluyendo búsqueda, adición, actualización y eliminación.
 * 
 */
public class LibroDAO implements ILibroDAO {
    
    /**
     * Lista que almacena los libros en memoria.
     * Representa la base de datos en esta implementación.
     */
    private static List<Libro> libros = new ArrayList<>(); 

    /**
     * Devuelve el libro con el titulo mas coincidente.
     * 
     * @param titulo El título del libro a buscar.
     * @return El libro encontrado o null si no se encuentra.
     * @throws exceptions.DAOException
     */
    @Override
    public List<Libro> buscarPorTitulo(String titulo) throws DAOException {
        if (titulo == null || titulo.isEmpty()) {
            throw new DAOException("El título no puede ser nulo o vacío");
        }
        
        List<Libro> resultados = new ArrayList<>();
        String regex = ".*" + titulo + ".*"; 
        
        for (Libro libro : libros) {
            if (libro.getTitulo().matches(regex)) {
                resultados.add(libro);
            }
        }
        
        return resultados;
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
        if (autor == null || autor.isEmpty()) {
            throw new DAOException("El autor no puede ser nulo o vacío");
        }
        
        List<Libro> resultados = new ArrayList<>();
        String regex = ".*" + autor + ".*"; 
        
        for (Libro libro : libros) {
            if (libro.getAutor().matches(regex)) {
                resultados.add(libro);
            }
        }
        
        return resultados;
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
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro; // Devuelve el libro si el ISBN coincide.
            }
        }
        return null; // Retorna null si no se encuentra el libro.
    }
    
    /**
     * Agrega un nuevo libro a la lista de libros.
     * 
     * @param libro El libro que se desea agregar.
     * @throws exceptions.DAOException
     */
    @Override
    public void agregarLibro(Libro libro) throws DAOException {
        libros.add(libro); // Añade el libro a la lista.
    }
    
    /**
     * Actualiza la información de un libro existente en la lista.
     * 
     * @param libro El libro con la información actualizada.
     * @throws exceptions.DAOException
     */
    @Override
    public void actualizarLibro(Libro libro) throws DAOException {
        // Buscamos el libro en la lista usando el ISBN.
        Libro libroExistente = buscarPorISBN(libro.getIsbn());
        if (libroExistente != null) {
            // Actualizamos los atributos del libro existente.
            libroExistente.setTitulo(libro.getTitulo());
            libroExistente.setAutor(libro.getAutor());
            libroExistente.setPrestado(libro.isPrestado());
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
        libros.remove(libro); // Elimina el libro de la lista.
    }
    
    /**
     * Metodo para obtener los libros exitstentes.
     * 
     * @return Lista con los libros existentes.
     */
    public List<Libro> obtenerLibros(){
       return LibroDAO.libros;
    }
}


