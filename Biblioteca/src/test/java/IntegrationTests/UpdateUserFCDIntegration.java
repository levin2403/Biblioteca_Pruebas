/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IntegrationTests;

import dao.UserDAO;
import daoInterfaces.IUserDAO;
import entityes.User;
import exceptions.DAOException;
import exceptions.FacadeException;
import facade.UpdateUserFCD;
import facadeInterfaces.IUpdateUserFCD;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UpdateUserFCDIntegration {

    /**
     * Instancia de la fachada a probar
     */
    private static IUpdateUserFCD updateUserFCD;
    private static IUserDAO userDAO;

    @BeforeAll
    public static void initialConfig() {
        // Asumimos que userDAO es una instancia real obtenida de alguna manera
        userDAO = new UserDAO();

        // Instanciamos la fachada
        updateUserFCD = new UpdateUserFCD(userDAO);
    }

    @Test
    public void testUpdateUserWithValidData() throws FacadeException, 
            DAOException {
        // Datos de prueba: Primero añadimos el usuario al sistema
        User initialUser = new User("John Doe", "john.doe@gmail.com", 
                "password123");
        userDAO.addUser(initialUser); // Añadimos el usuario inicial
        
        // Datos actualizados
        User updatedUser = new User("John Doe", "john.doe@gmail.com", 
                "newpassword456");
        
        // Actualizar el usuario
        updateUserFCD.UpdateUser(updatedUser);
        
        // Verificación
        User retrievedUser = userDAO.getByMail("john.doe@gmail.com");
        assertNotNull(retrievedUser);
        assertEquals("John Doe", retrievedUser.getNombre());
        assertEquals("john.doe@gmail.com", retrievedUser.getCorreo());
        assertEquals("newpassword456", retrievedUser.getContrasena());
    }

    @Test
    public void testUpdateUserWithEmptyName() {
        User user = new User("", "john.doe@gmail.com", "password123");
        Exception exception = assertThrows(FacadeException.class, () -> {
            updateUserFCD.UpdateUser(user);
        });
        assertEquals("El nombre no puede estar vacío", exception.getMessage());
    }

    @Test
    public void testUpdateUserWithEmptyEmail() {
        User user = new User("John Doe", "", "password123");
        Exception exception = assertThrows(FacadeException.class, () -> {
            updateUserFCD.UpdateUser(user);
        });
        assertEquals("El correo no puede estar vacío", exception.getMessage());
    }

    @Test
    public void testUpdateUserWithEmptyPassword() {
        User user = new User("John Doe", "john.doe@gmail.com", "");
        Exception exception = assertThrows(FacadeException.class, () -> {
            updateUserFCD.UpdateUser(user);
        });
        assertEquals("La contraseña no puede estar vacía", 
                exception.getMessage());
    }

    @Test
    public void testUpdateUserWithInvalidEmail() {
        User user = new User("John Doe", "john.doe@example.com", "password123");
        Exception exception = assertThrows(FacadeException.class, () -> {
            updateUserFCD.UpdateUser(user);
        });
        assertEquals("El correo debe terminar con '@gmail.com'", 
                exception.getMessage());
    }
}

