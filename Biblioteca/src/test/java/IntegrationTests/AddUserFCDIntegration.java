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
import facade.AddUserFCD;
import facadeInterfaces.IAddUserFCD;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddUserFCDIntegration {

    /**
     * Instancia de la fachada a probar
     */
    private static IAddUserFCD addUserFCD;
    private static IUserDAO userDAO;

    @BeforeAll
    public static void initialConfig() {
        
        userDAO = new UserDAO();

        
        addUserFCD = new AddUserFCD(userDAO);
    }

    @Test
    public void testAddUserWithValidData() throws FacadeException, 
            DAOException {
        // Datos de prueba
        User user = new User("John Doe", "john.doe@gmail.com", "password123");
        
        // Añadir el usuario
        addUserFCD.addUser(user);
        
        // Verificación
        User retrievedUser = userDAO.getByMail("john.doe@gmail.com");
        assertNotNull(retrievedUser);
        assertEquals("John Doe", retrievedUser.getNombre());
        assertEquals("john.doe@gmail.com", retrievedUser.getCorreo());
        assertEquals("password123", retrievedUser.getContrasena());
    }

    @Test
    public void testAddUserWithEmptyName() {
        User user = new User("", "john.doe@gmail.com", "password123");
        Exception exception = assertThrows(FacadeException.class, () -> {
            addUserFCD.addUser(user);
        });
        assertEquals("El nombre no puede estar vacío", exception.getMessage());
    }

    @Test
    public void testAddUserWithEmptyEmail() {
        User user = new User("John Doe", "", "password123");
        Exception exception = assertThrows(FacadeException.class, () -> {
            addUserFCD.addUser(user);
        });
        assertEquals("El correo no puede estar vacío", exception.getMessage());
    }

    @Test
    public void testAddUserWithEmptyPassword() {
        User user = new User("John Doe", "john.doe@gmail.com", "");
        Exception exception = assertThrows(FacadeException.class, () -> {
            addUserFCD.addUser(user);
        });
        assertEquals("La contraseña no puede estar vacía", 
                exception.getMessage());
    }

    @Test
    public void testAddUserWithInvalidEmail() {
        User user = new User("John Doe", "john.doe@example.com", "password123");
        Exception exception = assertThrows(FacadeException.class, () -> {
            addUserFCD.addUser(user);
        });
        assertEquals("Se debe de incluir @gmail al final del correo", 
                exception.getMessage());
    }

    @Test
    public void testAddUserWithDuplicateEmail() throws FacadeException {
        User user1 = new User("John Doe", "john.doe@gmail.com", "password123");
        
        
        assertThrows(FacadeException.class, () -> {
            addUserFCD.addUser(user1);
        });
    }
}

