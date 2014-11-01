/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.view;

import java.util.Scanner;

/**
 *
 * @author THERIAULT
 */
public class MapView {
    
    private final String MENU = "\n"
            + "\n-----------------------------------------------"
            + "\n|                   Map                       |"
            + "\n-----------------------------------------------"
            + "\n1 - Playground (Trivia Challenge)"
            + "\n2 - Monkey Bars (Pick a Number)"
            + "\n3 - Tree Stump (Shell Game)"
            + "\n4 - Dodgeball Court (Rock Paper Scissors)"
            + "\n5 - Steps (Homework Help)"
            + "\n6 - Hopscotch (Bully-watch)"
            + "\n7 - Soccer Field (Pay Brock)"
            + "\nQ - Quit"
            + "\n-----------------------------------------------";

    void displayMenu() {
        
        char selection = ' ';
        do {
            System.out.println(MENU); //display Menu
            
            String input = this.getInput(); // get the user selection
            selection = input.charAt(0); //get first character of a string
            
            this.doAction(selection); //do action based on selection
           
        } while (!"Q".equals(selection)); //not Quit
        
        
    }

    private String getInput() {
        boolean valid = false; //indicates if name has been received
        String userSelection = null;
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
        
        while(!valid) { //while a valid name has not been retrieved
            
            //prompt for player's name
            System.out.println("Where would you like to go?:");
            
            //get name from keyboard and trim off blanks
            userSelection = keyboard.nextLine();
            userSelection = userSelection.trim();
            userSelection = userSelection.toUpperCase();
            
            //if name invalid
            if (userSelection.length() < 1) {
                System.out.println("Invalid Selection.");
                continue;
            } if (!"1".equals(userSelection) & !"2".equals(userSelection) 
                    & !"3".equals(userSelection) & !"4".equals(userSelection) 
                    & !"5".equals(userSelection) & !"6".equals(userSelection)
                    & !"7".equals(userSelection) & !"Q".equals(userSelection)){
                System.out.println("Invalid Selection.");
                continue;
            }
            
            break;
        }
        
        return userSelection;
    }

    private void doAction(char choice) {
        
        switch (choice) {
            case '1': //display Goal of Game
                this.displayPlayground();
                break;
            case '2': //
                this.displayMonkeyBars();
                break;
            case '3': //
                this.displayTreeStump();
                break;
            case '4': //
                this.displayDodgeballCourt();
                break;
            case '5': //
                this.displaySteps();
                break;
            case '6': //
                this.displayHopscotch();
                break;
            case '7': //
                this.displaySoccerField();
                break;
            case 'Q': // Quit Program
                return;
            default:
                System.out.println("\n*** Invalid Selection ***");
                break;
                
        }
        
       
    }

    private void displayPlayground() {
        System.out.println("*** displayPlayground function called ***");
    }

    private void displayMonkeyBars() {
        System.out.println("*** displayMonkeyBars function called ***");
    }

    private void displayTreeStump() {
        System.out.println("*** displayTreeStump function called ***");
    }

    private void displayDodgeballCourt() {
        
        RPSGameView rpsGame = new RPSGameView();
        rpsGame.startRPSGame();
        
    }

    private void displaySteps() {
        System.out.println("*** displaySteps function called ***");
    }

    private void displayHopscotch() {
        System.out.println("*** displayHopscotch function called ***");
    }

    private void displaySoccerField() {
        System.out.println("*** displaySoccerField function called ***");
    }
    
}
