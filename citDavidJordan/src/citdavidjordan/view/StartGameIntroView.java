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
public class StartGameIntroView {
    protected final BufferedReader keyboard = CitDavidJordan.getInFile();
    protected final PrintWriter console = CitDavidJordan.getOutFile();
    
    //Player player = ;
    
    private final String MENU = ""
            + "\n-----------------------------------------------"
            + "\n|              Game Introduction              |"
            + "\n-----------------------------------------------"
            + "\nYou, " + CitDavidJordan.getPlayer().getName() + ", are a 5th grader" 
            + "\nat Oak Elementary School. This year, you got a new kid in your class - Brody. "
            + "\nBrody joined your class this year because he was held back from last year."
            + "\nSince joining your class, Brody has decided to nmake you his personal punching bag."  
            + "\nHe has made your life a living hell. But an opportunity for freedom has arisen."
            + "\n"
            + "\nThe biggest dumbest kid in 6th grade, Brock, gets a kick outta intimidating "
            + "\nother kids - even bullies. He has offered to scare Brody into leaving you "
            + "\nalone, but only if you can pay him with 20 \"alley\" marbles."
            + "\n"
            + "\nYou don't have enough to pay him, but luckily, you go to Oak Elementary -"
            + "\nwhere marbles are like money. There is no shortage of marble gamblers "
            + "\nand peddlers in the schoolyard. "
            + "\nAnd so you will explore the playground, looking for opportunities to make easy"
            + "\nmarbles. Can you do it?"            
            + "\n\nAnd thus begins the Playground Hustle."
            + "\n\nPress <Enter> to continue.";

    public void displayMenu() throws IOException {
        
        System.out.println(MENU); //display Menu
            
        this.keyboard.readLine();
            
        this.doAction(); //do action based on selection
       
    }


    private void doAction() {
        MenuGameView gameMenu;
        gameMenu = new MenuGameView();
        gameMenu.display();
    }
    
    
}
