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
public class MarbleControlException extends Exception{

    public MarbleControlException() {
    }

    public MarbleControlException(String message) {
        super(message);
    }

    public MarbleControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public MarbleControlException(Throwable cause) {
        super(cause);
    }

    public MarbleControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
    
}
