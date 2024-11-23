package dao;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import entityes.User;
import exceptions.DAOException;
import java.util.List;
import org.mockito.*;

class UserDAOTest {

    private UserDAO userDAO;

    @BeforeEach
    void setUp() {
        userDAO = new UserDAO(); // You can mock this if necessary
        

    }

    @AfterEach
    void tearDown() {
        // You could clear users if using an in-memory list
    }

    @Test
    void testAddUser() throws DAOException {
        User user = new User(1, "John Doe", "john@example.com", "password123");
        userDAO.addUser(user);

        List<User> users = userDAO.getUsers();
        assertTrue(users.contains(user), "El usuario debería haberse agregado");
    }

    @Test
    void testGetByID() throws DAOException {
        User user = new User(2, "Jane Roe", "jane@example.com", "password456");
        userDAO.addUser(user);

        User foundUser = userDAO.getByID(2);
        assertNotNull(foundUser, "El usuario debería haberse encontrado");
        assertEquals("jane@example.com", foundUser.getCorreo(), "El correo del usuario debe coincidir");
    }

    @Test
    void testGetByMail() throws DAOException {
        User user = new User(3, "Alex Smith", "alex@example.com", "password789");
        userDAO.addUser(user);

        User foundUser = userDAO.getByMail("alex@example.com");
        assertNotNull(foundUser, "El usuario debería haberse encontrado por correo");
        assertEquals("Alex Smith", foundUser.getNombre(), "El nombre del usuario debe coincidir");
    }

    @Test
    void testUpdateUser() throws DAOException {
        User user = new User(4, "Chris Green", "chris@example.com", "password321");
        userDAO.addUser(user);

        user.setNombre("Chris Blue");
        userDAO.updateUser(user);

        User updatedUser = userDAO.getByID(4);
        assertEquals("Chris Blue", updatedUser.getNombre(), "El nombre del usuario debe haberse actualizado");
    }

    @Test
    void testUpdateUserNotFound() throws DAOException {
        User user = new User(999, "Nonexistent User", "nonexistent@example.com", "password000");

        DAOException exception = assertThrows(DAOException.class, () -> userDAO.updateUser(user),
                "Debería lanzar una excepción si el usuario no se encuentra");
        assertEquals("No se encontró un usuario con el ID: 999", exception.getMessage());
    }

    @Test
    void testGetUsers() throws DAOException {
        User user1 = new User(5, "Nina Yellow", "nina@example.com", "password111");
        User user2 = new User(6, "Paul White", "paul@example.com", "password222");

        userDAO.addUser(user1);
        userDAO.addUser(user2);

        List<User> users = userDAO.getUsers();
        assertEquals(2, users.size(), "Debería haber dos usuarios en la lista");
    }

    @Test
    void testGetUsersEmpty() throws DAOException {

        assertTrue(userDAO.getUsers().isEmpty(), "La lista de usuarios debería estar vacía");
    }

    @Test
    void testGetByIDNotFound() throws DAOException {
        User foundUser = userDAO.getByID(999);
        assertNull(foundUser, "No debería encontrar un usuario con el ID inexistente");
    }

    @Test
    void testGetByMailNotFound() throws DAOException {
        User foundUser = userDAO.getByMail("nonexistent@example.com");
        assertNull(foundUser, "No debería encontrar un usuario con ese correo");
    }

    @Test
    void testAddUserWithDuplicateEmail() throws DAOException {
        User user1 = new User(7, "Carlos", "carlos@example.com", "password333");
        User user2 = new User(8, "Daniel", "carlos@example.com", "password444");

        userDAO.addUser(user1);

        DAOException exception = assertThrows(DAOException.class, () -> userDAO.addUser(user2),
                "Debería lanzar una excepción si el correo está duplicado");
        assertEquals("El correo electrónico ya está registrado", exception.getMessage());
    }

    @Test
    void testAddUserInvalidData() throws DAOException {
        User user = new User(9, "", "", "");
        DAOException exception = assertThrows(DAOException.class, () -> userDAO.addUser(user),
                "Debería lanzar una excepción si los datos son inválidos");
        assertEquals("Los datos del usuario no son válidos", exception.getMessage());
    }
}
