/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dao;

import entityes.Libro;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

/**
 * Clase de pruebas unitarias para la clase LibroDAO.
 * Esta clase contiene métodos de prueba para asegurar que
 * la funcionalidad del DAO se comporte como se espera.
 * 
 * @author skevi
 */
public class LibroDAOTest {
    
    private static LibroDAO libroDAO; // Instancia del DAO
    private static Libro libro1; // Primera instancia de libro
    private static Libro libro2; // Segunda instancia de libro
    
    /**
     * Constructor de la clase LibroTest.
     */
    public LibroDAOTest() {}

    /**
     * Método que se ejecuta una vez antes de todas las pruebas.
     * Aquí se inicializa el DAO y se agregan algunos libros para las pruebas.
     */
    @BeforeAll
    public static void agregarLibros(){
        libroDAO = new LibroDAO(); // Inicializa el DAO
        libro1 = new Libro("978-3-16-148410-0", "El Principito", 
                "Antoine de Saint-Exupéry");
        libro2 = new Libro("978-0-452-28423-4" ,"1984", "George Orwell");
        
        // Agrega libros al DAO para las pruebas
        libroDAO.agregarLibro(libro1);
        libroDAO.agregarLibro(libro2);
    }
    
    /**
     * Prueba la adición de un libro.
     */
    @Test
    public void testAgregarLibro() {
        Libro libroNuevo = new Libro("978-0-7432-7356-7", "Fahrenheit 451", 
                "Ray Bradbury");
        libroDAO.agregarLibro(libroNuevo);
        
        Libro resultado = libroDAO.buscarPorTitulo(libroNuevo.getTitulo());
        assertNotNull(resultado, "El nuevo libro debería ser encontrado.");
        assertEquals("Fahrenheit 451", resultado.getTitulo(), 
                "El título del nuevo libro debería ser 'Fahrenheit 451'.");
    }
    
    /**
     * Prueba la búsqueda de un libro por su título.
     */
    @Test
    public void testBuscarPorTitulo(){
        Libro resultado = libroDAO.buscarPorTitulo("1984");
        assertNotNull(resultado, "El libro debería ser encontrado.");
        assertEquals("1984", resultado.getTitulo(), "El título "
                + "debería ser 'El Principito'.");
    }
    
    /**
     * Prueba la búsqueda de un libro por su autor.
     */
    @Test
    public void testBuscarPorAutor(){
        Libro resultado = libroDAO.buscarPorAutor("George Orwell");
        assertNotNull(resultado, "El libro debería ser encontrado.");
        assertEquals("1984", resultado.getTitulo(), "El título debería ser '1984'.");
    }
    
    
    /**
     * Prueba la búsqueda de un libro por su ISBN.
     */
    @Test
    public void testBuscarPorISBN() {
        Libro resultado = libroDAO.buscarPorISBN("978-0-452-28423-4");
        assertNotNull(resultado, "El libro debería ser encontrado.");
        assertEquals("1984", resultado.getTitulo(), 
                "El título debería ser '1984'.");
    }
    
    /**
     * Prueba la actualización de un libro.
     */
    @Test
    public void testActualizarLibro() {
        libro1.setTitulo("El Principito (Edición Especial)");
        libroDAO.actualizarLibro(libro1);
        
        Libro resultado = libroDAO.buscarPorTitulo("El Principito (Edición Especial)");
        assertNotNull(resultado, "El libro actualizado debería ser encontrado.");
        assertEquals("El Principito (Edición Especial)", resultado.getTitulo(), "El título debería haber sido actualizado.");
    }
    
    /**
     * Prueba la eliminación de un libro.
     */
    @Test
    public void testEliminaLibro() {
        libroDAO.eliminarLibro(libro1);
        Libro resultado = libroDAO.buscarPorTitulo("El Principito");
        assertNull(resultado, "El libro debería haber sido eliminado.");
    }
    
}
