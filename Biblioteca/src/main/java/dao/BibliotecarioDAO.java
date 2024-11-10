/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import daoInterfaces.IBlibliotecarioDAO;
import entityes.Bibliotecario;
import exceptions.DAOException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author skevi
 */
public class BibliotecarioDAO implements IBlibliotecarioDAO {

    private static List<Bibliotecario> bibliotecarios;
    
    /**
     * 
     * @param correo
     * @param contrasena
     * @return
     * @throws DAOException 
     */
    @Override
    public boolean loggin(String correo, String contrasena) throws DAOException {
        if (correo == null || contrasena == null) {
            throw new DAOException("Correo y contraseña no pueden ser nulos");
        }

        try {
            if (bibliotecarios == null) {
                throw new DAOException("La lista de bibliotecarios no está inicializada");
            }

            for (Bibliotecario usuario : bibliotecarios) {
                // Compara el nombre de usuario y la contraseña.
                if (correo.equals(usuario.getCorreo()) && contrasena.equals(usuario.getContrasena())) {
                    return true; // Inicio de sesión exitoso.
                }
            }
            return false; // Inicio de sesión fallido.

        } catch (NullPointerException ex) {
            throw new DAOException("Error de acceso a datos: algún campo es nulo", ex);
        } 
    }

    /**
     * 
     * @param bibliotecario
     * @throws DAOException 
     */
    @Override
    public void addLibrarian(Bibliotecario bibliotecario) throws DAOException {
        if (bibliotecario == null) {
            throw new DAOException("El bibliotecario no puede ser nulo");
        }

        try {
            BibliotecarioDAO.bibliotecarios.add(bibliotecario);

        } catch (UnsupportedOperationException ex) {
            throw new DAOException("La lista de bibliotecarios es inmodificable", ex);
        } 
    }
    /**
     * 
     * @return
     * @throws DAOException 
     */
    @Override
    public List<Bibliotecario> getLibrarians() throws DAOException {
        if (BibliotecarioDAO.bibliotecarios == null) {
            throw new DAOException("La lista de bibliotecarios no "
                    + "está inicializada");
        }
        return new ArrayList<>(BibliotecarioDAO.bibliotecarios); 
    }

    
}
