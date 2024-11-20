/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import facadeInterfaces.IAddUserFCD;
import dao.UserDAO;
import daoInterfaces.IUserDAO;
import entityes.User;
import exceptions.DAOException;
import exceptions.FacadeException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author skevi
 */
public class AddUserFCD implements IAddUserFCD {
      
    /**
     * 
     */
    private IUserDAO userDAO;

    /**
     * 
     */
    public AddUserFCD() {
        this.userDAO = new UserDAO();
    }
    
    
    /**
     * Main method that adds a user in the database
     * 
     * @param user 
     * @throws exceptions.FacadeException 
     */
    @Override
    public void addUser(User user) throws FacadeException {
        verifyFields(user);
        verifyMail(user);
        determinateId(user);
        verifyMailduplicity(user);
        registerUser(user);
    }
    
    /**
     * Verifies that no field in the object is null or empty.
     */
    private void verifyFields(User user) throws FacadeException {
        if (user.getNombre().isEmpty()) {
            throw new FacadeException("El nombre no puede estar vacio");
        }
        else if(user.getCorreo().isEmpty()){
            throw new FacadeException("El nombre no puede estar vacio");
        }
        else if(user.getContrasena().isEmpty()){
            throw new FacadeException("El nombre no puede estar vacio");
        }
    }
    
    /**
     * Couse we dont hava a database that determinates the id automaticaly 
     * we use this method to calculate what the id will be.
     */
    private void determinateId(User user) throws FacadeException {
        try{
        int users = userDAO.getUsers().size();
        
        user.setId(users + 1);
        
        }catch(DAOException de){
            throw new FacadeException(de.getMessage());   
        }
    }
    
    /**
     * Verifies that the mail is not present in any other user, this is ment 
     * to avoid a duplicity couse the mail is a unique atribute.
     */
    private void verifyMailduplicity(User user) throws FacadeException {
        try{
        List<User> users = userDAO.getUsers();
        
            for (User user1 : users) {
                if (user.getCorreo().equalsIgnoreCase(user1.getCorreo())) {
                    throw new FacadeException("El mail proporcionado ya "
                            + "existe");
                }
            }
        
        }catch(DAOException de){
            throw new FacadeException(de.getMessage());   
        }
    }
    
    /**
     * adds the user in the database and throws a message when it is 
     * done.
     * 
     */
    private void registerUser(User user) throws FacadeException {
        try{
            userDAO.addUser(user);
        }
        catch(DAOException de){
            throw new FacadeException(de.getMessage());
        }
    }
    
    /**
     * 
     * @throws FacadeException 
     */
    private void verifyMail(User user) throws FacadeException {
        if (!user.getCorreo().matches("@gmail\\.com$")) {
            throw new FacadeException("Se debe de incluir @gmail al final "
                    + "del correo");
        }
    }
   
}
