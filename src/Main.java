import game.AutoGuesser;
import game.Cheater;
import game.Executioner;
import game.Guesser;
import game.HangmanGame;
//import game.HangmanGameCheatingComputer;
import game.SecretWordCreator;
import util.HangmanDictionary;


/**
 * This class launches the Hangman game and plays once.
 * 
 * @author Michael Hewner
 * @author Mac Mason
 * @author Robert C. Duvall
 * @author Shannon Duvall
 */
public class Main {
    public static final String DICTIONARY = "data/lowerwords.txt";
    public static final int NUM_LETTERS = 6;
    public static final int NUM_MISSES = 8;


    public static void main (String[] args) {
    	HangmanDictionary hangmanDictionary = new HangmanDictionary(DICTIONARY);
    	Executioner executioner = new Executioner(hangmanDictionary, NUM_LETTERS, NUM_MISSES);
    	Guesser guesser = new Guesser();
    	//SecretWordCreator secretWordCreator = new SecretWordCreator(hangmanDictionary, NUM_LETTERS, NUM_MISSES);
    	AutoGuesser autoGuesser = new AutoGuesser();
    	Cheater cheater = new Cheater(hangmanDictionary, NUM_LETTERS, NUM_MISSES);
    	HangmanGame hangmanGame = new HangmanGame(guesser, cheater);
    	hangmanGame.play();
    }
}
