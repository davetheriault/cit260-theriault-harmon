/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package citdavidjordan.view;
import citdavidjordan.control.ProgramControl;
import citdavidjordan.model.Player;
import java.util.Scanner;
/**
*
* @author THERIAULT
*/
    public class StartProgramView {
        
        public static StartProgramView startProgramView;

        public void startProgram(){
//BEGIN
//Display the banner screen

            this.displayBanner();
//Get the players name

            String playerName = this.getPlayerName();
//Create a new player

            Player player = ProgramControl.createPlayer(playerName);
//DISPLAY a customized welcome message

            this.displayWelcomeMessage(player);
//DISPLAY the main menu

            MenuMainView mainMenu = new MenuMainView();

            mainMenu.display();
//END/

        }

        public void displayBanner() {

            System.out.println("\n************************************************************");
            System.out.println( "* *"
                                    + "\n* Oak Elementary is not your average elementary school. *"
                                    + "\n* Its grounds have given rise to a unique socioeconomic *"
                                    + "\n* structure, that revolves around the accumulation of the *"
                                    + "\n* almighty marble! *"
                                    + "\n* As a simple, unassuming 5th-grader, can you manipulate *"
                                    + "\n* the social structure to overcome your bully tormentor *"
                                    + "\n* and become king of the jungle gym?! *");
            System.out.println( "* *"
                                    + "\n* Get ready for... *");
            System.out.println( "* *"
                                    + "\n* PLAYGROUND HUSTLE!© *"
                                    + "\n* *"
                                    + "\n************************************************************");

        }

        public String getPlayerName() {

            boolean valid = false; //indicates if name has been received

            String playerName = null;

            Scanner keyboard = new Scanner(System.in); //keyboard input stream

            while(!valid) { //while a valid name has not been retrieved
//prompt for player's name

                System.out.println("Enter the player's name below:");
//get name from keyboard and trim off blanks

                playerName = keyboard.nextLine();

                playerName = playerName.trim();
//if name invalid

                if (playerName.length() < 1) {

                    System.out.println("Invalid name - the name must not be blank.");

                    continue;

                }

                break;

            }

            return playerName;

        }

        private void displayWelcomeMessage(Player player) {
            System.out.println("\n\n===============================================");
            System.out.println("\tWelcome " + player.getName() + "!");
            System.out.println("\tEverything is awesome "
                        + "\n\tin Playground Hustle™!");
            System.out.println("===============================================");
    }
}