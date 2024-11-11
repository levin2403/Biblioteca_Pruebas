/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daoInterfaces;

import entityes.Book;
import exceptions.DAOException;
import java.util.List;

/**
 *
 * @author skevi
 */
public interface IBookDAO {
    
    public List<Book> searchByTitle(String title) throws DAOException;
    public List<Book> searchByAuthor(String author) throws DAOException;
    public Book searchByISBN(String isbn) throws DAOException;
    public void addBook(Book book) throws DAOException;
    public void updateBook(Book book) throws DAOException;
    public void removeBook(Book book) throws DAOException;
    public List<Book> getBooks() throws DAOException;
    
}
