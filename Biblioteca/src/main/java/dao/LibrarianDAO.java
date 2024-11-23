/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entityes.Librarian;
import exceptions.DAOException;
import java.util.ArrayList;
import java.util.List;
import daoInterfaces.ILibrarianDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author skevi
 */
public class LibrarianDAO implements ILibrarianDAO {

    private static List<Librarian> bibliotecarios = new ArrayList<>();

    /**
     *
     */
    public LibrarianDAO() {
    }

    /**
     *
     * @param mail
     * @param password
     * @return
     * @throws DAOException
     */
    @Override
    public boolean loggin(String mail, String password) throws DAOException {
        if (mail == null || password == null) {
            throw new DAOException("Correo y contraseña no pueden ser nulos");
        }

        try {
            if (bibliotecarios == null) {
                throw new DAOException("La lista de bibliotecarios no está inicializada");
            }

            for (Librarian usuario : bibliotecarios) {
                // Compara el nombre de usuario y la contraseña.
                if (mail.equals(usuario.getCorreo()) && password.equals(usuario.getContrasena())) {
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
    public void addLibrarian(Librarian librarian) throws DAOException {
        if (librarian == null) {
            throw new DAOException("El bibliotecario no puede ser nulo");
        }

        try {
            bibliotecarios.add(librarian);

        } catch (UnsupportedOperationException ex) {
            throw new DAOException("La lista de bibliotecarios es inmodificable", ex);
        }
    }

    /**
     *
     * @return @throws DAOException
     */
    @Override
    public List<Librarian> getLibrarians() throws DAOException {
        if (bibliotecarios == null) {
            bibliotecarios = new ArrayList<>(); // Inicializar si es necesario
            try {
                throw new Exception("La lista de bibliotecarios no está inicializada ");
            } catch (Exception ex) {
                Logger.getLogger(LibrarianDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return new ArrayList<>(bibliotecarios);
    }

    @Override
    public Librarian findByMail(String mail) throws DAOException {
        try {
            for (Librarian bibliotecario : bibliotecarios) {
                if (bibliotecario.getCorreo().equalsIgnoreCase(mail)) {
                    return bibliotecario;
                }
            }
        } catch (Exception ex) {
            throw new DAOException("Error al buscar por email", ex);
        }
        return null;
    }

}
