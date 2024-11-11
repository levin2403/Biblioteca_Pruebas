/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entityes;

/**
 *
 * @author skevi
 */
public class ValoratedBook {
    
    /**
     * 
     */
    private Book book;
    
    /**
     * 
     */
    private int valoration;
    
    /**
     * 
     */
    private String review;

    /**
     * 
     */
    public ValoratedBook() {
    }

    /**
     * 
     * @param book
     * @param valoration
     * @param review 
     */
    public ValoratedBook(Book book, int valoration, String review) {
        this.book = book;
        this.valoration = valoration;
        this.review = review;
    }

    /**
     * 
     * @return 
     */
    public Book getBook() {
        return book;
    }

    /**
     * 
     * @param book 
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * 
     * @return 
     */
    public int getValoration() {
        return valoration;
    }

    /**
     * 
     * @param valoration 
     */
    public void setValoration(int valoration) {
        this.valoration = valoration;
    }

    /**
     * 
     * @return 
     */
    public String getReview() {
        return review;
    }

    /**
     * 
     * @param review 
     */
    public void setReview(String review) {
        this.review = review;
    }
    
}
