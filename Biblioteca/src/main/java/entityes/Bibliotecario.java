/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entityes;

/**
 *
 * @author skevi
 */
public class Bibliotecario {
    
    /**
     * 
     */
    private String correo;
    
    /**
     * 
     */
    private String contrasena;

    /**
     * 
     */
    public Bibliotecario() {
    }

    /**
     * 
     * @param correo
     * @param contrasena 
     */
    public Bibliotecario(String correo, String contrasena) {
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
}
