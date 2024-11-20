/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import facadeInterfaces.IUpdateBookFCD;
import dao.BookDAO;
import entityes.Book;
import entityes.Valoration;
import exceptions.DAOException;
import exceptions.FacadeException;

/**
 *
 * @author skevi
 */
public class UpdateBookFCD implements IUpdateBookFCD {
    
    /**
     * 
     */
    private final ExternalSystemIntegration externalSystem;
    
    /**
     * 
     */
    private final BookDAO bookDAO;
    
    /**
     * 
     */
    public UpdateBookFCD() {
        this.bookDAO = new BookDAO();
        this.externalSystem = new ExternalSystemIntegration();
    }
    
    /**
     * 
     * @param book 
     * @throws exceptions.FacadeException 
     */
    @Override
    public void UpdateBook(Book book) throws FacadeException {
        verifyFields(book);
        getValoration(book);
        update(book);
    }
    
    private void update(Book book) throws FacadeException{
        try{
            bookDAO.updateBook(book);
        }
        catch(DAOException de){
            throw new FacadeException(de.getMessage());
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
            update(book);
            
            //lanzamos la excepcion con el mensaje del error obtenido.
            throw new FacadeException(ex.getMessage());
        }
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
}
