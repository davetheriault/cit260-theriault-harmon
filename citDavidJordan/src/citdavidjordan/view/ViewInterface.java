/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.view;

import citdavidjordan.exceptions.MenuControlException;

/**
 *
 * @author THERIAULT
 */
public interface ViewInterface {
    
    public void display();
    public String getInput() throws MenuControlException;
    public void doAction(String value) throws MenuControlException;
    
}
