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
public class UserDAOTest implements IUserDAO {
    
    /**
     * Lista que almacena los usuarios en memoria.
     * Representa la base de datos en esta implementación.
     */
    private static List<User> usuarios = new ArrayList<>();

    /**
     * Constructor de la clase.
     */
    public UserDAOTest() {
    }
    
    /**
     * Obtiene un usuario por su ID.
     * 
     * @param id El identificador del usuario a obtener.
     * @return El usuario correspondiente al ID o null si no se encuentra.
     * @throws DAOException si ocurre un error al acceder a los datos.
     */
    @Override
    public User getByID(int id) throws DAOException {
        try {
            // Recorremos la lista de usuarios para buscar el usuario con el ID proporcionado.
            for (User user : usuarios) {
                if (user.getId() == id) {
                    return user; // Retorna el usuario si el ID coincide.
                }
            }
            // Retorna null si no se encuentra el usuario con el ID proporcionado.
            return null;
        } catch (Exception ex) {
            // Lanza una DAOException con un mensaje específico.
            throw new DAOException("Error al obtener el usuario con ID: " + id, ex);
        }
    } 
    
    /**
     * Obtiene un usuario por su correo.
     * 
     * @param mail El correo del usuario a obtener.
     * @return El usuario correspondiente al correo o null si no se encuentra.
     * @throws DAOException si ocurre un error al acceder a los datos.
     */
    @Override
    public User getByMail(String mail) throws DAOException {
        try {
            for (User user : usuarios) {
                if (user.getCorreo().equalsIgnoreCase(mail)) {
                    return user;
                }
            }
            return null;
        } catch (Exception ex) {
            throw new DAOException("Error al obtener el usuario con correo: " + mail, ex);
        }
    }
    
    /**
     * Registra un nuevo usuario en la lista.
     * 
     * @param user El usuario a registrar.
     * @throws DAOException si ocurre un error al agregar el usuario.
     */
    @Override
    public void addUser(User user) throws DAOException {
        try {
            usuarios.add(user); // Agrega el nuevo usuario a la lista.
        } catch (Exception ex) {
            // Lanza una DAOException con un mensaje más detallado.
            throw new DAOException("Error al agregar el usuario: " + user.getNombre(), ex);
        }
    }
    
    /**
     * Actualiza la información de un usuario existente.
     * 
     * @param user El usuario con la información actualizada.
     * @throws DAOException si ocurre un error al actualizar el usuario.
     */
    @Override
    public void updateUser(User user) throws DAOException {
        boolean userFound = false;
        try {
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
                throw new DAOException("No se encontró un usuario con el ID: " + user.getId());
            }
        } catch (Exception ex) {
            throw new DAOException("Error al actualizar el usuario con ID: " + user.getId(), ex);
        }
    }
    
    /**
     * Obtiene la lista de todos los usuarios registrados.
     * 
     * @return Lista con todos los usuarios registrados.
     * @throws DAOException si ocurre un error al obtener la lista de usuarios.
     */
    @Override
    public List<User> getUsers() throws DAOException {
        try {
            // Verifica si la lista de usuarios está correctamente inicializada.
            if (usuarios == null) {
                throw new DAOException("La lista de usuarios no está inicializada.");
            }

            // Retorna la lista de usuarios.
            return usuarios;
        } catch (Exception ex) {
            // Lanza una DAOException con un mensaje más específico y la causa original.
            throw new DAOException("Error al obtener la lista de usuarios.", ex);
        }
    }
}
