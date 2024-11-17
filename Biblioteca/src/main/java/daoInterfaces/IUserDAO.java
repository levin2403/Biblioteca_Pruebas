/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daoInterfaces;

import entityes.User;
import exceptions.DAOException;
import java.util.List;

/**
 *
 * @author skevi
 */
public interface IUserDAO {
    
    public User getByID(int id) throws DAOException;
    public User getByMail(String mail) throws DAOException;
    public void addUser(User user) throws DAOException;
    public void updateUser(User user) throws DAOException;
    public List<User> getUsers() throws DAOException;
    
}
