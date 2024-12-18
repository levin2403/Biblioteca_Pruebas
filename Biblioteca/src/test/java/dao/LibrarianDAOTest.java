package dao;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import entityes.Librarian;
import exceptions.DAOException;
import java.util.List;

class LibrarianDAOTest {

    private LibrarianDAO librarianDAO;

    @BeforeEach
    void setUp() {
        librarianDAO = new LibrarianDAO();

    }

    @AfterEach
    void tearDown() {
        librarianDAO = new LibrarianDAO();
    }

    @Test
    void testAddLibrarian() throws DAOException {
        Librarian librarian = new Librarian("john.doe@mail.com", "password123");
        librarianDAO.addLibrarian(librarian);
        List<Librarian> librarians = librarianDAO.getLibrarians();
        assertTrue(librarians.contains(librarian), "El bibliotecario debería haberse agregado");
    }

    @Test
    void testLogginSuccessful() throws DAOException {
        Librarian librarian = new Librarian("admin@mail.com", "securepass");
        librarianDAO.addLibrarian(librarian);

        boolean loginResult = librarianDAO.loggin("admin@mail.com", "securepass");
        assertTrue(loginResult, "El inicio de sesión debería ser exitoso con credenciales válidas");
    }

    @Test
    void testLogginFailed() throws DAOException {
        Librarian librarian = new Librarian("user@mail.com", "mypassword");
        librarianDAO.addLibrarian(librarian);

        boolean loginResult = librarianDAO.loggin("user@mail.com", "wrongpassword");
        assertFalse(loginResult, "El inicio de sesión debería fallar con una contraseña incorrecta");
    }

    @Test
    void testLogginWithNullFieldsThrowsException() {
        assertThrows(DAOException.class, () -> librarianDAO.loggin(null, null),
                "Debería lanzar una excepción si los campos son nulos");
    }

    @Test
    void testFindByMailSuccessful() throws DAOException {
        Librarian librarian = new Librarian("example@mail.com", "pass123");
        librarianDAO.addLibrarian(librarian);

        Librarian foundLibrarian = librarianDAO.findByMail("example@mail.com");
        assertNotNull(foundLibrarian, "El bibliotecario debería encontrarse");
        assertEquals(librarian, foundLibrarian, "El bibliotecario encontrado no coincide");
    }

    @Test
    void testFindByMailNotFound() throws DAOException {
        Librarian foundLibrarian = librarianDAO.findByMail("nonexistent@mail.com");
        assertNull(foundLibrarian, "No debería encontrar un bibliotecario con un correo inexistente");
    }

//    @Test
//    void testGetLibrarians() throws DAOException {
//        librarianDAO = new LibrarianDAO();
//        Librarian librarian1 = new Librarian("librarian1@mail.com", "password1");
//        Librarian librarian2 = new Librarian("librarian2@mail.com", "password2");
//        librarianDAO.addLibrarian(librarian1);
//        librarianDAO.addLibrarian(librarian2);
//
//        assertEquals(2, librarianDAO.getLibrarians().size(), "Debería haber dos bibliotecarios en la lista");
//    }
}
