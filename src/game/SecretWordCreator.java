package game;

import util.ConsoleReader;
import util.HangmanDictionary;

public class SecretWordCreator extends Executioner{
	
	
	public SecretWordCreator(HangmanDictionary dictionary, int wordLength, int numGuesses) {
		super(dictionary, wordLength, numGuesses);
	}
	
	@Override
	public String getSecretWord (HangmanDictionary dictionary, int wordLength) {
        mySecretWord = ConsoleReader.promptString("Choose a secret word that is " + wordLength + " letters long: ");
        while (! dictionary.contains(mySecretWord, wordLength)) {
            mySecretWord = ConsoleReader.promptString("That word is not recognized, please choose another: ");
        }
        return mySecretWord;
    }
	
	

}
