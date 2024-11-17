/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package facadeInterfaces;

import entityes.Book;
import exceptions.FacadeException;

/**
 *
 * @author skevi
 */
public interface IAddBookFCD {
    
    public void addBook(Book book) throws FacadeException;
    
}
