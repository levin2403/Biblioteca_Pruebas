/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import facadeInterfaces.IAddBookFCD;
import dao.BookDAO;
import entityes.Book;
import exceptions.DAOException;
import exceptions.FacadeException;
import javax.swing.JOptionPane;
//import interfaces.IValoration;

/**
 *
 * @author skevi
 */
public class AddBookFCD implements IAddBookFCD/**, IValoration**/{

    /**
     * 
     */
    BookDAO bookDAO;

    /**
     * 
     */
    public AddBookFCD() {
        this.bookDAO = new BookDAO();
    }
    
    /**
     * 
     * @param book
     * @throws exceptions.FacadeException
     */
    @Override
    public void addBook(Book book) throws FacadeException {
        verifyFields(book);
        addBookInStorage(book);
        sendBookToValorate(book);
    }
    
    /**
     * 
     */
    private void verifyFields(Book libro) throws FacadeException {
        if (libro.getIsbn().isEmpty()) {
            throw new FacadeException("El ISBN no puede estar vacio");
        }
        else if (libro.getTitulo().isEmpty()) {
            throw new FacadeException("El titulo no puede estar vacio");
        }
        else if(libro.getAutor().isEmpty()){
            throw new FacadeException("El autor no puede estar vacio");
        }
    }
    
    /**
     * 
     * @param book
     * @throws FacadeException 
     */
    private void addBookInStorage(Book book) throws FacadeException {
        try{
            
            int option = JOptionPane.showConfirmDialog(
                null, 
                "¿Esta seguro de querer agregar el libro?", 
                "Confirmación", 
                JOptionPane.YES_NO_OPTION
            );
            
            if (option == JOptionPane.YES_OPTION) {
                bookDAO.addBook(book);
                JOptionPane.showMessageDialog(null, "Libro agregado con "
                        + "exito");
            }
            
        }
        catch(DAOException de){
            throw new FacadeException();
        }
    }
    
    /**
     * Este va a quedar pendiente hasta aclaraciones.
     * 
     * @param book
     * @throws FacadeException 
     */
    private void sendBookToValorate(Book book) throws FacadeException {
        
    }
    
}
