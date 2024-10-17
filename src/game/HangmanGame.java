// Seleyna Bautista

package game;

import util.ConsoleReader;
import util.DisplayWord;
import util.HangmanDictionary;


/**
 * This class represents the traditional word-guessing game Hangman
 * that plays interactively with the user.
 *
 * @author Robert C. Duvall
 * @author Shannon Duvall
 */
public class HangmanGame {
    
    private Executioner executioner;
    
    private Guesser guesser;

    /**
     * Create Hangman game with the given dictionary of words to play a game with words 
     * of the given length and giving the user the given number of chances.
     */
    public HangmanGame (Guesser guesser, Executioner executioner) {
    	this.guesser = guesser;
    	this.executioner = executioner;    	
    }

    /**
     * Play one complete game.
     */
    public void play () {
        boolean gameOver = false;
        char guess = 0;
        while (!gameOver) {
		    printStatus();
		    guess = guesser.getGuess();
		    guesser.makeGuess(guess, this);
		    executioner.checkGuessInSecret(guess, this);
		    if (isGameLost()) {
		        System.out.println("YOU ARE HUNG!!!");
		        gameOver = true;
		    }
		    else if (isGameWon()) {
		        System.out.println("YOU WIN!!!");
		        gameOver = true;
		    }
        }
        System.out.println("The secret word was " + executioner.mySecretWord);
    }

    // Returns true only if the guesser has guessed all letters in the secret word.
    private boolean isGameWon () {
        return executioner.getMyDisplayWord().equals(executioner.mySecretWord);
    }

    // Returns true only if the guesser has used up all their chances to guess.
    private boolean isGameLost () {
        return executioner.getMyNumGuessesLeft() == 0;
    }

    // Print game stats
    private void printStatus () {
        System.out.println(executioner.getMyDisplayWord());
        System.out.println("# misses left = " + executioner.getMyNumGuessesLeft());
        System.out.println("letters not yet guessed = " + guesser.getMyLettersLeftToGuess());
        // NOT PUBLIC, but makes it easier to test
        System.out.println("*** " + executioner.mySecretWord);
        System.out.println();
    }
}
