/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dao;

import dominio.Usuario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

/**
 * Clase de pruebas unitarias para la clase Usuario.
 * Esta clase contiene métodos de prueba para asegurar que
 * la funcionalidad de gestión de usuarios se comporte como se espera.
 * 
 * @author skevi
 */
public class UsuarioDAOTest {

    private static UsuarioDAO usuarioDAO; // Instancia del DAO de usuarios
    private static Usuario usuario1; // Primer usuario para pruebas
    private static Usuario usuario2; // Segundo usuario para pruebas

    /**
     * Método que se ejecuta una vez antes de todas las pruebas.
     * Aquí se inicializa el DAO y se crean algunas instancias para las pruebas.
     */
    @BeforeAll
    public static void agregarUsuarios() {
        usuarioDAO = new UsuarioDAO(); // Inicializa el DAO de usuarios
        usuario1 = new Usuario(1 ,"kevin sanchez", "123");
        usuario2 = new Usuario(2 ,"María López", "password456");
        
        // Registra los usuarios en el DAO
        usuarioDAO.registrarUsuario(usuario1);
        usuarioDAO.registrarUsuario(usuario2);
    }

    /**
     * Prueba para verificar que se puede obtener un usuario por su ID.
     */
    @Test
    public void testObten() {
        // Suponiendo que el ID de usuario1 es 1
        Usuario resultado = usuarioDAO.obten(1);
        assertNotNull(resultado, "El usuario debería ser encontrado.");
        assertEquals(usuario1.getNombre(), resultado.getNombre(), 
                "Los nombres deberían coincidir.");
    }

    /**
     * Prueba para verificar que se puede iniciar sesión correctamente.
     */
    @Test
    public void testIniciarSesion() {
        boolean inicioExitoso = usuarioDAO.iniciarSesion("María López", "password456");
        assertTrue(inicioExitoso, "El inicio de sesión debería ser exitoso con credenciales válidas.");
    }

    /**
     * Prueba para verificar que se puede registrar un nuevo usuario.
     */
    @Test
    public void testRegistrarUsuario() {
        Usuario nuevoUsuario = new Usuario(3, "Pedro Gómez", "password789");
        usuarioDAO.registrarUsuario(nuevoUsuario); // Registra el nuevo usuario

        // Verifica que el nuevo usuario ha sido registrado correctamente
        Usuario resultado = usuarioDAO.obten(3); 
        assertNotNull(resultado, "El nuevo usuario debería ser registrado.");
        assertEquals(nuevoUsuario.getNombre(), resultado.getNombre(), 
                "Los nombres deberían coincidir.");
    }

    /**
     * Prueba para verificar que se puede actualizar la información de 
     * un usuario existente.
     */
    @Test
    public void testActualizarUsuario() {
        usuario1.setNombre("Juan Carlos Pérez"); 
        usuarioDAO.actualizarUsuario(usuario1); 

        // Verifica que el usuario ha sido actualizado correctamente
        Usuario resultado = usuarioDAO.obten(1);
        assertEquals("Juan Carlos Pérez", resultado.getNombre(), ""
                + "El nombre debería haber sido actualizado.");
    }
    
}
