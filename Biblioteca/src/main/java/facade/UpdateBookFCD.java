/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import dao.BookDAO;
import entityes.Book;
import exceptions.DAOException;
import exceptions.FacadeException;
import javax.swing.JOptionPane;

/**
 *
 * @author skevi
 */
public class UpdateBookFCD {
    
    /**
     * 
     */
    BookDAO bookDAO;

    /**
     * 
     */
    public UpdateBookFCD() {
        this.bookDAO = new BookDAO();
    }
    
    /**
     * 
     * @param book 
     * @throws exceptions.FacadeException 
     */
    public void UpdateBook(Book book) throws FacadeException{
        try{
            bookDAO.updateBook(book);
            JOptionPane.showMessageDialog(null, "Exito al actualizar el libro");
        }
        catch(DAOException de){
            throw new FacadeException(de.getMessage());
        }
    }
}
