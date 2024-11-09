/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 * Clase que representa un préstamo de un libro a un usuario.
 * Esta clase permite registrar un préstamo y su correspondiente devolución.
 * 
 * @author skevi
 */
public class Prestamo {
    
    /**
     * Identificador del prestamo.
     */
    private int id;
    
    /**
     * El usuario que toma prestado el libro.
     */
    private Usuario usuario;
    
    /**
     * El libro que se está prestando.
     */
    private Libro libro;

    /**
     * Constructor por defecto de la clase.
     */
    public Prestamo() {
    }

    /**
     * 
     * constructor para inicializar ambos atributos de la clase.
     * 
     * @param id identificador del prestamo.
     * @param usuario Usuario del prestamo.
     * @param libro Libro del prestamo.
     */
    public Prestamo(int id, Usuario usuario, Libro libro) {
        this.id = id;
        this.usuario = usuario;
        this.libro = libro;
    }

    /**
     * Metodo para obtener el id del Usuario;
     * 
     * @return id del usuario. 
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo para obtener el usuario.
     * @return Usuario.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Metodo para establecer el usuario.
     * 
     * @param usuario Usuario a establecer.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Metodo para obtener el libro del prestamo.
     * 
     * @return Libro. 
     */
    public Libro getLibro() {
        return libro;
    }

    /**
     * Metodo para establecer el libro del prestamo.
     * 
     * @param libro Libro a establecer.
     */
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    /**
     * Metodo toString de la clase.
     * 
     * @return Cadena de texto con los atributos de la clase.
     */
    @Override
    public String toString() {
        return "Prestamo{" + "usuario=" + usuario + ", libro=" + libro + '}';
    }

}

