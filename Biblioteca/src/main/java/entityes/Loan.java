/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entityes;

import java.time.LocalDate;

/**
 * Clase que representa un préstamo de un libro a un usuario.
 * Esta clase permite registrar un préstamo y su correspondiente devolución.
 * 
 * @author skevi
 */
public class Loan {
    
    /**
     * El usuario que toma prestado el libro.
     */
    private User usuario;
    
    /**
     * El libro que se está prestando.
     */
    private Book libro;

    /**
     * Fecha de devolucion del libro;
     */
    private LocalDate fechaDevolucion;
    
    /**
     * Constructor por defecto de la clase.
     */
    public Loan() {
    }

    /**
     * 
     * constructor para inicializar ambos atributos de la clase.
     * 
     * @param usuario User del prestamo.
     * @param libro Book del prestamo.
     */
    public Loan(User usuario, Book libro,LocalDate fechaDevolucion) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaDevolucion = fechaDevolucion;
    }

    /**
     * Metodo para obtener el usuario.
     * @return User.
     */
    public User getUsuario() {
        return usuario;
    }

    /**
     * Metodo para establecer el usuario.
     * 
     * @param usuario User a establecer.
     */
    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    /**
     * Metodo para obtener el libro del prestamo.
     * 
     * @return Book. 
     */
    public Book getLibro() {
        return libro;
    }

    /**
     * Metodo para establecer el libro del prestamo.
     * 
     * @param libro Book a establecer.
     */
    public void setLibro(Book libro) {
        this.libro = libro;
    }

    /**
     * Metodo para obtener la fecha para la devolucion del libro.
     * 
     * @return Fecha de devolucion de un libro.
     */
    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     * Metodo para establecer la fecha de devolucion del libro
     * 
     * @param fechaDevolucion fecha de devolucion a establecer para el libro.
     */
    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
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

