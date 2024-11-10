/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package utilities;

/**
 *
 * @author skevi
 */
public class PasswordTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // Contraseña original
         
         Hasher hasher = new Hasher();
         
        String password = "miContrasenaSegura";
        
        // Generamos el hash de la contraseña
        String storedHash = hasher.hashearContrasena(password);

        // Instancia de la clase que contiene verificarContrasena
        PasswordTest tester = new PasswordTest();

        // Prueba 1: Contraseña correcta
        if (hasher.verificarContrasena("miContrasenaSegura", storedHash)) {
            System.out.println("Prueba 1 exitosa: La contraseña es correcta.");
        } else {
            System.out.println("Prueba 1 fallida: La contraseña debería haber coincidido.");
        }

        // Prueba 2: Contraseña incorrecta
        if (hasher.verificarContrasena("contrasenaIncorrecta", storedHash)) {
            System.out.println("Prueba 2 fallida: La contraseña incorrecta no debería coincidir.");
        } else {
            System.out.println("Prueba 2 exitosa: La contraseña incorrecta no coincide.");
        }
        
    }
    
}
