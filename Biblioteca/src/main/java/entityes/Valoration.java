/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entityes;

/**
 *
 * @author skevi
 */
public class Valoration {
    
    /**
     * 
     */
    private byte score;
    
    /**
     * 
     */
    private String review;

    /**
     * 
     */
    public Valoration() {
    }

    /**
     * 
     * @param score
     * @param review 
     */
    public Valoration(byte score, String review) {
        this.score = score;
        this.review = review;
    }

    /**
     * 
     * @return 
     */
    public byte getScore() {
        return score;
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
     * @return 
     */
    @Override
    public String toString() {
        return "Valoration{" + "score=" + score + ", review=" + review + '}';
    }
    
}
