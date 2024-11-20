/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import com.valorationService.facadeInterfaces.IValorateFCD;
import facadeInterfaces.IAddBookFCD;
import daoInterfaces.IBookDAO;
import entityes.Book;
import entityes.Valoration;
import exceptions.DAOException;
import exceptions.FacadeException;
import java.util.List;

/**
 *
 * @author skevi
 */
public class AddBookFCD implements IAddBookFCD{

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
    public AddBookFCD(IBookDAO bookDAO, IValorateFCD valorate) {
        this.bookDAO = bookDAO;
        this.valorate = valorate;
    }
    
    /**
     * 
     * @param book
     * @throws exceptions.FacadeException
     */
    @Override
    public void addBook(Book book) throws FacadeException {
        verifyFields(book);
        verifyISBNMatch(book);
        verifyIsbnDisponibility(book);
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
            Valoration valoration = valorate.
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
    
    /**
     * 
     * 
     * @param book
     * @throws FacadeException 
     */
    private void verifyISBNMatch(Book book) throws FacadeException {
        if (!book.getIsbn().matches("^\\d{3}-\\d-\\d{3}$")) {
            throw new FacadeException("El ISBN no sigue el formato 000-0-000");
        }
    }
    
    /**
     * 
     * @param book 
     */
    private void verifyIsbnDisponibility(Book book) throws FacadeException {
        try{
            List<Book> books = bookDAO.getBooks();

            for (Book book1 : books) {
                if (book1.getIsbn().equalsIgnoreCase(book.getIsbn())) {
                    throw new FacadeException("El isbn ya esta ocupado "
                            + "por otro libro");
                }
            }
        
        }catch(DAOException ex){
            throw new FacadeException(ex.getMessage());
        }
    }
}
