/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citdavidjordan.view;

import citdavidjordan.CitDavidJordan;
import citdavidjordan.control.MarbleControl;
import citdavidjordan.exceptions.MarbleControlException;
import citdavidjordan.exceptions.Scene2NumberException;
import citdavidjordan.exceptions.Scene5HomeworkException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Deann_2
 */
public class Scene5HomeworkView {
    public static Scene5HomeworkView homeworkHelpView;
    
    protected final BufferedReader keyboard = CitDavidJordan.getInFile();
    protected final PrintWriter console = CitDavidJordan.getOutFile();
    
    public void start() {
        
        String YorN2 = null;
        do {
            try {
            // display Johnny's petition
            this.displayPetition();
        } catch (Exception ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }     
        } while (!"N".equals(YorN2));
    }

    public void displayPetition() throws Scene5HomeworkException, Scene2NumberException, MarbleControlException, IOException {
        boolean valid = false; //indicates if name has been received
        String YorN2 = null;

        this.console.println("\n\n\n************************************************************");
        
        this.console.println(      "*                                                          *"
                             + "\n* Johnny is not the brightest kid on the block,            *"
                             + "\n* and he always needs help with his homeowrk.              *"
                             + "\n* He is willing to give you 5 marbles, if you help him.    *"
                             + "\n* Are you willing to help him?                             *");
        
        while(!valid) { //while a valid name has not been received
            
            this.console.println("(Y/N)?");
        
            YorN2 = this.keyboard.readLine();
            YorN2 = YorN2.trim();
            YorN2 = YorN2.toUpperCase();
            
            //if name invalid
            //if name invalid
            if (YorN2.length() < 1) {
                throw new Scene5HomeworkException("Invalid Selection - Please enter 'Y' for yes or 'N' for no.");
                
            } if (!"Y".equals(YorN2) & !"N".equals(YorN2)
                & !"YES".equals(YorN2) & !"NO".equals(YorN2)) {
                throw new Scene5HomeworkException("Invalid Selection - Please enter 'Y' for yes or 'N' for no.");
            } if ("Y".equals(YorN2)) {
                this.askQuestion();
            }
            
            else {
                this.quitMessage();
            }
        }
    }

    private void quitMessage() throws Scene2NumberException, MarbleControlException, IOException {
        this.console.println(    "\n                                                 "
                             + "\nJohnny: \"I don't want your help anyway.         "
                             + "\n\t Go back to where you came from. \"");
        this.console.println("\nPress <Enter> to continue:");
        
        this.keyboard.readLine();
        
        MapView mapView = new MapView();
        mapView.displayMenu();
    }

    @SuppressWarnings("UnusedAssignment")
    private void askQuestion() throws Scene2NumberException, MarbleControlException, IOException {
        String playerAnswer = null;
        boolean valid = false;
        
        /* Instructor: 
         * What happens when the player answers the question correct? Should'nt
         * you be calling a control function to update the score or keep track
         * of their progress or something. I believe you need to create a Conrol
         * Layer function in one of your Control Layer classes that will perfor
         * the correct action based on their answer.
         */
        
        this.console.println("\n\n\n************************************************************");
        
        this.console.println(    "*                                                             *" 
                             + "\n* A bat and a ball cost a dollar and ten cents              *"
                             + "\n* in total. The bat costs a dollar more than the            *"
                             + "\n* ball. How much does the ball cost?​                        *");
        
        this.console.println("\n* Enter exact answer below.");
        
        playerAnswer = this.keyboard.readLine();
        playerAnswer = playerAnswer.trim();
        //String text = "12.34"; // example String
        //double value = Double.parseDouble(text);
        double value = Double.parseDouble(playerAnswer);
        double correctAnswer = 0.05;
        
        if ( value == correctAnswer ) {
                    this.console.println("\nJohnny: \"I'm impressed that you got that right.\" ");
                    this.console.println("\n\"Here are your marbles... Enjoy!\" ");
                    MarbleControl.adjustMarbles(5, "swirly"); // Total marbles awarded.
        } if ( value != correctAnswer ) {
                    this.console.println("\nJohnny: \"I knew you wouldn't get it right. You owe me a Marble.\" ");
                    MarbleControl.adjustMarbles(-1, "swirly"); // Total marbles deducted if lose
        }
        
        if (value == correctAnswer) {
            this.console.println("That is the correct answer");
            
            this.console.println("\nPress <Enter> to continue:");
        
            this.keyboard.readLine();
        
            MenuGameView gameMenu = new MenuGameView();
            gameMenu.displayMap();
            
            // TO DO - Function to give them marbles
        } 
        else {
            this.console.println("That is the incorrect answer");
            
            this.console.println("\nPress <Enter> to continue:");
        
            this.keyboard.readLine(); 
        
            MenuGameView gameMenu = new MenuGameView();
            gameMenu.displayMap();
        } 
        
        //A bat and a ball cost a dollar and ten cents in total. The bat costs a dollar more than the

        // ball. How much does the ball cost?​
    }
    
}
