//Seleyna Bautista

package game;

import util.ConsoleReader;

public class Guesser {
	
	protected static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

	// how many guesses are remaining
    //public int myNumGuessesLeft;
    
    // tracks letters guessed
    public StringBuilder myLettersLeftToGuess;
    
    protected HangmanGame hangmanGame;
    
    public Guesser() {
    	this.myLettersLeftToGuess = new StringBuilder(ALPHABET);
    }
    
 // Process a guess by updating the necessary internal state.
    public void makeGuess (char guess, HangmanGame hangmanGame) {
        // do not count repeated guess as a miss
        int index = myLettersLeftToGuess.indexOf("" + guess);
        if (index >= 0) {
            recordGuess(index);
        }
    }
    
    public char getGuess() {
    	char g = 0;
    	String guess = ConsoleReader.promptString("Make a guess: ");
        if (guess.length() == 1 && Character.isAlphabetic(guess.charAt(0))) {
        	g = guess.toLowerCase().charAt(0);
        }
        else {
        	System.out.println("Please enter a single letter ...");
        }
        return g;
    }
    
    
    
    
 // Record that a specific letter was guessed
    public void recordGuess (int index) {
        myLettersLeftToGuess.deleteCharAt(index);
    }
    
    
    public StringBuilder getMyLettersLeftToGuess() {
    	return myLettersLeftToGuess;
    }
}
