/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package FacadeInterfaces;

import entityes.Book;
import exceptions.FacadeException;

/**
 *
 * @author skevi
 */
public interface IRemoveBookFCD {
    
    public void removeBook(Book book) throws FacadeException;
    
}
