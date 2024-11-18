/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package valoration;

import entityes.Book;
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
     * @param editorial
     * @return 
     */
    @Override
    public Book getValoration(String title, String author, String editorial) {
        return null;
    }
    
    
    /**
     * 
     * @return 
     */
    public List<Book> getBooksToValorate() {
        return books;
    }
    
    
}
