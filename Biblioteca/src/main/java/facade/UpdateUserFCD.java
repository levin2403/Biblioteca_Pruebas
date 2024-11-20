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
     */
    public UpdateUserFCD() {
        this.userDAO = new UserDAO();
    }
    
    /**
     * 
     * @param user 
     * @throws exceptions.FacadeException 
     */
    @Override
    public void UpdateUser(User user) throws FacadeException {
        verifyFields(user);
        verifyMail(user);
        update(user);
    }
    
    /**
     * 
     * @throws FacadeException 
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
     * 
     * @throws FacadeException 
     */
    private void update(User user) throws FacadeException {
        try{
            userDAO.updateUser(user);
        }
        catch(DAOException ex){
            throw new FacadeException(ex.getMessage());
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
