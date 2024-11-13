/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import FacadeInterfaces.IRemoveBookFCD;
import dao.BookDAO;
import entityes.Book;
import exceptions.DAOException;
import exceptions.FacadeException;
import javax.swing.JOptionPane;

/**
 *
 * @author skevi
 */
public class RemoveBookFCD implements IRemoveBookFCD {
    
    /**
     * 
     */
    BookDAO bookDAO;

    /**
     * 
     */
    public RemoveBookFCD() {
        this.bookDAO = new BookDAO();
    }
    
    /**
     * 
     * @param book 
     * @throws exceptions.FacadeException 
     */
    @Override
    public void removeBook(Book book) throws FacadeException {
        try{
            bookDAO.removeBook(book);
            JOptionPane.showMessageDialog(null, "Exito al eliminar el libro");
        }
        catch(DAOException de){
            throw new FacadeException(de.getMessage());
        }
    }
    
}
