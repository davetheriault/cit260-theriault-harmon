/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.playgroundhustle.views;

import citbyui.cit260.playgroundhustle.views.MenuGameView;
import citdavidjordan.model.Player;
import java.util.Scanner;

/**
 *
 * @author THERIAULT
 */
public class StartGameIntroView {
    
    //Player player = ;
    
    private final String MENU = ""
            + "\n-----------------------------------------------"
            + "\n|              Game Introduction              |"
            + "\n-----------------------------------------------"
            + "\nYou are a 5th grader" //todo insert get name thing <-
            + "\nat Oak Elementary School. This year, you got a "
            + "\nnew kid in your class - Brody. Brody joined    "
            + "\nyour class this year because he was held back  "
            + "\nfrom last year."
            + "\nSince joining your class, Brody has decided to "
            + "\nmake you his personal punching bag."  
            //todo finish intro story
            + "\nYada yada Yada... finish this later..."            
            + "\n\nAnd thus begins the Playground Hustle."
            + "\n\nPress <Enter> to continue.";

    public void displayMenu() {
        
        System.out.println(MENU); //display Menu
            
        Scanner keyboard = new Scanner(System.in);
        keyboard.nextLine();
            
        this.doAction(); //do action based on selection
       
    }


    private void doAction() {
        MenuGameView gameMenu;
        gameMenu = new MenuGameView();
        gameMenu.display();
    }
    
    
}