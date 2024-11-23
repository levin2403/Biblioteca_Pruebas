/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import entityes.Librarian;
import exceptions.DAOException;
import exceptions.FacadeException;
import utilities.Hasher;
import facadeInterfaces.ILogginFCD;
import daoInterfaces.ILibrarianDAO;

/**
 *
 * @author skevi
 */
public class LoginFCD implements ILogginFCD {

    /**
     * 
     */
    private final ILibrarianDAO librarianDAO;
    
    /**
     * 
     */
    private final Hasher hasher;

    /**
     * 
     * @param librarianDAO
     * @param hasher 
     */
    public LoginFCD(ILibrarianDAO librarianDAO, Hasher hasher) {
        this.librarianDAO = librarianDAO;
        this.hasher = hasher;
    }

    /**
     * 
     * @param mail
     * @param password
     * @return
     * @throws FacadeException 
     */
    @Override
    public boolean loggin(String mail, String password) 
            throws FacadeException {
        verifyFields(mail, password);
        Librarian librarian = VerifyMailExistence(mail);
        return verifyPassword(password, librarian.getContrasena());
    }

    /**
     * 
     * @param mail
     * @param password
     * @throws FacadeException 
     */
    private void verifyFields(String mail, String password)
            throws FacadeException {
        if (mail == null || mail.isEmpty()) {
            throw new FacadeException("El correo no puede estar vacío");
        }
        if (password == null || password.isEmpty()) {
            throw new FacadeException("La contraseña no puede estar vacía");
        }
    }

    /**
     * 
     * @param mail
     * @return
     * @throws FacadeException 
     */
    private Librarian VerifyMailExistence(String mail) throws FacadeException {
        try {
            Librarian librarian = librarianDAO.findByMail(mail);
            if (librarian == null) {
                throw new FacadeException("El correo ingresado es incorrecto");
            }
            return librarian;
        } catch (DAOException ex) {
            throw new FacadeException("Error al acceder a la base de datos: " 
                    + ex.getMessage());
        }
    }

    /**
     * 
     * @param password
     * @param storedHash
     * @return
     * @throws FacadeException 
     */
    private boolean verifyPassword(String password, String storedHash) 
            throws FacadeException {
        if (!hasher.verifyPassword(password, storedHash)) {
            throw new FacadeException("Contraseña incorrecta, "
                    + "intente de nuevo");
        }
        return true;
    }
}

