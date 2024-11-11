/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import FacadeInterfaces.IAddUserFCD;
import dao.UsuarioDAO;
import entityes.Usuario;
import exceptions.DAOException;
import exceptions.FacadeException;
import javax.swing.JOptionPane;

/**
 *
 * @author skevi
 */
public class AddUserFCD implements IAddUserFCD {
      
    /**
     * 
     */
    private UsuarioDAO userDAO;
    
    /**
     * 
     * @param user 
     */
    private Usuario user; 
    
    /**
     * Main method that adds a user in the database
     * 
     * @param user 
     */
    public void addUser(Usuario user) throws FacadeException{
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
        
    }
    
    /**
     * Couse we dont hava a database that determinates the id automaticaly 
     * we use this method to calculate what the id will be.
     */
    private void determinateId() throws FacadeException {
        
    }
    
    /**
     * Verifies that the mail is not present in any other user, this is ment 
     * to avoid a duplicity couse the mail is a unique atribute.
     */
    private void verifyMailduplicity() throws FacadeException {
        
    }
    
    /**
     * adds the user in the database and throws a message when it is 
     * done.
     * 
     */
    private void registerUser() throws FacadeException {
        try{
            userDAO.registrarUsuario(this.user);
            JOptionPane.showMessageDialog(null, "Usuario agregado con exito");
        }
        catch(DAOException de){
            throw new FacadeException("");
        }
    }
   
}
