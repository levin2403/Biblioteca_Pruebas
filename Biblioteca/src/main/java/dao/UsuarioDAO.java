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
     * 
     */
    public UsuarioDAO() {
    }
    
    /**
     * Obtiene un usuario por su ID.
     * 
     * @param id El identificador del usuario a obtener.
     * @return El usuario correspondiente al ID o null si no se encuentra.
     * @throws exceptions.DAOException
     */
    @Override
    public Usuario obten(int id) throws DAOException {
        try {
            // Recorremos la lista de usuarios para buscar el 
            // usuario con el ID proporcionado.
            for (Usuario usuario : usuarios) {
                if (usuario.getId() == id) {
                    return usuario; // Retorna el usuario si el ID coincide.
                }
            }
            // Retorna null si no se encuentra el usuario con el ID 
            // proporcionado.
            return null;

        } catch (Exception ex) {
            // Lanza una DAOException con un mensaje más específico.
            throw new DAOException("Error al obtener el "
                    + "usuario con ID: " + id, ex);
        }
    } 
    
    /**
     * Registra un nuevo usuario en la lista.
     * 
     * @param usuario El usuario que se desea registrar.
     * @throws exceptions.DAOException
     */
    @Override
    public void registrarUsuario(Usuario usuario) throws DAOException {
        try{
        usuarios.add(usuario); // Agrega el nuevo usuario a la lista.
        
        }catch(Exception ex){
            throw new DAOException();
        }
    }
    
    /**
     * Actualiza la información de un usuario existente.
     * 
     * @param usuario El usuario con la información actualizada.
     * @throws exceptions.DAOException
     */
    @Override
    public void actualizarUsuario(Usuario usuario) throws DAOException {
        try{
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == usuario.getId()) {
                // Reemplaza el usuario antiguo por el actualizado
                usuarios.set(i, usuario); 
                return; // Salir una vez que se actualiza
            }
        }     
        }catch(Exception ex){
            throw new DAOException("Error al registrar el usuario: " + 
                    usuario, ex);    
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
        try {
            // Verifica si la lista de usuarios está correctamente 
            // inicializada.
            if (UsuarioDAO.usuarios == null) {
                throw new DAOException("La lista de usuarios no está "
                        + "inicializada.");
            }

            // Retorna la lista de usuarios.
            return UsuarioDAO.usuarios;

        } catch (Exception ex) {
            // Lanza una DAOException con un mensaje más específico y 
            // la causa original.
            throw new DAOException("Error al obtener la lista de "
                    + "usuarios.", ex);
        }
        
    }

    
}

