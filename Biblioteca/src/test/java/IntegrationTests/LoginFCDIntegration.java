/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IntegrationTests;

import dao.LibrarianDAO;
import daoInterfaces.ILibrarianDAO;
import entityes.Librarian;
import exceptions.DAOException;
import exceptions.FacadeException;
import facade.LoginFCD;
import facadeInterfaces.ILogginFCD;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import utilities.Hasher;

public class LoginFCDIntegration {

    /**
     * Instancia de la fachada a probar
     */
    private static ILogginFCD loginFCD;
    private static ILibrarianDAO librarianDAO;
    private static Hasher hasher;

    @BeforeAll
    public static void initialConfig() {
        
        librarianDAO = new LibrarianDAO();
        hasher = new Hasher();

        loginFCD = new LoginFCD(librarianDAO, hasher);
       
    }

    @Test
    public void testLoginWithValidCredentials() 
            throws FacadeException, DAOException {
        // Datos de prueba
        String mail = "john.doe@gmail.com";
        String password = "password123";
        String hashedPassword = hasher.hashPassword(password);
        Librarian librarian = new Librarian(mail, hashedPassword);
        librarianDAO.addLibrarian(librarian); // Añadimos el bibliotecario
        
        // Verificación de inicio de sesión
        assertTrue(loginFCD.loggin(mail, password));
    }

    @Test
    public void testLoginWithEmptyEmail() {
        String mail = "";
        String password = "password123";
        Exception exception = assertThrows(FacadeException.class, () -> {
            loginFCD.loggin(mail, password);
        });
        assertEquals("El correo no puede estar vacío", exception.getMessage());
    }

    @Test
    public void testLoginWithEmptyPassword() {
        String mail = "john.doe@gmail.com";
        String password = "";
        Exception exception = assertThrows(FacadeException.class, () -> {
            loginFCD.loggin(mail, password);
        });
        assertEquals("La contraseña no puede estar vacía", 
                exception.getMessage());
    }

    @Test
    public void testLoginWithNonExistentEmail() {
        String mail = "nonexistent@gmail.com";
        String password = "password123";
        Exception exception = assertThrows(FacadeException.class, () -> {
            loginFCD.loggin(mail, password);
        });
        assertEquals("El correo ingresado es incorrecto", 
                exception.getMessage());
    }

    @Test
    public void testLoginWithIncorrectPassword() throws DAOException {
        String mail = "john.doe@gmail.com";
        String correctPassword = "password123";
        String incorrectPassword = "wrongpassword";
        String hashedPassword = hasher.hashPassword(correctPassword);
        Librarian librarian = new Librarian(mail, hashedPassword);
        librarianDAO.addLibrarian(librarian); // Añadimos el bibliotecario

        Exception exception = assertThrows(FacadeException.class, () -> {
            loginFCD.loggin(mail, incorrectPassword);
        });
        assertEquals("Contraseña incorrecta, intente de nuevo", 
                exception.getMessage());
    }
}

