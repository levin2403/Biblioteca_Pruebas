/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daoInterfaces;

import entityes.Usuario;
import exceptions.DAOException;
import java.util.List;

/**
 *
 * @author skevi
 */
public interface IUsuarioDAO {
    
    public Usuario obten(int id) throws DAOException;
    public void registrarUsuario(Usuario usuario) throws DAOException;
    public void actualizarUsuario(Usuario usuario) throws DAOException;
    public List<Usuario> listaUsuarios() throws DAOException;
    
}
