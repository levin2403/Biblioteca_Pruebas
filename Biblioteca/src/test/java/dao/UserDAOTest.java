package dao;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import dao.UserDAO;
import entityes.User;
import exceptions.DAOException;
import java.util.List;

public class UserDAOTest {

    private UserDAO userDAO;

    @BeforeEach
    void setUp() {
        userDAO = new UserDAO();
        userDAO.remove();
    }

    @Test
    void testAddUser() throws DAOException {
        User user = new User(1, "Carlos Ramirez", "carlos@example.com", "password123");
        userDAO.addUser(user);

        User retrievedUser = userDAO.getByID(1);
        assertNotNull(retrievedUser, "El usuario no debe ser nulo");
        assertEquals("Carlos Ramirez", retrievedUser.getNombre(), "El nombre del usuario debe coincidir");
    }

    @Test
    void testGetByID_UserFound() throws DAOException {
        User user = new User(2, "Juan Perez", "juan@example.com", "password456");
        userDAO.addUser(user);

        User retrievedUser = userDAO.getByID(2);
        assertNotNull(retrievedUser, "El usuario no debe ser nulo");
        assertEquals("Juan Perez", retrievedUser.getNombre(), "El nombre del usuario debe coincidir");
    }

    @Test
    void testGetByID_UserNotFound() throws DAOException {
        User retrievedUser = userDAO.getByID(999); // ID no existe
        assertNull(retrievedUser, "El usuario debe ser nulo");
    }

    @Test
    void testGetByMail_UserFound() throws DAOException {
        User user = new User(3, "Maria Lopez", "maria@example.com", "password789");
        userDAO.addUser(user);

        User retrievedUser = userDAO.getByMail("maria@example.com");
        assertNotNull(retrievedUser, "El usuario no debe ser nulo");
        assertEquals("Maria Lopez", retrievedUser.getNombre(), "El nombre del usuario debe coincidir");
    }

    @Test
    void testGetByMail_UserNotFound() throws DAOException {
        User retrievedUser = userDAO.getByMail("nonexistent@example.com");
        assertNull(retrievedUser, "El usuario debe ser nulo");
    }

    @Test
    void testUpdateUser() throws DAOException {
        User user = new User(4, "Carlos R.", "carlosr@example.com", "password123");
        userDAO.addUser(user);

        // Actualización de datos
        User updatedUser = new User(4, "Carlos Ramirez", "carlosr@example.com", "newpassword123");
        userDAO.updateUser(updatedUser);

        User retrievedUser = userDAO.getByID(4);
        assertNotNull(retrievedUser, "El usuario no debe ser nulo");
        assertEquals("Carlos Ramirez", retrievedUser.getNombre(), "El nombre del usuario debe coincidir");
        assertEquals("newpassword123", retrievedUser.getContrasena(), "La contraseña del usuario debe ser actualizada");
    }

    @Test
    void testUpdateUser_UserNotFound() {
        User updatedUser = new User(999, "Nonexistent User", "nonexistent@example.com", "password000");
        DAOException thrown = assertThrows(DAOException.class, () -> userDAO.updateUser(updatedUser));
        assertEquals("No se encontró un usuario con el ID: 999", thrown.getMessage(), "El mensaje de error debe ser el esperado");
    }

    @Test
    void testGetUsers() throws DAOException {
        User user1 = new User(5, "Ana Gomez", "ana@example.com", "password001");
        User user2 = new User(6, "Luis Torres", "luis@example.com", "password002");
        userDAO.addUser(user1);
        userDAO.addUser(user2);

        List<User> users = userDAO.getUsers();
        assertNotNull(users, "La lista de usuarios no debe ser nula");
        assertEquals(2, users.size(), "La lista debe contener dos usuarios");
    }
}
