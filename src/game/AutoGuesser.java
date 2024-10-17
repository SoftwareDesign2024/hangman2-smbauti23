package game;

import util.DisplayWord;
import util.HangmanDictionary;

public class AutoGuesser extends Guesser{
	

    private static final String LETTERS_ORDERED_BY_FREQUENCY = "etaoinshrldcumfpgwybvkxjqz";
    // guesser state
    private String myLetters;
    private int myIndex;

	public AutoGuesser() {
		super();
        myLetters = LETTERS_ORDERED_BY_FREQUENCY;
        myIndex = 0;
	}
	
	public char getGuess() {
		Character guess = myLetters.charAt(myIndex++);
		return guess;
	}
	
	public String getMyLetters() {
		return myLetters;
	}
	
	public int getMyIndex() {
		return myIndex;
	}
	
	
	

}
