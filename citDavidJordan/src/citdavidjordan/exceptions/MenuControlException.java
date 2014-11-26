/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.exceptions;

/**
 *
 * @author Theriault
 */
public class MenuControlException extends Exception{

    public MenuControlException() {
    }

    public MenuControlException(String message) {
        super(message);
    }

    public MenuControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public MenuControlException(Throwable cause) {
        super(cause);
    }

    public MenuControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
    
}
