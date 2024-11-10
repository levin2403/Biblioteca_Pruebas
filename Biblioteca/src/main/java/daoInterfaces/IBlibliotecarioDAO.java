/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daoInterfaces;

import entityes.Bibliotecario;
import exceptions.DAOException;
import java.util.List;

/**
 *
 * @author skevi
 */
public interface IBlibliotecarioDAO {
    
    public void addLibrarian(Bibliotecario bibliotecario) throws DAOException;
    public boolean loggin(String correo, String contrasena) throws DAOException;
    public List<Bibliotecario> getLibrarians() throws DAOException;
    
}
