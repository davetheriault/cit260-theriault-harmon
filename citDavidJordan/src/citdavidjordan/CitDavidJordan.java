/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citdavidjordan;

import citdavidjordan.exceptions.ProgramControlException;
import citdavidjordan.model.Game;
import citdavidjordan.model.Player;
import citdavidjordan.view.ErrorView;
import citdavidjordan.view.MenuMainView;
import citdavidjordan.view.StartProgramView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author Deann_2
 */
public class CitDavidJordan {
    
    private static Game currentGame = null;
    private static Player player = null;
    
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    
    private static PrintWriter logFile = null;
            

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        CitDavidJordan.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        CitDavidJordan.player = player;
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        CitDavidJordan.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        CitDavidJordan.inFile = inFile;
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        CitDavidJordan.logFile = logFile;
    }
    
    
    public static void main(String[] args) throws ProgramControlException {
        
        try {
            //open char stream files for end user input output
            CitDavidJordan.inFile =
                    new BufferedReader(new InputStreamReader(System.in));
            
            CitDavidJordan.outFile = new PrintWriter(System.out, true);
            
            //open log file
            String filePath = "logfile.txt";
            CitDavidJordan.logFile = new PrintWriter(filePath);
            
            
            MenuMainView mmv = new MenuMainView();
            mmv.display();
            /*StartProgramView startProgramView;
            startProgramView = new StartProgramView();
            startProgramView.display(); */
            
        } catch (Exception e) { 
            System.out.println("Exception: " + e.toString() +
                             "\nCause: " + e.getCause() +
                             "\nMessage: " + e.getMessage());
        }
        finally {
            try {
                /* Instructor: 
                 *  You need to check to make sure that each file is not null
                 *  because they may have never been opened in the first place
                 * if an error occurred prior to opening the file.
                 */
                CitDavidJordan.inFile.close();
                CitDavidJordan.outFile.close();
                CitDavidJordan.logFile.close();
                
            } catch (IOException ex) {
                ErrorView.display(currentGame.getClass().getName(), "Error closing files.");
                return;
            }
            
        }
        
        
        }
                       
    } 
    

