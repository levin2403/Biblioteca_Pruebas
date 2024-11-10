/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabricas;

import dao.UsuarioDAO;
import daoInterfaces.IUsuarioDAO;
import entityes.Usuario;
import exceptions.DAOException;

/**
 *
 * @author skevi
 */
public class FabricaUsuarios {

    /**
     * DAO para gestionar los usuarios.
     */
    private IUsuarioDAO usuarioDAO;

    /**
     * Constructor que inicializa la instancia de UsuarioDAO.
     */
    public FabricaUsuarios() {
        this.usuarioDAO = new UsuarioDAO();
    }

    /**
     * Fabrica 5 distintos usuarios y los agrega a la lista de usuarios 
     * de UsuarioDAO.
     */
    public void fabricarUsuarios() {
        try {
            // Crear instancias de Usuario con información única
            usuarioDAO.registrarUsuario(new Usuario(1, "Carlos Gómez", "carlos.gomez@example.com", "password123"));
            usuarioDAO.registrarUsuario(new Usuario(2, "Ana Martínez", "ana.martinez@example.com", "securepass456"));
            usuarioDAO.registrarUsuario(new Usuario(3, "Luis Ramírez", "luis.ramirez@example.com", "mypassword789"));
            usuarioDAO.registrarUsuario(new Usuario(4, "María Fernández", "maria.fernandez@example.com", "pass1234"));
            usuarioDAO.registrarUsuario(new Usuario(5, "Jorge López", "jorge.lopez@example.com", "password5678"));
            
            for (Usuario usuario : usuarioDAO.listaUsuarios()) {
                System.out.println(usuario.toString());
            }
            
        } catch (DAOException e) {
            System.out.println("Error al fabricar los usuarios");        
        }
    }
}

