package dao;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import entityes.Book;
import exceptions.DAOException;
import java.util.List;

/**
 * Pruebas unitarias para la clase BookDAO.
 */
class BookDAOTest {
    private BookDAO bookDAO;

    @BeforeEach
    void setUp() {
        bookDAO = new BookDAO();
    }

    @AfterEach
    void tearDown() {
//        try {
//            // Limpiar libros después de cada prueba
//            for (Book book : bookDAO.getBooks()) {
//                bookDAO.removeBook(book);
//            }
//        } catch (DAOException e) {
//            System.err.println("Error al limpiar los libros: " + e.getMessage());
//        }
    }

    @Test
    void testAddBook() throws DAOException {
        Book book = new Book("123", "Java Basics", "John Doe", false);
        bookDAO.addBook(book);
        List<Book> books = bookDAO.getBooks();
        assertTrue(books.contains(book), "El libro debería haberse agregado");
    }

    @Test
    void testAddDuplicateBook() throws DAOException {
        Book book = new Book("123", "Java Basics", "John Doe", false);
        bookDAO.addBook(book);
        assertThrows(DAOException.class, () -> bookDAO.addBook(book),
                "Debería lanzar una excepción al intentar agregar un libro duplicado");
    }

    @Test
    void testSearchByTitle() throws DAOException {
        Book book = new Book("456", "Advanced Java", "Jane Roe", false);
        bookDAO.addBook(book);
        List<Book> foundBooks = bookDAO.searchByTitle("Advanced");
        assertEquals(1, foundBooks.size(), "Debería encontrar un libro");
        assertEquals(book, foundBooks.get(0), "El libro encontrado no coincide");
    }

    @Test
    void testSearchByAuthor() throws DAOException {
        Book book = new Book("789", "Java Patterns", "James Smith", false);
        bookDAO.addBook(book);
        List<Book> foundBooks = bookDAO.searchByAuthor("James");
        assertEquals(1, foundBooks.size(), "Debería encontrar un libro");
        assertEquals(book, foundBooks.get(0), "El libro encontrado no coincide");
    }

    @Test
    void testSearchByISBN() throws DAOException {
        Book book = new Book("101", "Spring Framework", "Alex Green", false);
        bookDAO.addBook(book);
        Book foundBook = bookDAO.searchByISBN("101");
        assertNotNull(foundBook, "El libro debería encontrarse");
        assertEquals(book, foundBook, "El libro encontrado no coincide");
    }

    @Test
    void testUpdateBook() throws DAOException {
        Book book = new Book("202", "Hibernate Basics", "Sara Blue", false);
        bookDAO.addBook(book);

        book.setTitulo("Updated Hibernate Basics");
        bookDAO.updateBook(book);

        Book updatedBook = bookDAO.searchByISBN("202");
        assertEquals("Updated Hibernate Basics", updatedBook.getTitulo(),
                "El título del libro debería haberse actualizado");
    }

    @Test
    void testRemoveBook() throws DAOException {
        Book book = new Book("303", "JUnit Testing", "Mark Red", false);
        bookDAO.addBook(book);
        bookDAO.removeBook(book);
        List<Book> books = bookDAO.getBooks();
        assertFalse(books.contains(book), "El libro debería haberse eliminado");
    }

    @Test
    void testGetBooks() throws DAOException {
        Book book1 = new Book("404", "Algorithms", "Nina Yellow", false);
        Book book2 = new Book("505", "Data Structures", "Paul White", false);
        bookDAO.addBook(book1);
        bookDAO.addBook(book2);
        List<Book> books = bookDAO.getBooks();
        assertEquals(2, books.size(), "Debería haber dos libros en la lista");
    }

    @Test
    void testSearchByTitleEmptyThrowsException() {
        assertThrows(DAOException.class, () -> bookDAO.searchByTitle(""),
                "Debería lanzar una excepción si el título está vacío");
    }

    @Test
    void testSearchByISBNNotFound() throws DAOException {
        Book foundBook = bookDAO.searchByISBN("999");
        assertNull(foundBook, "No debería encontrar un libro con ISBN inexistente");
    }

    @Test
    void testSearchByNullTitleThrowsException() {
        assertThrows(DAOException.class, () -> bookDAO.searchByTitle(null),
                "Debería lanzar una excepción si el título es nulo");
    }
}
