/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabricas;

import dao.LibrarianDAO;
import daoInterfaces.ILibrarianDAO;
import entityes.Librarian;
import exceptions.DAOException;
import utilities.Hasher;

/**
 *
 * @author skevi
 */
public class LibrarianFactory {

    /**
     * 
     */
    private ILibrarianDAO bibliotecarioDAO;

    /**
     * 
     */
    private Hasher hasher;

    /**
     * Constructor que inicializa la instancia de LibrarianDAO.
     */
    public LibrarianFactory() {
        this.bibliotecarioDAO = new LibrarianDAO();
        this.hasher = hasher = new Hasher();
    }

    /**
     * Crea diez instancias de bibliotecarios y las añade a la lista de
     * bibliotecarios.
     * 
     */
    public void fabricateLibrarians() {
        try {
            for (int i = 1; i <= 5; i++) {
                // Crear una instancia de Librarian con datos ficticios
                Librarian bibliotecario = new Librarian(
                        "bibliotecario" + i + "@biblioteca.com", // Correo ficticio
                        hasher.hashPassword("contrasena123"));
                // Agregar el bibliotecario a la lista en LibrarianDAO
                bibliotecarioDAO.addLibrarian(bibliotecario);
            }

            // imprimimos la lista de bibliotecarios para verificar
            for (Librarian bibliotecariolist : bibliotecarioDAO.getLibrarians()) {
                System.out.println(bibliotecariolist.toString());
            }
        } catch (DAOException ex) {
            System.out.println("error al fabricar los bibliotecarios");
        }
    }
}
