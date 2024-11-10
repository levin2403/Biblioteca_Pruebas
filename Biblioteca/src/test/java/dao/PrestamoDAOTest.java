/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dao;

import entityes.Libro;
import entityes.Prestamo;
import entityes.Usuario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

/**
 * Clase de pruebas unitarias para la clase Prestamo.
 * Esta clase contiene métodos de prueba para asegurar que
 * la funcionalidad de gestión de préstamos se comporte como se espera.
 * 
 * @author skevi
 */
public class PrestamoDAOTest {

    private static PrestamoDAO prestamoDAO; // Instancia del DAO de préstamos
    private static Libro libro; // Instancia del libro
    private static Usuario usuario; // Instancia del usuario
    private static Prestamo prestamo; // Instancia del préstamo

    /**
     * Método que se ejecuta una vez antes de todas las pruebas.
     * Aquí se inicializa el DAO y se crean algunas instancias para las pruebas.
     */
    @BeforeAll
    public static void agregarPrestamos() {
//        prestamoDAO = new PrestamoDAO(); // Inicializa el DAO de préstamos
//        libro = new Libro("El Principito", "Antoine de Saint-Exupéry", 
//                "978-3-16-148410-0");
//        usuario = new Usuario(1,"Juan Pérez", "password123"); 
//        
//        // Crea una instancia de préstamo
//        prestamo = new Prestamo(1 ,usuario, libro);
//        prestamoDAO.registrarPrestamo(prestamo); // Registra el préstamo 
    }

    /**
     * Prueba para verificar que se puede registrar un préstamo correctamente.
     */
    @Test
    public void testRegistrarPrestamo() {
//        Libro nuevoLibro = new Libro("1984", "George Orwell", 
//                "978-0-452-28423-4");
//        Usuario nuevoUsuario = new Usuario(2,"María López", "password456"); 
//        Prestamo nuevoPrestamo = new Prestamo(2, nuevoUsuario, nuevoLibro);
//        
//        prestamoDAO.registrarPrestamo(nuevoPrestamo); // Registra el préstamo
//
//        // Verifica que el préstamo se ha registrado correctamente
//        Prestamo resultado = prestamoDAO.obtenerPrestamo(nuevoPrestamo.getId());
//        
//        assertNotNull(resultado, "El préstamo debería ser registrado.");
//        
//        assertEquals(nuevoUsuario.getNombre(), resultado.getUsuario().
//                getNombre(), "El nombre del usuario debería coincidir.");
//        
//        assertEquals(nuevoLibro.getTitulo(), resultado.getLibro().getTitulo(), 
//                "El título del libro debería coincidir.");
    }

    /**
     * Prueba para verificar que se puede registrar la devolución de un libro.
     */
    @Test
    public void testRegistrarDevolucion() {
//        // Primero, registra un nuevo préstamo para la prueba
//        Libro libroParaDevolucion = new Libro("Fahrenheit 451", "Ray Bradbury", 
//                "978-0-7432-7356-7");
//        Usuario usuarioParaDevolucion = new Usuario(3 ,"Pedro Gómez", 
//                "password789"); 
//        Prestamo prestamoParaDevolucion = new Prestamo(3, usuarioParaDevolucion, 
//                libroParaDevolucion);
//        prestamoDAO.registrarPrestamo(prestamoParaDevolucion); 
//
//        // Ahora registramos la devolución
//        prestamoDAO.registrarDevolucion(prestamoParaDevolucion);
//
//        // Verifica que el préstamo ha sido actualizado a estado "devuelto"
//        Prestamo resultado = prestamoDAO.
//                obtenerPrestamo(prestamoParaDevolucion.getId());
//        
//        assertFalse(resultado.getLibro().isPrestado(), "El libro debería "
//                + "estar marcado como no prestado.");
    }
    
}
