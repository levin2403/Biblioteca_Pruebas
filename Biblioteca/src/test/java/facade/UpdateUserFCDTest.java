/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package facade;

import daoInterfaces.IUserDAO;
import entityes.User;
import exceptions.DAOException;
import exceptions.FacadeException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

public class UpdateUserFCDTest {

    private IUserDAO userDAOMock;
    private UpdateUserFCD updateUserFCD;

    @BeforeEach
    public void setUp() {
        // Creamos el mock del DAO
        userDAOMock = mock(IUserDAO.class);

        // Creamos la instancia de la fachada con el mock
        updateUserFCD = new UpdateUserFCD(userDAOMock);
    }

    @Test
    public void testUpdateUser_ValidUser_ShouldCallUpdateUser() 
            throws FacadeException, DAOException {
        // Creamos un objeto User válido
        User validUser = new User("Nombre", "usuario@gmail.com", "contraseña");

        // Ejecutamos el método de la fachada
        updateUserFCD.UpdateUser(validUser);

        // Verificamos que el método updateUser del DAO fue llamado una vez
        verify(userDAOMock, times(1)).updateUser(validUser);
    }

    @Test
    public void testUpdateUser_EmptyName_ShouldThrowFacadeException() {
        // Creamos un objeto User con el nombre vacío
        User invalidUser = new User("", "usuario@gmail.com", "contraseña");

        // Ejecutamos el método y verificamos que se lanza la excepción esperada
        try {
            updateUserFCD.UpdateUser(invalidUser);
            fail("Se esperaba una FacadeException");
        } catch (FacadeException e) {
            assertEquals("El nombre no puede estar vacío", e.getMessage());
        }
    }

    @Test
    public void testUpdateUser_EmptyEmail_ShouldThrowFacadeException() {
        // Creamos un objeto User con el correo vacío
        User invalidUser = new User("Nombre", "", "contraseña");

        // Ejecutamos el método y verificamos que se lanza la excepción esperada
        try {
            updateUserFCD.UpdateUser(invalidUser);
            fail("Se esperaba una FacadeException");
        } catch (FacadeException e) {
            assertEquals("El correo no puede estar vacío", e.getMessage());
        }
    }

    @Test
    public void testUpdateUser_EmptyPassword_ShouldThrowFacadeException() {
        // Creamos un objeto User con la contraseña vacía
        User invalidUser = new User("Nombre", "usuario@gmail.com", "");

        // Ejecutamos el método y verificamos que se lanza la 
        // excepción esperada
        try {
            updateUserFCD.UpdateUser(invalidUser);
            fail("Se esperaba una FacadeException");
        } catch (FacadeException e) {
            assertEquals("La contraseña no puede estar vacía", e.getMessage());
        }
    }

    @Test
    public void testUpdateUser_InvalidEmail_ShouldThrowFacadeException() {
        // Creamos un objeto User con un correo no válido
        User invalidUser = new User("Nombre", "usuario@hotmail.com", 
                "contraseña");

        // Ejecutamos el método y verificamos que se lanza la excepción 
        // esperada
        try {
            updateUserFCD.UpdateUser(invalidUser);
            fail("Se esperaba una FacadeException");
        } catch (FacadeException e) {
            assertEquals("El correo debe terminar con '@gmail.com'", 
                    e.getMessage());
        }
    }

    @Test
    public void testUpdateUser_DaoThrowsException_ShouldThrowFacadeException() 
            throws DAOException {
        // Creamos un objeto User válido
        User validUser = new User("Nombre", "usuario@gmail.com", "contraseña");

        // Simulamos que el DAO lanza una excepción
        doThrow(new DAOException("Error al actualizar el usuario")).
                when(userDAOMock).updateUser(validUser);

        // Ejecutamos el método y verificamos que se lanza la excepción esperada
        try {
            updateUserFCD.UpdateUser(validUser);
            fail("Se esperaba una FacadeException");
        } catch (FacadeException e) {
            assertEquals("Error al actualizar el usuario", 
                    "Error al actualizar el usuario");
        }
    }
}


