/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dao;

import com.valorationService.exceptions.SystemNotAvailableException;
import com.valorationService.exceptions.ValorationNotFoundException;
import com.valorationService.factories.ValoratedBooksFactory;
import com.valorationService.integration.ExternalSystemIntegration;
import daoInterfaces.IBookDAO;
import entityes.Book;
import exceptions.DAOException;
import fabricas.FacadeFactory;
import facadeInterfaces.IAddBookFCD;
import facadeInterfaces.IUpdateBookFCD;
import valoration.Valorate;

/**
 *
 * @author skevi
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DAOException, 
            SystemNotAvailableException, ValorationNotFoundException, 
            Exception {
        
        IAddBookFCD addBookFCD = FacadeFactory.fabricateAddBookFCD();
        IUpdateBookFCD updateBookFCD = FacadeFactory.fabricateUpdateBookFCD();
        IBookDAO bookDAO = new BookDAO();
        
        // Fabricamos los libros valorados del sistema
        Valorate valorate = new Valorate();
        ValoratedBooksFactory valoratedFactory = 
                new ValoratedBooksFactory(valorate);
        valoratedFactory.fabricateValoratedBooks();
        
        ExternalSystemIntegration external = new ExternalSystemIntegration(valorate);
        
        Book initialBook = new Book("978-3-160", "Orgullo y prejuicio", "Jane Austen");
        
        Book bookToUpdate = new Book("978-3-160", "1984", "George Orwell");
        
//        for (Book book : valorate.getBooksToValorate()) {
//            System.out.println(book.toString());
//        }
        
        addBookFCD.addBook(initialBook);
        updateBookFCD.UpdateBook(bookToUpdate);
        System.out.println(bookDAO.searchByISBN("978-3-160").toString());
        
//        for (Book book : bookDAO.getBooks()) {
//            System.out.println(book.toString());
//        }
        
    }
    
}
