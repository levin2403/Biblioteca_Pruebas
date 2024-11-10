/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;
    
import org.mindrot.jbcrypt.BCrypt;
    
/**
 *
 * @author skevi
 */
public class Hasher {

    /**
     * 
     */
    public Hasher() {
    }
    
    /**
     * 
     * @param contrasena
     * @return 
     */
    public String hashearContrasena(String contrasena) {
        return BCrypt.hashpw(contrasena, BCrypt.gensalt()); // Genera el hash con un salt aleatorio
    }

    /**
     * Method that verifies that the string of the password matches the 
     * hashed password 
     *
     * @param password
     * @param storedHash
     * @return 
     */
    public boolean verificarContrasena(String password, String storedHash) {
        return BCrypt.checkpw(password, storedHash);
    }
}
