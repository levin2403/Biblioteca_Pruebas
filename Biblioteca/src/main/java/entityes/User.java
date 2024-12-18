package entityes;

/**
 * Clase que representa un usuario en el sistema.
 * Cada usuario tiene un identificador único, un nombre y una contraseña.
 * 
 * @author skevi
 */
public class User {
    
    /**
     * El identificador único del usuario.
     */
    private int id;
    
    /**
     * El nombre del usuario.
     */
    private String nombre;
    
    /**
     * 
     */
    private String correo;
    
    /**
     * La contraseña del usuario.
     */
    private String contrasena;

    /**
     * 
     */
    public User() {
    }

    /**
     * 
     * @param nombre
     * @param correo
     * @param contrasena 
     */
    public User(String nombre, String correo, String contrasena) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    /**
     * Constructor que inicializa un usuario con un ID, nombre y contraseña.
     * 
     * @param id El identificador único del usuario.
     * @param nombre El nombre del usuario.
     * @param contrasena La contraseña del usuario.
     */
    public User(int id, String nombre, String correo, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
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
     * Metodo para obtener el correo del usuario;
     * 
     * @return Cadena con el correo del usuario;
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Metodo para establecer el correo del usuario;
     * 
     * @param correo Correo a establecer.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene la contraseña del usuario.
     * 
     * @return La contraseña del usuario.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del usuario.
     * 
     * @param contrasena La nueva contraseña del usuario.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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
                ", contrase\u00f1a=" + contrasena + '}';
    }
}

