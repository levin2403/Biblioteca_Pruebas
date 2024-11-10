/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author skevi
 */
public class FacadeException extends Exception{

    public FacadeException() {
    }

    public FacadeException(String message) {
        super(message);
    }

    public FacadeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FacadeException(Throwable cause) {
        super(cause);
    }

    public FacadeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
