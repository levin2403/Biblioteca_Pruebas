/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package facadeInterfaces;

import entityes.User;
import exceptions.FacadeException;

/**
 *
 * @author skevi
 */
public interface IAddUserFCD {
    
    public void addUser(User user) throws FacadeException;
    
}
