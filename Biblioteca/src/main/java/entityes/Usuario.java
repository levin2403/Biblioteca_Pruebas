package entityes;

/**
 * Clase que representa un usuario en el sistema.
 * Cada usuario tiene un identificador único, un nombre y una contraseña.
 * 
 * @author skevi
 */
public class Usuario {
    
    /**
     * El identificador único del usuario.
     */
    private int id;
    
    /**
     * El nombre del usuario.
     */
    private String nombre;
    
    /**
     * La contraseña del usuario.
     */
    private String contraseña;

    /**
     * Constructor que inicializa un usuario con un ID, nombre y contraseña.
     * 
     * @param id El identificador único del usuario.
     * @param nombre El nombre del usuario.
     * @param contraseña La contraseña del usuario.
     */
    public Usuario(int id, String nombre, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    /**
     * Obtiene el ID del usuario.
     * 
     * @return El ID del usuario.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del usuario.
     * 
     * @param id El nuevo ID del usuario.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del usuario.
     * 
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     * 
     * @param nombre El nuevo nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la contraseña del usuario.
     * 
     * @return La contraseña del usuario.
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Establece la contraseña del usuario.
     * 
     * @param contraseña La nueva contraseña del usuario.
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Retorna una representación en forma de cadena del objeto Usuario.
     * Incluye el ID, nombre y contraseña del usuario.
     * 
     * @return Una cadena que representa al usuario.
     */
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + 
                ", contrase\u00f1a=" + contraseña + '}';
    }
}

