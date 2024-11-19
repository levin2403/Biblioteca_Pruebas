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
import javax.swing.JOptionPane;

/**
 *
 * @author skevi
 */
public class UpdateBookFCD implements IUpdateBookFCD {
    
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
    private Book book;

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
        this.book = book;
        verifyFields();
        getValoration();
        update();
    }
    
    private void update() throws FacadeException{
        try{
            int option = JOptionPane.showConfirmDialog(
                null, 
                "¿Esta seguro de querer eliminar el libro?", 
                "Confirmación", 
                JOptionPane.YES_NO_OPTION
            );
            
            if (option == JOptionPane.YES_OPTION) {
                bookDAO.updateBook(book);
                JOptionPane.showMessageDialog(null, "Exito al actualizar "
                        + "el libro");
            }
            
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
    private void getValoration() throws FacadeException {
        try{
            Valoration valoration =externalSystem.
                    getValoration(this.book.getTitulo(), this.book.getAutor());
            
            this.book.setValoration(valoration);
        }
        catch(Exception ex){

            //añadimos el libro sin valoracion
            update();
            
            //lanzamos la excepcion con el mensaje del error obtenido.
            throw new FacadeException(ex.getMessage());
        }
    }
    
    /**
     * 
     */
    private void verifyFields() throws FacadeException {
        if (this.book.getIsbn().isEmpty()) {
            throw new FacadeException("El ISBN no puede estar vacio");
        }
        else if (this.book.getTitulo().isEmpty()) {
            throw new FacadeException("El titulo no puede estar vacio");
        }
        else if(this.book.getAutor().isEmpty()){
            throw new FacadeException("El autor no puede estar vacio");
        }
    }
}
