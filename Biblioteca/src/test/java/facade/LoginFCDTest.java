/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package facade;

import daoInterfaces.ILibrarianDAO;
import entityes.Librarian;
import exceptions.DAOException;
import exceptions.FacadeException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.Hasher;

public class LoginFCDTest {

    private ILibrarianDAO librarianDAOMock; // Mock del DAO
    private Hasher hasherMock; // Mock del Hasher
    private LoginFCD loginFCD; // Clase a probar

    @BeforeEach
    public void setUp() {
        // Crear mocks
        librarianDAOMock = mock(ILibrarianDAO.class);
        hasherMock = mock(Hasher.class);

        // Inyectar dependencias en la clase a probar
        loginFCD = new LoginFCD(librarianDAOMock, hasherMock);
    }

    @Test
    public void loggin_emptyMail_shouldThrowException() {
        // Verificar que se lanza una excepción si el correo está vacío
        assertThrows(FacadeException.class, () -> 
            loginFCD.loggin("", "password123")
        );
        
    }

    @Test
    public void loggin_emptyPassword_shouldThrowException() {
        // Verificar que se lanza una excepción si la contraseña está vacía
        assertThrows(FacadeException.class, () -> 
            loginFCD.loggin("user@gmail.com", "")
        );
    }

    @Test
    public void loggin_mailNotFound_shouldThrowException() 
            throws DAOException {
        // Simular que el correo no existe en la base de datos
        when(librarianDAOMock.findByMail("user@gmail.com")).thenReturn(null);

        // Verificar que se lanza una excepción si el correo no existe
        assertThrows(FacadeException.class, () -> 
            loginFCD.loggin("user@gmail.com", "password123")
        );
    }

    @Test
    public void loggin_invalidPassword_shouldThrowException() 
            throws DAOException {
        // Simular que el correo existe pero la contraseña no coincide
        Librarian librarian = new Librarian();
        librarian.setContrasena("hashedPassword");
        when(librarianDAOMock.findByMail("user@gmail.com")).
                thenReturn(librarian);

        // Simular que el hasher devuelve false (contraseña incorrecta)
        when(hasherMock.verifyPassword("password123", "hashedPassword")).
                thenReturn(false);

        // Verificar que se lanza una excepción si la contraseña es incorrecta
        assertThrows(FacadeException.class, () -> 
            loginFCD.loggin("user@gmail.com", "password123")
        );
    }

    @Test
    public void loggin_validCredentials_shouldReturnTrue() 
            throws DAOException, FacadeException {
        // Simular que el correo existe y la contraseña coincide
        Librarian librarian = new Librarian();
        librarian.setContrasena("hashedPassword");
        when(librarianDAOMock.findByMail("user@gmail.com")).
                thenReturn(librarian);

        // Simular que el hasher verifica correctamente la contraseña
        when(hasherMock.verifyPassword("password123", "hashedPassword")).
                thenReturn(true);

        // Verificar que el método retorna true con credenciales válidas
        assertTrue(loginFCD.loggin("user@gmail.com", "password123"));
    }

    @Test
    public void loggin_DAOException_shouldThrowFacadeException() 
            throws DAOException {
        // Simular que el DAO lanza una excepción
        when(librarianDAOMock.findByMail("user@gmail.com")).
                thenThrow(new DAOException("Error de base de datos"));

        // Verificar que se convierte en una FacadeException
        assertThrows(FacadeException.class, () -> 
            loginFCD.loggin("user@gmail.com", "password123")
        );
        
    }
    
}

