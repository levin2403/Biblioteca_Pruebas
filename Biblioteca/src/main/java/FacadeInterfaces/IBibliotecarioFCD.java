/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package FacadeInterfaces;

import exceptions.FacadeException;

/**
 *
 * @author skevi
 */
public interface IBibliotecarioFCD {
    
    public boolean loggin(String correo, String contrasena) throws FacadeException;
    
}
