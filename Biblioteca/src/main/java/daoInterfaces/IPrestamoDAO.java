/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daoInterfaces;

import entityes.Prestamo;
import exceptions.DAOException;

/**
 *
 * @author skevi
 */
public interface IPrestamoDAO {
    
    public void registrarPrestamo(Prestamo prestamo) throws DAOException;
    public void registrarDevolucion(Prestamo prestamo) throws DAOException;
            
}
