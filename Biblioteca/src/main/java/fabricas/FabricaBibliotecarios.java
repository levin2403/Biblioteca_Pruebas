/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabricas;

import dao.BibliotecarioDAO;
import daoInterfaces.IBibliotecarioDAO;
import entityes.Bibliotecario;
import exceptions.DAOException;
import java.util.List;
import utilities.Hasher;

/**
 *
 * @author skevi
 */
public class FabricaBibliotecarios {
   
    /**
     * 
     */
    private IBibliotecarioDAO bibliotecarioDAO;
    
    /**
     * 
     */
    private Hasher hasher;

    /**
     * Constructor que inicializa la instancia de BibliotecarioDAO.
     */
    public FabricaBibliotecarios() {
        this.bibliotecarioDAO = new BibliotecarioDAO();
        this.hasher = hasher = new Hasher();
    }

    /**
     * Crea diez instancias de bibliotecarios y las añade a la lista de
     * bibliotecarios.
     * 
     */
    public void fabricarBibliotecarios(){
        try{    
        for (int i = 1; i <= 5; i++) {
            // Crear una instancia de Bibliotecario con datos ficticios
            Bibliotecario bibliotecario = new Bibliotecario(
                    "bibliotecario" + i + "@biblioteca.com", // Correo ficticio
                    hasher.hashearContrasena("contrasena123")
            );
            // Agregar el bibliotecario a la lista en BibliotecarioDAO
            bibliotecarioDAO.addLibrarian(bibliotecario);
            }
        
            //imprimimos la lista de bibliotecarios para verificar 
            for (Bibliotecario bibliotecariolist : bibliotecarioDAO.getLibrarians()) {
                System.out.println(bibliotecariolist.toString());
            }
        }catch(DAOException ex){
            System.out.println("error al fabricar los bibliotecarios");
        }
    }
}
