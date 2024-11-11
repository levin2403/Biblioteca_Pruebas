/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daoInterfaces;

import entityes.Librarian;
import exceptions.DAOException;
import java.util.List;

/**
 *
 * @author skevi
 */
public interface ILibrarianDAO {
    
    public void addLibrarian(Librarian librarian) throws DAOException;
    public boolean loggin(String mail, String password) throws DAOException;
    public List<Librarian> getLibrarians() throws DAOException;
    public Librarian findByMail(String mail) throws DAOException;
    
}
