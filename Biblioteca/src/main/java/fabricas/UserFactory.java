/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabricas;

import dao.UserDAO;
import entityes.User;
import exceptions.DAOException;
import daoInterfaces.IUserDAO;

/**
 *
 * @author skevi
 */
public class UserFactory {

    /**
     * DAO para gestionar los usuarios.
     */
    private IUserDAO usuarioDAO;

    /**
     * Constructor que inicializa la instancia de UserDAO.
     */
    public UserFactory() {
        this.usuarioDAO = new UserDAO();
    }

    /**
     * Fabrica 5 distintos usuarios y los agrega a la lista de usuarios 
 de UserDAO.
     */
    public void fabricateUsers() {
        try {
            // Crear instancias de User con información única
            usuarioDAO.addUser(new User(1, "Carlos Gómez", "carlos.gomez@example.com", "password123"));
            usuarioDAO.addUser(new User(2, "Ana Martínez", "ana.martinez@example.com", "securepass456"));
            usuarioDAO.addUser(new User(3, "Luis Ramírez", "luis.ramirez@example.com", "mypassword789"));
            usuarioDAO.addUser(new User(4, "María Fernández", "maria.fernandez@example.com", "pass1234"));
            usuarioDAO.addUser(new User(5, "Jorge López", "jorge.lopez@example.com", "password5678"));
            
            for (User usuario : usuarioDAO.getUsers()) {
                System.out.println(usuario.toString());
            }
            
        } catch (DAOException e) {
            System.out.println("Error al fabricar los usuarios");        
        }
    }
}

