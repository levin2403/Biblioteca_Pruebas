/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import daoInterfaces.IBookDAO;
import entityes.Book;
import exceptions.DAOException;
import exceptions.FacadeException;
import facadeInterfaces.IRemoveBookFCD;

/**
 * Clase para gestionar la eliminación de libros del sistema.
 * Implementa las validaciones necesarias antes de eliminar un libro.
 * 
 * @author skevi
 */
public class RemoveBookFCD implements IRemoveBookFCD {

    /**
     * DAO para interactuar con la base de datos de libros.
     */
    private final IBookDAO bookDAO;

    /**
     * Constructor que inicializa la clase con un DAO de libros.
     *
     * @param bookDAO instancia de IBookDAO para interactuar con los libros.
     * @throws IllegalArgumentException si bookDAO es nulo.
     */
    public RemoveBookFCD(final IBookDAO bookDAO) {
        if (bookDAO == null) {
            throw new IllegalArgumentException("El DAO de libros no puede ser nulo.");
        }
        this.bookDAO = bookDAO;
    }

    /**
     * Elimina un libro del sistema después de validar que no esté prestado.
     *
     * @param book el libro a eliminar.
     * @throws FacadeException si el libro es nulo o está prestado, o si ocurre un error en el DAO.
     */
    @Override
    public void removeBook(final Book book) throws FacadeException {
        validateBook(book);
        verifyDisponibility(book);
        remove(book);
    }

    /**
     * Valida que el libro no sea nulo.
     *
     * @param book el libro a validar.
     * @throws FacadeException si el libro es nulo.
     */
    private void validateBook(final Book book) throws FacadeException {
        if (book == null) {
            throw new FacadeException("El libro proporcionado es nulo.");
        }
    }

    /**
     * Verifica que el libro no esté prestado antes de eliminarlo.
     *
     * @param book el libro a verificar.
     * @throws FacadeException si el libro está prestado.
     */
    private void verifyDisponibility(final Book book) throws FacadeException {
        if (book.isPrestado()) {
            throw new FacadeException("No se puede eliminar un libro que se encuentra prestado.");
        }
    }

    /**
     * Elimina el libro usando el DAO.
     *
     * @param book el libro a eliminar.
     * @throws FacadeException si ocurre un error al interactuar con el DAO.
     */
    private void remove(final Book book) throws FacadeException {
        try {
            bookDAO.removeBook(book);
        } catch (DAOException de) {
            throw new FacadeException("Error al eliminar el libro: " + de.getMessage(), de);
        }
    }
}




