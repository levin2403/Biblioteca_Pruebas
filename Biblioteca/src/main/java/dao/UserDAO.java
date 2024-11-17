package dao;

import entityes.User;
import exceptions.DAOException;
import java.util.ArrayList;
import java.util.List;
import daoInterfaces.IUserDAO;

/**
 * Clase que actúa como el Data Access Object (DAO) para la entidad Usuario.
 * Esta clase proporciona métodos para gestionar usuarios, incluyendo su 
 * obtención, registro e inicio de sesión.
 * 
 * @author skevi
 */
public class UserDAO implements IUserDAO {
    
    /**
     * Lista que almacena los usuarios en memoria.
     * Representa la base de datos en esta implementación.
     */
    private static List<User> usuarios = new ArrayList<>();

    /**
     * 
     */
    public UserDAO() {
    }
    
    /**
     * Obtiene un usuario por su ID.
     * 
     * @param id El identificador del usuario a obtener.
     * @return El usuario correspondiente al ID o null si no se encuentra.
     * @throws exceptions.DAOException
     */
    @Override
    public User getByID(int id) throws DAOException {
        try {
            // Recorremos la lista de usuarios para buscar el 
            // usuario con el ID proporcionado.
            for (User user : usuarios) {
                if (user.getId() == id) {
                    return user; // Retorna el usuario si el ID coincide.
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
     * 
     * @param mail
     * @return
     * @throws DAOException 
     */
    @Override
    public User getByMail(String mail) throws DAOException {
        for (User user : usuarios) {
            if (user.getCorreo().equalsIgnoreCase(mail)) {
                return user;
            }
        }
        return null;
    }
    
    /**
     * Registra un nuevo usuario en la lista.
     * 
     * @param user
     * @throws exceptions.DAOException
     */
    @Override
    public void addUser(User user) throws DAOException {
        try{
        usuarios.add(user); // Agrega el nuevo usuario a la lista.
        
        }catch(Exception ex){
            throw new DAOException();
        }
    }
    
    /**
     * Actualiza la información de un usuario existente.
     * 
     * @param user El usuario con la información actualizada.
     * @throws exceptions.DAOException
     */
    @Override
    public void updateUser(User user) throws DAOException {
        boolean userFound = false;
        for (User usuario : usuarios) {
            if (usuario.getId() == user.getId()) {
                usuario.setNombre(user.getNombre());
                usuario.setCorreo(user.getCorreo());
                usuario.setContrasena(user.getContrasena());
                userFound = true;
                break;
            }
        }
        if (!userFound) {
            throw new DAOException("No se encontró un usuario con el ID: " 
                    + user.getId());
        }
    }
    
    /**
     * Metodo para obtener la lista de todos los usuarios registrados.
     * 
     * @return Lista con todos los usuarios registrados.
     * @throws exceptions.DAOException 
     */
    @Override
    public List<User> getUsers() throws DAOException {
        try {
            // Verifica si la lista de usuarios está correctamente 
            // inicializada.
            if (UserDAO.usuarios == null) {
                throw new DAOException("La lista de usuarios no está "
                        + "inicializada.");
            }

            // Retorna la lista de usuarios.
            return UserDAO.usuarios;

        } catch (Exception ex) {
            // Lanza una DAOException con un mensaje más específico y 
            // la causa original.
            throw new DAOException("Error al obtener la lista de "
                    + "usuarios.", ex);
        }
        
    }
    
}

