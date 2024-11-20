/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package facade;

import daoInterfaces.IUserDAO;
import entityes.User;
import exceptions.DAOException;
import exceptions.FacadeException;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;

public class AddUserFCDTest {

    @Mock
    private IUserDAO userDAOMock;

    private AddUserFCD addUserFCD;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks
        addUserFCD = new AddUserFCD(userDAOMock); // Inyección de dependencia del mock
    }

    @Test
    public void testAddUser_validUser_shouldRegisterUser() 
            throws FacadeException, DAOException {
        // Crear un objeto User válido
        User user = new User();
        user.setNombre("John Doe");
        user.setCorreo("johndoe@gmail.com");
        user.setContrasena("password123");

        // Simular el comportamiento del mock
        // Simula que ya existe un usuario en la base de datos
        when(userDAOMock.getUsers()).thenReturn(Arrays.asList(new User())); 

        // Llamar al método addUser
        addUserFCD.addUser(user);

        // Verificar que el método addUser del DAO fue llamado
        verify(userDAOMock).addUser(user);
    }

    @Test
    public void testAddUser_duplicateEmail_shouldThrowException() 
            throws DAOException {
        // Crear un usuario con un correo duplicado
        User user = new User();
        user.setNombre("John Doe");
        user.setCorreo("johndoe@gmail.com");
        user.setContrasena("password123");

        // Crear un usuario existente con el mismo correo
        User existingUser = new User();
        existingUser.setCorreo("johndoe@gmail.com"); // Correo duplicado

        // Simular que el correo ya existe en la base de datos
        when(userDAOMock.getUsers()).thenReturn(Arrays.asList(existingUser));

        // Verificar que se lanza una excepción cuando el correo ya 
        // está registrado
        assertThrows(FacadeException.class, () -> addUserFCD.addUser(user));
    }


    @Test
    public void testAddUser_invalidEmail_shouldThrowException() {
        // Crear un usuario con un correo inválido
        User user = new User();
        user.setNombre("John Doe");
        user.setCorreo("johndoe@yahoo.com"); // Correo inválido según la regla
        user.setContrasena("password123");

        // Verificar que se lanza una excepción por el correo inválido
        assertThrows(FacadeException.class, () -> addUserFCD.addUser(user));
    }


    @Test
    public void testAddUser_emptyFields_shouldThrowException() {
        // Crear un usuario con campos vacíos
        User user = new User();
        user.setNombre(""); // Campo vacío
        user.setCorreo("johndoe@gmail.com");
        user.setContrasena("password123");

        // Verificar que se lanza una excepción cuando el nombre está vacío
        FacadeException exception = assertThrows(FacadeException.class, 
                () -> addUserFCD.addUser(user));
        assertEquals("El nombre no puede estar vacío", exception.getMessage());
    }
}


