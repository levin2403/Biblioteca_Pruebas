/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import facadeInterfaces.IRemoveBookFCD;
import dao.BookDAO;
import daoInterfaces.IBookDAO;
import entityes.Book;
import exceptions.DAOException;
import exceptions.FacadeException;

/**
 *
 * @author skevi
 */
public class RemoveBookFCD implements IRemoveBookFCD {
    
    /**
     * 
     */
    private final IBookDAO bookDAO;

    /**
     * 
     */
    public RemoveBookFCD(IBookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }
    
    /**
     * 
     * @param book 
     * @throws exceptions.FacadeException 
     */
    @Override
    public void removeBook(Book book) throws FacadeException {
        verifyDisponibility(book);
        remove(book);
    }
    
    /**
     * 
     * @param book
     * @throws FacadeException 
     */
    private void verifyDisponibility(Book book) throws FacadeException {
        if (book.isPrestado()) {
            throw new FacadeException("No se puede eliminar un libro que "
                    + "se encuentra prestado");
        }
    }
    
    /**
     * 
     * @param book
     * @throws FacadeException 
     */
    private void remove(Book book) throws FacadeException {
        try{
                bookDAO.removeBook(book);
        }
        catch(DAOException de){
            throw new FacadeException(de.getMessage());
        }
    }
    
}
