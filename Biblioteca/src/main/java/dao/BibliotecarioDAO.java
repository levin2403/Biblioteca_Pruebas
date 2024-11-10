/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import daoInterfaces.IBlibliotecarioDAO;
import entityes.Bibliotecario;
import exceptions.DAOException;
import java.util.List;


/**
 *
 * @author skevi
 */
public class BibliotecarioDAO implements IBlibliotecarioDAO {

    private static List<Bibliotecario> bibliotecarios;
    
    @Override
    public boolean loggin(String correo, String contrasena) 
            throws DAOException {
        for (Bibliotecario usuario : bibliotecarios) {
            // Compara el nombre de usuario y la contraseña.
            if (usuario.getCorreo().equals(correo) && 
                    usuario.getContrasena().equals(contrasena)) {
                return true; // Inicio de sesión exitoso.
            }
        }
        return false; // Inicio de sesión fallido.
    }

    /**
     * 
     * @param bibliotecario
     * @throws DAOException 
     */
    @Override
    public void addLibrarian(Bibliotecario bibliotecario) throws DAOException {
        BibliotecarioDAO.bibliotecarios.add(bibliotecario);
    }

    /**
     * 
     * @return
     * @throws DAOException 
     */
    @Override
    public List<Bibliotecario> getLibrarians() throws DAOException {
        return BibliotecarioDAO.bibliotecarios;
    }
    
}
