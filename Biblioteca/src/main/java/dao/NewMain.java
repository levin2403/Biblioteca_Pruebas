/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dao;

import daoInterfaces.IUserDAO;
import entityes.User;
import exceptions.DAOException;
import fabricas.UserFactory;
import java.util.List;

/**
 *
 * @author skevi
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DAOException {
        IUserDAO userDAO = new UserDAO();
        UserFactory factory = new UserFactory();
        factory.fabricateUsers();
        
        List<User> usuarios = userDAO.getUsers();
        
        User user = usuarios.get(0);
        
        user.setNombre("don camerino");
        
        userDAO.updateUser(user);
        
        for (User usuario : usuarios) {
            System.out.println(usuario.toString());
        }
    }
    
}
