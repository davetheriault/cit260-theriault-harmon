/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citdavidjordan.view;

import java.util.Scanner;

/**
 *
 * @author Deann_2
 */
public class HomeworkHelpView {
    public static HomeworkHelpView homeworkHelpView;
    public void homeworkHelp() {
        // display Johnny's petition
        this.displayPetition();
    }

    private void displayPetition() {
        boolean valid = false; //indicates if name has been received
        String YorN2 = null;
        Scanner keyboard = new Scanner(System.in); //keyboard input stream

        System.out.println("\n\n\n************************************************************");
        
        System.out.println(      "*                                                          *"
                             + "\n* Johnny is not the brightest kid on the block,            *"
                             + "\n* and he always needs help with his homeowrk.              *"
                             + "\n* He is willing to give you 5 marbles, if you help him.    *"
                             + "\n* Are you willing to help him?                             *");
        
        while(!valid) { //while a valid name has not been received
            
            System.out.println("(Y/N)?");
        
            YorN2 = keyboard.nextLine();
            YorN2 = YorN2.trim();
            YorN2 = YorN2.toUpperCase();
            
            //if name invalid
            //if name invalid
            if (YorN2.length() < 1) {
                System.out.println("Invalid Selection - Please enter 'Y' for yes or 'N' for no.");
                continue;
            } if (!"Y".equals(YorN2) & !"N".equals(YorN2)
                & !"YES".equals(YorN2) & !"NO".equals(YorN2)) {
                System.out.println("Invalid Selection - Please enter 'Y' for yes or 'N' for no.");
            } if ("Y".equals(YorN2)) {
                this.askQuestion();
            }
            
            else {
                this.quitMessage();
            }
        }
    }

    private void quitMessage() {
        System.out.println(    "\n                                                 "
                             + "\nJohnny: \"I don't want your help anyway.         "
                             + "\n\t Go back to where you came from. \"");
        System.out.println("\nPress <Enter> to continue:");
        
        Scanner keyboard = new Scanner(System.in);
        keyboard.nextLine();
        
        MapView mapView = new MapView();
        mapView.displayMenu();
    }

    @SuppressWarnings("UnusedAssignment")
    private void askQuestion() {
        String playerAnswer = null;
        boolean valid = false;
        Scanner keyboard = new Scanner(System.in);
        
        /* Instructor: 
         * What happens when the player answers the question correct? Should'nt
         * you be calling a control function to update the score or keep track
         * of their progress or something. I believe you need to create a Conrol
         * Layer function in one of your Control Layer classes that will perfor
         * the correct action based on their answer.
         */
        
        System.out.println("\n\n\n************************************************************");
        
        System.out.println(    "*                                                             *" 
                             + "\n* A bat and a ball cost a dollar and ten cents              *"
                             + "\n* in total. The bat costs a dollar more than the            *"
                             + "\n* ball. How much does the ball cost?​                        *");
        
        System.out.println("\n* Enter exact answer below.");
        
        playerAnswer = keyboard.nextLine();
        playerAnswer = playerAnswer.trim();
        //String text = "12.34"; // example String
        //double value = Double.parseDouble(text);
        double value = Double.parseDouble(playerAnswer);
        double correctAnswer = 0.05;
        
        if (value == correctAnswer) {
            System.out.println("That is the correct answer");
            
            System.out.println("\nPress <Enter> to continue:");
        
            keyboard = new Scanner(System.in);
            keyboard.nextLine();
        
            MapView mapView = new MapView();
            mapView.displayMenu();
            
            // TO DO - Function to give them marbles
        }
        else {
            System.out.println("That is the incorrect answer");
            
            System.out.println("\nPress <Enter> to continue:");
        
            keyboard = new Scanner(System.in);
            keyboard.nextLine();
        
            MapView mapView = new MapView();
            mapView.displayMenu();
        }
        
        //A bat and a ball cost a dollar and ten cents in total. The bat costs a dollar more than the

        // ball. How much does the ball cost?​
    }
    
}
