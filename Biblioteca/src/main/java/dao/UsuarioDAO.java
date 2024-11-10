package dao;

import entityes.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que actúa como el Data Access Object (DAO) para la entidad Usuario.
 * Esta clase proporciona métodos para gestionar usuarios, incluyendo su 
 * obtención, registro e inicio de sesión.
 * 
 * @author skevi
 */
public class UsuarioDAO {
    
    /**
     * Lista que almacena los usuarios en memoria.
     * Representa la base de datos en esta implementación.
     */
    private List<Usuario> usuarios = new ArrayList<>();
    
    /**
     * Obtiene un usuario por su ID.
     * 
     * @param id El identificador del usuario a obtener.
     * @return El usuario correspondiente al ID o null si no se encuentra.
     */
    public Usuario obten(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario; // Retorna el usuario si el ID coincide.
            }
        }
        return null; // Retorna null si no se encuentra el usuario.
    }
    
    /**
     * Intenta iniciar sesión para un usuario dado.
     * 
     * @param nombreUsuario El nombre del usuario que intenta iniciar sesión.
     * @param contraseña La contraseña del usuario.
     * @return true si el inicio de sesión es exitoso, false en caso contrario.
     */
    public boolean iniciarSesion(String nombreUsuario, String contraseña) {
        for (Usuario usuario : usuarios) {
            // Compara el nombre de usuario y la contraseña.
            if (usuario.getNombre().equals(nombreUsuario) && usuario.getContraseña().equals(contraseña)) {
                return true; // Inicio de sesión exitoso.
            }
        }
        return false; // Inicio de sesión fallido.
    }
    
    /**
     * Registra un nuevo usuario en la lista.
     * 
     * @param usuario El usuario que se desea registrar.
     */
    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario); // Agrega el nuevo usuario a la lista.
    }
    
    /**
     * Actualiza la información de un usuario existente.
     * 
     * @param usuario El usuario con la información actualizada.
     */
    public void actualizarUsuario(Usuario usuario) {
        // Busca el usuario en la lista y actualiza su información
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == usuario.getId()) {
                usuarios.set(i, usuario); // Reemplaza el usuario antiguo por el actualizado
                return; // Salir una vez que se actualiza
            }
        }
    }
    
    
}

