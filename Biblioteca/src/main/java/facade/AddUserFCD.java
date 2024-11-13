/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import FacadeInterfaces.IAddUserFCD;
import dao.UserDAO;
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
    private UserDAO userDAO;
    
    /**
     * 
     * @param user 
     */
    private User user; 
    
    /**
     * Main method that adds a user in the database
     * 
     * @param user 
     * @throws exceptions.FacadeException 
     */
    @Override
    public void addUser(User user) throws FacadeException{
        this.user = user;
        verifyFields();
        determinateId();
        verifyMailduplicity();
        registerUser();
    }
    
    /**
     * Verifies that no field in the object is null or empty.
     */
    private void verifyFields() throws FacadeException {
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
    private void determinateId() throws FacadeException {
        try{
        int users = userDAO.getUsers().size();
        
        this.user.setId(users + 1);
        
        }catch(DAOException de){
            throw new FacadeException(de.getMessage());   
        }
    }
    
    /**
     * Verifies that the mail is not present in any other user, this is ment 
     * to avoid a duplicity couse the mail is a unique atribute.
     */
    private void verifyMailduplicity() throws FacadeException {
        try{
        List<User> users = userDAO.getUsers();
        
            for (User user : users) {
                if (this.user.getCorreo().equalsIgnoreCase(user.getCorreo())) {
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
    private void registerUser() throws FacadeException {
        try{
            
            int option = JOptionPane.showConfirmDialog(
                null, 
                "¿Esta seguro de querer registrar al usuario?", 
                "Confirmación", 
                JOptionPane.YES_NO_OPTION
            );
            
            if (option == JOptionPane.YES_OPTION) {
                userDAO.addUser(this.user);
                JOptionPane.showMessageDialog(null, "Usuario agregado con "
                        + "exito");
            }

        }
        catch(DAOException de){
            throw new FacadeException("");
        }
    }
   
}
