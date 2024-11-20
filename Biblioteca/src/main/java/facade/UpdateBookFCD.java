/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import com.valorationService.facadeInterfaces.IValorateFCD;
import facadeInterfaces.IUpdateBookFCD;
import daoInterfaces.IBookDAO;
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
    private final IValorateFCD valorate;
    
    /**
     * 
     */
    private final IBookDAO bookDAO;
    
    /**
     * 
     * @param bookDAO
     * @param valorate
     */
    public UpdateBookFCD(IBookDAO bookDAO, IValorateFCD valorate) {
        this.bookDAO = bookDAO;
        this.valorate = valorate;
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
            Valoration valoration = valorate.
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
