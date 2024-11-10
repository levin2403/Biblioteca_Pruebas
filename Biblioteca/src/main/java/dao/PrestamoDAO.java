/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import daoInterfaces.IPrestamoDAO;
import entityes.Libro;
import entityes.Prestamo;
import exceptions.DAOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que actúa como el Data Access Object (DAO) para la entidad Prestamo.
 * Esta clase proporciona métodos para gestionar los préstamos de libros.
 * 
 */
public class PrestamoDAO implements IPrestamoDAO{
    
    /**
     * Lista que almacena los préstamos en memoria.
     * Representa la base de datos en esta implementación.
     */
    private static List<Prestamo> prestamos = new ArrayList<>();
    
    /**
     * Registra un préstamo de un libro a un usuario.
     * Establece el estado del libro como prestado.
     * 
     * @param prestamo El objeto Prestamo que se desea registrar.
     * @throws exceptions.DAOException
     */
    @Override
    public void registrarPrestamo(Prestamo prestamo) throws DAOException {
        // Establecer el estado del libro como prestado
        Libro libro = prestamo.getLibro();
        libro.setPrestado(true); // Cambia el estado del libro a prestado
        
        // Agregar el préstamo a la lista
        prestamos.add(prestamo); // Almacena el préstamo en la lista
    }
    
    /**
     * Registra la devolución de un libro.
     * Establece el estado del libro como no prestado.
     * 
     * @param prestamo El objeto Prestamo que se desea registrar como devuelto.
     * @throws exceptions.DAOException
     */
    @Override
    public void registrarDevolucion(Prestamo prestamo) throws DAOException {
        // Establecer el estado del libro como no prestado
        Libro libro = prestamo.getLibro();
        libro.setPrestado(false); // Cambia el estado del libro a no prestado
        
    }
    
    /**
     * 
     * @return 
     */
    public List<Prestamo> listaPrestamos(){
        return PrestamoDAO.prestamos;
    }
}


