/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daoInterfaces;

import entityes.Libro;
import exceptions.DAOException;
import java.util.List;

/**
 *
 * @author skevi
 */
public interface ILibroDAO {
    
    public List<Libro> buscarPorTitulo(String titulo) throws DAOException;
    public List<Libro> buscarPorAutor(String autor) throws DAOException;
    public Libro buscarPorISBN(String isbn) throws DAOException;
    public void agregarLibro(Libro libro) throws DAOException;
    public void actualizarLibro(Libro libro) throws DAOException;
    public void eliminarLibro(Libro libro) throws DAOException;
    
}
