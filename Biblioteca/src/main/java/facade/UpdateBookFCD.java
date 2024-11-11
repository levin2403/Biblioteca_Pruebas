/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import dao.LibroDAO;
import entityes.Libro;
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
    LibroDAO bookDAO;

    /**
     * 
     */
    public UpdateBookFCD() {
        this.bookDAO = new LibroDAO();
    }
    
    /**
     * 
     * @param book 
     * @throws exceptions.FacadeException 
     */
    public void removeBook(Libro book) throws FacadeException{
        try{
            bookDAO.eliminarLibro(book);
            JOptionPane.showMessageDialog(null, "Exito al actualizar el libro");
        }
        catch(DAOException de){
            throw new FacadeException(de.getMessage());
        }
    }
}
