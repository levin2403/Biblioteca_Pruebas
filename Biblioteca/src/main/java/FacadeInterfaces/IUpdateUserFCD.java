/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package FacadeInterfaces;

import entityes.User;
import exceptions.FacadeException;

/**
 *
 * @author skevi
 */
public interface IUpdateUserFCD {
    
    public void UpdateUser(User user) throws FacadeException;
    
}
