package dao;

import daoInterfaces.IUsuarioDAO;
import entityes.Usuario;
import exceptions.DAOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que actúa como el Data Access Object (DAO) para la entidad Usuario.
 * Esta clase proporciona métodos para gestionar usuarios, incluyendo su 
 * obtención, registro e inicio de sesión.
 * 
 * @author skevi
 */
public class UsuarioDAO implements IUsuarioDAO {
    
    /**
     * Lista que almacena los usuarios en memoria.
     * Representa la base de datos en esta implementación.
     */
    private static List<Usuario> usuarios = new ArrayList<>();
    
    /**
     * Obtiene un usuario por su ID.
     * 
     * @param id El identificador del usuario a obtener.
     * @return El usuario correspondiente al ID o null si no se encuentra.
     * @throws exceptions.DAOException
     */
    @Override
    public Usuario obten(int id) throws DAOException {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario; // Retorna el usuario si el ID coincide.
            }
        }
        return null; // Retorna null si no se encuentra el usuario.
    }  
    
    /**
     * Registra un nuevo usuario en la lista.
     * 
     * @param usuario El usuario que se desea registrar.
     * @throws exceptions.DAOException
     */
    @Override
    public void registrarUsuario(Usuario usuario) throws DAOException {
        usuarios.add(usuario); // Agrega el nuevo usuario a la lista.
    }
    
    /**
     * Actualiza la información de un usuario existente.
     * 
     * @param usuario El usuario con la información actualizada.
     * @throws exceptions.DAOException
     */
    @Override
    public void actualizarUsuario(Usuario usuario) throws DAOException {
        // Busca el usuario en la lista y actualiza su información
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == usuario.getId()) {
                usuarios.set(i, usuario); // Reemplaza el usuario antiguo por el actualizado
                return; // Salir una vez que se actualiza
            }
        }
    }
    
    /**
     * Metodo para obtener la lista de todos los usuarios registrados.
     * 
     * @return Lista con todos los usuarios registrados.
     * @throws exceptions.DAOException 
     */
    @Override
    public List<Usuario> listaUsuarios() throws DAOException {
        return UsuarioDAO.usuarios;
    }
    
}

