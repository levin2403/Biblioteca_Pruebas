/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import FacadeInterfaces.IUpdateUserFCD;
import dao.UsuarioDAO;
import entityes.Usuario;
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
    private UsuarioDAO userDAO;
    
    /**
     * 
     * @param user 
     */
    private Usuario user; 
    
    /**
     * 
     * @param user 
     */
    public void UpdateUser(Usuario user) throws FacadeException {
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
            userDAO.actualizarUsuario(user);
            JOptionPane.showMessageDialog(null, "Exito al actualizar el "
                    + "usuario");
        }
        catch(DAOException ex){
            throw new FacadeException(ex.getMessage());
        }
    }
    
}
