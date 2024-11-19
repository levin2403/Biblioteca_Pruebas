/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package valoration;

import com.exceptions.SystemNotAvailableException;
import com.exceptions.ValorationNotFoundException;
import entityes.Book;
import entityes.Valoration;
import interfaces.IValoration;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author skevi
 */
public class Valorate implements IValoration{
    
    /**
     * 
     */
    private static List<Book> books = new ArrayList<>();

    /**
     * 
     */
    public Valorate() {
        
    }
    
    /**
     * 
     * @param title
     * @param author
     * @return 
     */
    @Override
    public Valoration getValoration(String title, String author) throws 
            SystemNotAvailableException, ValorationNotFoundException {
        
        for (Book book : books) {
            if (book.getTitulo().equalsIgnoreCase(title) &&
                    book.getAutor().equalsIgnoreCase(author)) {
                return book.getValoration();
            }
        }
        
        throw new ValorationNotFoundException("La valoracion para el libro "
                + "con los campos proporcionados no ha sido encontrado");
    }
    
    /**
     * 
     * @param book 
     */
    public void addBook(Book book){
        Valorate.books.add(book);
    }
    
    /**
     * 
     * @return 
     */
    public List<Book> getBooksToValorate() {
        return books;
    }
    
    
}
