package entityes;

/**
 * Clase que representa un libro en un sistema de gestión de biblioteca.
 * Cada libro tiene un ISBN, un título, un autor y un estado de préstamo.
 * 
 * @author skevi
 */
public class Book {

    
    
    /**
     * Código ISBN del libro, que sirve como identificador único.
     */
    private String isbn;

    /**
     * Título del libro.
     */
    private String titulo;

    /**
     * Autor del libro.
     */
    private String autor;

    /**
     * Indica si el libro está prestado o disponible.
     */
    private boolean prestado;

    /**
     * 
     */
    private Valoration valoration;
    
    /**
     * Constructor por defecto que inicializa un nuevo objeto Libro.
     */
    public Book() {
    }

    /**
     * Constructor que inicializa un nuevo objeto Libro con los valores proporcionados.
     *
     * @param isbn   Código ISBN del libro.
     * @param titulo Título del libro.
     * @param autor  Autor del libro.
     */
    public Book(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.prestado = false; // Inicialmente, el libro no está prestado.
    }

    /**
     * 
     * @param isbn   Código ISBN del libro.
     * @param titulo Título del libro.
     * @param autor  Autor del libro.
     * @param prestado Estado de prestamo del libro.
     */
    public Book(String isbn, String titulo, String autor, boolean prestado) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.prestado = prestado;
    } 

    public Book(String isbn, String titulo, String autor, 
            Valoration valoration) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.prestado = false;
        this.valoration = valoration;
    }

    /**
     * Devuelve el código ISBN del libro.
     *
     * @return ISBN del libro.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Establece el código ISBN del libro.
     *
     * @param isbn Código ISBN del libro.
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Devuelve el título del libro.
     *
     * @return Título del libro.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título del libro.
     *
     * @param titulo Título del libro.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Devuelve el autor del libro.
     *
     * @return Autor del libro.
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Establece el autor del libro.
     *
     * @param autor Autor del libro.
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    /**
     * Establece el estado de préstamo del libro.
     *
     * @param prestado Estado de préstamo (true si está prestado, false si está disponible).
     */
    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    /**
     * Verifica si el libro está prestado.
     *
     * @return true si el libro está prestado, false si está disponible.
     */
    public boolean isPrestado() {
        return prestado;
    }

    /**
     * 
     * @return 
     */
    public Valoration getValoration() {
        return valoration;
    }

    /**
     * 
     * @param valoration 
     */
    public void setValoration(Valoration valoration) {
        this.valoration = valoration;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto Book.
     *
     * @return String que representa el libro con sus atributos.
     */
    @Override
    public String toString() {
        return "Book{" + "isbn=" + isbn + ", titulo=" + titulo + 
                ", autor=" + autor + ", prestado=" + prestado + 
                ", valoration=" + valoration + '}';
    }

}

