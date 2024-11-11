/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import dao.LibroDAO;
import entityes.Libro;
import exceptions.DAOException;
import exceptions.FacadeException;
import interfaces.IValoration;

/**
 *
 * @author skevi
 */
public class AddBookFCD implements IValoration{
    
    /**
     * 
     */
    LibroDAO bookDAO;

    /**
     * 
     */
    public AddBookFCD() {
        this.bookDAO = new LibroDAO();
    }
    
    /**
     * 
     */
    public void addBook(Libro book) throws FacadeException {
        verifyFields(book);
        addBookInStorage(book);
        sendBookToValorate(book);
    }
    
    /**
     * 
     */
    private void verifyFields(Libro libro) throws FacadeException {
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
    
    private void addBookInStorage(Libro book) throws FacadeException {
        try{
            bookDAO.agregarLibro(book);
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
    private void sendBookToValorate(Libro book) throws FacadeException {
        
    }
    
}
