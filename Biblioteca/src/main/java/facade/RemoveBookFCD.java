/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import facadeInterfaces.IRemoveBookFCD;
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
        verifyDisponibility(book);
        remove(book);
    }
    
    /**
     * 
     * @param book
     * @throws FacadeException 
     */
    private void verifyDisponibility(Book book) throws FacadeException {
        
    }
    
    /**
     * 
     * @param book
     * @throws FacadeException 
     */
    private void remove(Book book) throws FacadeException {
        try{
            
            int option = JOptionPane.showConfirmDialog(
                null, 
                "¿Esta seguro de querer eliminar el libro?", 
                "Confirmación", 
                JOptionPane.YES_NO_OPTION
            );
            
            if (option == JOptionPane.YES_OPTION) {
                bookDAO.removeBook(book);
                JOptionPane.showMessageDialog(null, "Exito al eliminar "
                        + "el libro");
            }
            
        }
        catch(DAOException de){
            throw new FacadeException(de.getMessage());
        }
    }
    
}
