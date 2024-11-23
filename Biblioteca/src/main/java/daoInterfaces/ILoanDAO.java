/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daoInterfaces;

import entityes.Book;
import entityes.Loan;
import entityes.User;
import exceptions.DAOException;

/**
 *
 * @author skevi
 */
public interface ILoanDAO {
    
    public void addLoan(Loan loan) throws DAOException;
    public void registerReturn(Loan loan) throws DAOException;
    public Loan searchByBookAndUser(Book book, User user) throws DAOException;        
    
}
