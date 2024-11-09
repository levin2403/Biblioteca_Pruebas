package dominio;

/**
 * Clase que representa un libro en un sistema de gestión de biblioteca.
 * Cada libro tiene un ISBN, un título, un autor y un estado de préstamo.
 * 
 * @author skevi
 */
public class Libro {

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
     * Constructor por defecto que inicializa un nuevo objeto Libro.
     */
    public Libro() {
    }

    /**
     * Constructor que inicializa un nuevo objeto Libro con los valores proporcionados.
     *
     * @param isbn   Código ISBN del libro.
     * @param titulo Título del libro.
     * @param autor  Autor del libro.
     */
    public Libro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.prestado = false; // Inicialmente, el libro no está prestado.
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
     * Devuelve una representación en forma de cadena del objeto Libro.
     *
     * @return String que representa el libro con sus atributos.
     */
    @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn + ", titulo=" + titulo + 
                ", autor=" + autor + ", prestado=" + prestado + '}';
    }

}

