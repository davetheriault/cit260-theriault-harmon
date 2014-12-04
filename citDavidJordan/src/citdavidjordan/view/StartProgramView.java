/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package citdavidjordan.view;
import citdavidjordan.control.ProgramControl;
import citdavidjordan.exceptions.MenuControlException;
import citdavidjordan.exceptions.ProgramControlException;
import citdavidjordan.model.Player;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
*
* @author THERIAULT
*/
    public class StartProgramView extends MenuView{
        
        public static StartProgramView startProgramView;

    public StartProgramView() {
        super("\n************************************************************" +
              "\n*                                                          *"
            + "\n* Oak Elementary is not your average elementary school.    *"
            + "\n* Its grounds have given rise to a unique socioeconomic    *"
            + "\n* structure, that revolves around the accumulation of the  *"
            + "\n* almighty marble!                                         *"
            + "\n* As a simple, unassuming 5th-grader, can you manipulate   *"
            + "\n* the social structure to overcome your bully tormentor    *"
            + "\n* and become king of the jungle gym?!                      *"
            + "\n*                                                          *"
            + "\n* Get ready for...                                         *"
            + "\n*                                                          *"
            + "\n* PLAYGROUND HUSTLE!©                                      *"
            + "\n*                                                          *"
            + "\n************************************************************");
    }
    
    @Override
    public String getInput() {
        boolean valid = false; //indicates if name has been received

            String playerName = null;
            
            while(!valid) { 
                try {
                //while a valid name has not been retrieved
//prompt for player's name

                this.console.println("Enter the player's name below:");
//get name from keyboard and trim off blanks

                playerName = this.keyboard.readLine();

                playerName = playerName.trim();
//if name invalid

                if (playerName.length() < 1) {

                    try {
                        throw new Exception("Invalid name - the name must not be blank.");
                    } catch (Exception ex) {
                        ErrorView.display(this.getClass().getName(), ex.getMessage());
                        continue;
                    }
                }
                break;
                
                } catch (IOException ex) {
                    ErrorView.display(this.getClass().getName(), ex.getMessage());
                    continue;
                }
            }
            return playerName;
        }
    
    @Override
    public void doAction(String playerName) throws MenuControlException {
        
            try {
                Player player = ProgramControl.createPlayer(playerName);
                
                //display welcome message
                this.console.println("\n\n===============================================");
                this.console.println("\tWelcome " + player.getName() + "!");
                this.console.println("\tEverything is awesome "
                        + "\n\tin Playground Hustle™!");
                this.console.println("===============================================");
                
                //display main menu
                MenuMainView mainMenu = new MenuMainView();
                mainMenu.display();
            } catch (ProgramControlException ex) {
                ErrorView.display(this.getClass().getName(), ex.getMessage());

            }
    }    
    
    }
    

        /*public void startProgram() throws ProgramControlException{

            while(true){
                //Display the banner screen
                this.display();
            
            //Get the players name
                String playerName;
            
                try {
                    playerName = this.getPlayerName();
                } catch (ProgramControlException ex) {
                    System.out.println(ex.getMessage());
                    continue;
                }
            
                Player player = ProgramControl.createPlayer(playerName);
            
            //DISPLAY a customized welcome message
                this.displayWelcomeMessage(player);
            
            //DISPLAY the main menu
                MenuMainView mainMenu = new MenuMainView();
                mainMenu.display();
            }
        }

        

        }

        public String getPlayerName() throws ProgramControlException {

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

                    throw new ProgramControlException("Invalid name - the name must not be blank.");

                    

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

    

    */
