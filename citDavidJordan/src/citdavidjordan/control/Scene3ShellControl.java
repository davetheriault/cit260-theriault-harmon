/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.control;

import citdavidjordan.CitDavidJordan;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Theriault
 */
public class Scene3ShellControl {
    
        protected final BufferedReader keyboard = CitDavidJordan.getInFile();
        protected final PrintWriter console = CitDavidJordan.getOutFile();

    public int shellGame() {
        Random rand = new Random();
            int nextInt = rand.nextInt(4);
                
        int position = 0;
        for (int i = 1; i < nextInt + 6; i++){
                Random ran = new Random();
                position = position + 1 - (((ran.nextInt(99)) % 2) * 2);
                if (position == -1) { this.console.println("Left"); }
                else { this.console.println("Right");
                }
            }
            if (position == 1) {
                position = position - 1;
                this.console.println("Left");
            }
            if (position == -1) {
                position = position + 1;
                this.console.println("Right");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Scene3ShellControl.class.getName()).log(Level.SEVERE, null, ex);
            }
            return position;
        }
            
    
    
    }
    

    

