/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.view;

import citdavidjordan.CitDavidJordan;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author THERIAULT
 */
public class Scene7PayBrockView {
    
    protected final BufferedReader keyboard = CitDavidJordan.getInFile();
    protected final PrintWriter console = CitDavidJordan.getOutFile();

    public void start() throws IOException {
        this.console.println("\n* Brock is a big kid and is willing to defend  *"
                           + "\n* you for an exchange of marbles. His servcies *"
                           + "\n* are pricy, but how much is your face worth?  *"
                           + "\n* For a total value of 100, Swirly = 1 value:  *"
                           + "\n* Steely = 2 value: and Alley = 5 value:, you  *"
                           + "\n* can buy his protection.                      *");
        this.console.println("\n\t* Click <Enter> to continue                  *");
        
        this.keyboard.readLine();
        this.payBrock();
    }

    private void payBrock() throws IOException {
        this.console.println("\n* Brock: \"So you have come to pay me have you.  *"
                           + "\n* My protection is not cheap. Lets make sure     *"                
                           + "\n* you have enough marbles for my services.\"     *");
                           
        this.console.println("\n\t* Would you like to continue?                  *");
        
        this.keyboard.readLine();
        
        MenuGameView displayInventory = new MenuGameView();
        displayInventory.displayInventory(this.console);
        
        if ( /* MenuGameView.displayInvetory .getValue() */1 > 100 ) {
            // code to do trade and win game. 
        } else {
            this.console.println("Brock: \"You do not have enough marbles sport. "
                                + "\n* I wish I could help, but come back when your *"
                                + "\n* total value is over 100.  *");
            this.console.println("*\n Click <Enter> to return to menu.              *");
            
            this.keyboard.readLine();
            
            MenuGameView mgv = new MenuGameView();
            mgv.display();
        }
    }
    
}
