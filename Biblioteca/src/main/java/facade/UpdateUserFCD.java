/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import facadeInterfaces.IUpdateUserFCD;
import dao.UserDAO;
import daoInterfaces.IUserDAO;
import entityes.User;
import exceptions.DAOException;
import exceptions.FacadeException;
import javax.swing.JOptionPane;

/**
 *
 * @author skevi
 */
public class UpdateUserFCD implements IUpdateUserFCD {
    
    /**
     * 
     */
    private IUserDAO userDAO;
    
    /**
     * 
     * @param user 
     */
    private User user; 
    
    /**
     * 
     * @param user 
     * @throws exceptions.FacadeException 
     */
    @Override
    public void UpdateUser(User user) throws FacadeException {
        this.userDAO = new UserDAO();
        this.user = user;
        verifyFields();
        update();
    }
    
    /**
     * 
     * @throws FacadeException 
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
     * 
     * @throws FacadeException 
     */
    private void update() throws FacadeException {
        try{
            
            int option = JOptionPane.showConfirmDialog(
                null, 
                "¿Esta seguro de querer actualizar el usuario?", 
                "Confirmación", 
                JOptionPane.YES_NO_OPTION
            );
            
            if (option == JOptionPane.YES_OPTION) {
                userDAO.updateUser(user);
                JOptionPane.showMessageDialog(null, "Exito al actualizar "
                        + "el usuario");
            }

        }
        catch(DAOException ex){
            throw new FacadeException(ex.getMessage());
        }
    }
    
}
