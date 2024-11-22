/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabricas;

import com.valorationService.integration.ExternalSystemIntegration;
import dao.BookDAO;
import facade.AddBookFCD;
import facade.UpdateBookFCD;
import valoration.Valorate;

/**
 *
 * @author skevi
 */
public class FacadeFactory {

    /**
     * Constructor privado para evitar instancias externas
     */
    private FacadeFactory() {
    }
    
    /**
     * 
     * @return 
     */
    public static AddBookFCD fabricateAddBookFCD(){
        BookDAO bookDAO = new BookDAO();
        Valorate valorate = new Valorate();
        ExternalSystemIntegration external = 
                new ExternalSystemIntegration(valorate);
        AddBookFCD addBookFCD = new AddBookFCD(bookDAO, external);
        
        return addBookFCD;
    }
    
    /**
     * 
     * @return 
     */
    public static UpdateBookFCD fabricateUpdateBookFCD(){
        BookDAO bookDAO = new BookDAO();
        Valorate valorate = new Valorate();
        ExternalSystemIntegration external = 
                new ExternalSystemIntegration(valorate);
        UpdateBookFCD updateBookFCD = new UpdateBookFCD(bookDAO, external);
        
        return updateBookFCD;
    }
    
}
