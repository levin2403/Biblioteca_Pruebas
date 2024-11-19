/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import com.exceptions.SystemNotAvailableException;
import com.exceptions.ValorationNotFoundException;
import entityes.Valoration;
import interfaces.IValoration;
import valoration.Valorate;

/**
 *
 * @author skevi
 */
public class ExternalSystemIntegration{

    private IValoration valoration;

    public ExternalSystemIntegration() {
        this.valoration = new Valorate();
    }
    
    /**
     * 
     * @param title
     * @param author
     * @return
     */
    public Valoration getValoration(String title, String author) throws Exception{
        try{
            return valoration.getValoration(title, author);
        }
        catch(SystemNotAvailableException | ValorationNotFoundException ex){
            throw new Exception(ex.getMessage());
        }
        
    }
    
}
