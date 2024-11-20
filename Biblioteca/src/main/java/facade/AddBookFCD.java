/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import facadeInterfaces.IAddBookFCD;
import dao.BookDAO;
import entityes.Book;
import entityes.Valoration;
import exceptions.DAOException;
import exceptions.FacadeException;
import javax.swing.JOptionPane;

/**
 *
 * @author skevi
 */
public class AddBookFCD implements IAddBookFCD{

    /**
     * 
     */
    private ExternalSystemIntegration externalSystem;
    
    /**
     * 
     */
    private BookDAO bookDAO;
    
    /**
     * 
     */
    public AddBookFCD() {
        this.bookDAO = new BookDAO();
        this.externalSystem = new ExternalSystemIntegration();
    }
    
    /**
     * 
     * @param book
     * @throws exceptions.FacadeException
     */
    @Override
    public void addBook(Book book) throws FacadeException {
        verifyFields(book);
        getValoration(book);
        addBookInStorage(book);
    }
    
    /**
     * 
     */
    private void verifyFields(Book book) throws FacadeException {
        if (book.getIsbn().isEmpty()) {
            throw new FacadeException("El ISBN no puede estar vacio");
        }
        else if (book.getTitulo().isEmpty()) {
            throw new FacadeException("El titulo no puede estar vacio");
        }
        else if(book.getAutor().isEmpty()){
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
            bookDAO.addBook(book);
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
    private void getValoration(Book book) throws FacadeException {
        try{
            Valoration valoration =externalSystem.
                    getValoration(book.getTitulo(), book.getAutor());
            
            book.setValoration(valoration);
        }
        catch(Exception ex){

            //añadimos el libro sin valoracion
            addBookInStorage(book);
            
            //lanzamos la excepcion con el mensaje del error obtenido.
            throw new FacadeException(ex.getMessage());
        }
    }
    
}
