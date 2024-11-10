package dao;


import entityes.Libro;

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
public class LibroDAO {
    
    /**
     * Lista que almacena los libros en memoria.
     * Representa la base de datos en esta implementación.
     */
    private static List<Libro> libros = new ArrayList<>(); 

    /**
     * Busca un libro por su título.
     * 
     * @param titulo El título del libro a buscar.
     * @return El libro encontrado o null si no se encuentra.
     */
    public Libro buscarPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro; // Devuelve el libro si el título coincide.
            }
        }
        return null; // Retorna null si no se encuentra el libro.
    }
    
    /**
     * Busca un libro por su autor.
     * 
     * @param autor El autor del libro a buscar.
     * @return El libro encontrado o null si no se encuentra.
     */
    public Libro buscarPorAutor(String autor) {
        for (Libro libro : libros) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                return libro; // Devuelve el libro si el autor coincide.
            }
        }
        return null; // Retorna null si no se encuentra el libro.
    }
    
    /**
     * Busca un libro por su ISBN.
     * 
     * @param isbn El ISBN del libro a buscar.
     * @return El libro encontrado o null si no se encuentra.
     */
    public Libro buscarPorISBN(String isbn) {
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
     */
    public void agregarLibro(Libro libro) {
        libros.add(libro); // Añade el libro a la lista.
    }
    
    /**
     * Actualiza la información de un libro existente en la lista.
     * 
     * @param libro El libro con la información actualizada.
     */
    public void actualizarLibro(Libro libro) {
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
     */
    public void eliminarLibro(Libro libro) {
        libros.remove(libro); // Elimina el libro de la lista.
    }
    
    public List<Libro> obtenerLibros(){
       return LibroDAO.libros;
    }
}


