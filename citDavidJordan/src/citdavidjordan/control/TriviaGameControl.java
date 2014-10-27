/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package citdavidjordan.control;

/**
 *
 * @author Deann_2
 */
public class TriviaGameControl {
    
    public String triviaGame(String guess) {
        
        String answerOne = "Delaware Bay, Delaware";
	String answerTwo = "Henry Hudson Bay, Canada";
	String answerThree = "Emerald Bay, California";
	String answerFour = "Coos Bay, Oregon";
        
        String correctAnswer;
        
        correctAnswer = answerTwo;

	if (!(guess.equals(answerOne)) && !(guess.equals(answerTwo)) && !(guess.equals(answerThree)) && !(guess.equals(answerFour))) {
            
            return "That is not the correct input, make sure you type the answer exactly.";
            
        }
	
        if (guess.equals(answerOne)) {
            return "That is the incorrect guess.";
        }

	if (guess.equals(correctAnswer)) {
            return "That is the correct guess!";
        }
        
	if (guess.equals(answerThree)) {
            return "That is the incorrect guess, but nice try.";
        }

	if (guess.equals(answerFour)) {
            return "Close, but no cigar.";
        }

        else{
            return "This string should never appear.";
        }

    }
}
