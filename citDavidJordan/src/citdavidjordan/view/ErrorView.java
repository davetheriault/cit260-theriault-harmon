/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.view;

import citdavidjordan.CitDavidJordan;
import java.io.PrintWriter;

/**
 *
 * @author THERIAULT
 */
public class ErrorView {
    
    private static final PrintWriter errorFile = CitDavidJordan.getOutFile();
    
    private static final PrintWriter logFile = CitDavidJordan.getLogFile();
    
    public static void display(String className, String errorMessage){
        
        errorFile.println(
                        "---------------------------------------------\n"
                      + "- ERROR - " + errorMessage + "\n"
                      + "---------------------------------------------");
        
        // log error
        logFile.println(className + " - " + errorMessage);
    }
    
}
