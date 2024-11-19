/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import com.exceptions.SystemNotAvailableException;
import com.exceptions.ValorationNotFoundException;
import entityes.Valoration;

/**
 *
 * @author skevi
 */
public interface IValoration {
    
    /**
     *
     * @param title
     * @param author
     * @return
     * @throws com.exceptions.SystemNotAvailableException
     * @throws com.exceptions.ValorationNotFoundException
     */
    public Valoration getValoration(String title, String author) throws 
            SystemNotAvailableException, ValorationNotFoundException;
    
}
