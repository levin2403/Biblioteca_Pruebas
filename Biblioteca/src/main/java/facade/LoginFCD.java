/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import dao.BibliotecarioDAO;
import daoInterfaces.IBibliotecarioDAO;
import entityes.Bibliotecario;
import exceptions.DAOException;
import exceptions.FacadeException;
import utilities.Hasher;
import FacadeInterfaces.ILogginFCD;

/**
 *
 * @author skevi
 */
public class LoginFCD implements ILogginFCD{

    /**
     * 
     */
    IBibliotecarioDAO bibliotecarioDAO;
    
    /**
     * 
     */
    private Bibliotecario bibliotecario;
    
    /**
     * 
     */
    private Hasher hasher;

    /**
     * 
     */
    public LoginFCD() {
        this.bibliotecarioDAO = new BibliotecarioDAO();
        this.hasher = new Hasher();
    }
    
    @Override
    public boolean loggin(String mail, String password)  
            throws FacadeException {
        
        verifyFields(mail, password);
        VerifyMailExistence(mail);
        
        return verifyPassword(password);
    }
    
    /**
     * Verifies that the mail and password field are not empty 
     */
    private void verifyFields(String mail, String password) throws FacadeException{
        if (mail.isEmpty()) {
            throw new FacadeException("El correo no puede estar vacio");
        }
        else if(password.isEmpty()){
            throw new FacadeException("la contrseña no puede estar vacia");
        }
    }
    
    /**
     * 
     * @param mail
     * @throws FacadeException 
     */
    private void VerifyMailExistence(String mail) throws FacadeException {
       try{
        Bibliotecario bibliotecario = bibliotecarioDAO.findByMail(mail);
        
           if (bibliotecario == null) {
               throw new FacadeException("El correo ingresado es incorrecto");
           }
           else{
               this.bibliotecario = bibliotecario;
           }
       }
       catch(DAOException ex){
           throw new FacadeException(ex.getMessage());
       }
    }
    
    /**
     * 
     * @param password
     * @return 
     */
    private boolean verifyPassword(String password) throws FacadeException{
        
        String storedHash = bibliotecario.getContrasena();
        
        if (hasher.verificarContrasena(password, storedHash)) {
            return true;
        }
        else{
            throw new FacadeException("Contraseña incorrecte intente de nuevo");
        }
    }
    
}
