// Seleyna Bautista

package game;

import util.DisplayWord;
import util.HangmanDictionary;

public class Executioner {

	// word that is being guessed
    protected String mySecretWord;
    
    protected DisplayWord myDisplayWord;
    
    protected HangmanGame hangmanGame;
    
    protected int numGuessesLeft;
    
    public Executioner(HangmanDictionary dictionary, int wordLength, int numGuesses) {
    	mySecretWord = getSecretWord(dictionary, wordLength);
    	this.numGuessesLeft = numGuesses;
    	this.myDisplayWord = new DisplayWord(mySecretWord);
    }
    
 // Returns a secret word.
    public String getSecretWord (HangmanDictionary dictionary, int wordLength) {
    	mySecretWord = dictionary.getRandomWord(wordLength).toLowerCase();
    	return mySecretWord;
    }
    
 // Returns true only if given guess is in the secret word.
    public boolean checkGuessInSecret (char guess, HangmanGame hangmanGame) {
        if (mySecretWord.indexOf(guess) >= 0) {
            myDisplayWord.update(guess, mySecretWord);
            return true;
        }
        else {
            numGuessesLeft -= 1;
        }
        return false;
        
    }
    
    public DisplayWord getMyDisplayWord() {
    	return myDisplayWord;
    }
    
	  public int getMyNumGuessesLeft() {
		return numGuessesLeft;
	}
    
}
