/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citdavidjordan.view;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author THERIAULT
 */
public class StartProgramViewTest {
    
    public StartProgramViewTest() {
    }

    /**
     * Test of startProgram method, of class StartProgramView.
     */
    @Test
    public void testStartProgram() {
        System.out.println("startProgram");
        StartProgramView instance = new StartProgramView();
        instance.startProgram();
        
    }

    /**
     * Test of getPlayersName method, of class StartProgramView.
     */
    @Test
    public void testGetPlayersName() {
        System.out.println("getPlayersName");
        StartProgramView instance = new StartProgramView();
        String expResult = "";
        String result = instance.getPlayersName();
        assertEquals(expResult, result);
        
    }
    
}
