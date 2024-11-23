/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entityes.Book;
import entityes.Loan;
import exceptions.DAOException;
import java.util.ArrayList;
import java.util.List;
import daoInterfaces.ILoanDAO;
import entityes.User;

/**
 * Clase que actúa como el Data Access Object (DAO) para la entidad Prestamo.
 * Esta clase proporciona métodos para gestionar los préstamos de libros.
 * 
 */
public class LoanDAO implements ILoanDAO{
    
    /**
     * Lista que almacena los préstamos en memoria.
     * Representa la base de datos en esta implementación.
     */
    private static List<Loan> prestamos = new ArrayList<>();

    /**
     * 
     */
    public LoanDAO() {
    }
    
    /**
     * Registra un préstamo de un libro a un usuario.
     * Establece el estado del libro como prestado.
     * 
     * @param loan El objeto Loan que se desea registrar.
     * @throws exceptions.DAOException
     */
    @Override
    public void addLoan(Loan loan) throws DAOException {
        try {
            if (loan == null) {
                throw new DAOException("El préstamo no puede ser nulo.");
            }

            Book libro = loan.getLibro();

            // Marcar el libro como prestado
            libro.setPrestado(true);

            // Agregar el préstamo a la lista de préstamos
            prestamos.add(loan);

        } catch (Exception ex) {
            throw new DAOException("Error al registrar el préstamo", ex);
        }
    }

    
    /**
     * Registra la devolución de un libro.
     * Establece el estado del libro como no prestado.
     * 
     * @param loan El objeto Loan que se desea registrar como devuelto.
     * @throws exceptions.DAOException
     */
    @Override
    public void registerReturn(Loan loan) throws DAOException {
        try{
            
        if (loan == null) {
            throw new DAOException("El préstamo no puede ser nulo.");
        }    
            
        Book libro = loan.getLibro();
        libro.setPrestado(false); // Cambia el estado del libro a no prestado
        
        }catch(Exception ex){
            throw new DAOException("Error al registrar la devolución del "
                    + "libro", ex);
        }
    }
    
    /**
     * 
     * @return 
     * @throws exceptions.DAOException 
     */
    public List<Loan> getLoans() throws DAOException {
        try {
            // Verificamos si la lista de préstamos es nula antes de 
            // devolverla.
            if (LoanDAO.prestamos == null) {
                throw new DAOException("La lista de préstamos no está "
                        + "inicializada.");
            }
            return LoanDAO.prestamos;

        } catch (Exception ex) {
            
            throw new DAOException("Error al obtener la "
                    + "lista de préstamos", ex);
        }
    }

    /**
     * 
     * @param book
     * @param user
     * @return
     * @throws DAOException 
     */
    @Override
    public Loan searchByBookAndUser(Book book, User user) throws DAOException {
       
        if (book == null || user == null) {
            throw new DAOException("Los campos de entrada no pueden "
                    + "estar vacios");
        }
        
        for (Loan prestamo : prestamos) {
            if (prestamo.getLibro().equals(book) && 
                    prestamo.getUsuario().equals(user)) {
                return prestamo;
            }
        }
        return null;
    }
    
}


