/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import facadeInterfaces.IUpdateUserFCD;
import daoInterfaces.IUserDAO;
import entityes.User;
import exceptions.DAOException;
import exceptions.FacadeException;

public class UpdateUserFCD implements IUpdateUserFCD {
    
    /**
     * 
     */
    private final IUserDAO userDAO;
    
    /**
     * 
     * @param userDAO 
     */
    public UpdateUserFCD(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }
    
    /**
     * 
     * @param user
     * @throws FacadeException 
     */
    @Override
    public void UpdateUser(User user) throws FacadeException {
        verifyFields(user);
        verifyMail(user);
        update(user);
    }
    
    /**
     * 
     * @param user
     * @throws FacadeException 
     */
    private void verifyFields(User user) throws FacadeException {
        if (user.getNombre().isEmpty()) {
            throw new FacadeException("El nombre no puede estar vacío");
        }
        else if (user.getCorreo().isEmpty()) {
            throw new FacadeException("El correo no puede estar vacío");
        }
        else if (user.getContrasena().isEmpty()) {
            throw new FacadeException("La contraseña no puede estar vacía");
        }
    }
    
    /**
     * 
     * @param user
     * @throws FacadeException 
     */
    private void update(User user) throws FacadeException {
        try {
            userDAO.updateUser(user);
        } catch (DAOException ex) {
            throw new FacadeException("Error al actualizar el usuario: " + ex.getMessage());
        }
    }
    
    /**
     * 
     * @param user
     * @throws FacadeException 
     */
    private void verifyMail(User user) throws FacadeException {
        if (!user.getCorreo().matches(".*@gmail\\.com$")) {
            throw new FacadeException("El correo debe terminar con '@gmail.com'");
        }
    }
}

