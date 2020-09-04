package fruits;

import java.util.*;

public class SW {
	//string array containing predetermined words for the game.
	private static final String[] WORDS = { "apple", "pear", "apricot", "orange", "plum", "cherry", "grape", "peach", "tangerine", "lemon" };
	
	//random method that's used to initialize another method with one of string array's indexes (the secret word).
	private static final Random R = new Random();
	private static String newSW() {
		return WORDS[R.nextInt(WORDS.length)];
	}	
	
	//integer used to set a roof of max attempts allowed for each game round.
	public static final Integer MAX_TRY = 6;	
	
	//the actual game word initialized with the value of the random method.
	public static final String GAMEWORD = newSW();
	
	//char array that collects the guesses that the user inputs.
	public static char[] L;
	
	//string ArrayList that have the "drawing" stored, divided into 6 steps.
	public static ArrayList<String> H = new ArrayList<>();
	public void draw()
	{
		H.add(" |\n/|\\");
		H.add(" |\n |\n |\n/|\\ ");
		H.add(" |\n |\n |\n |\n |\n/|\\");
		H.add("  ______\n |\n |\n |\n |\n |\n/|\\");
		H.add("  ______\n |      |\n |      O\n |\n |\n |\n/|\\");
		H.add("  ______\n |      |\n |      O\n |     /|\\\n |     / \\\n |\n/|\\");

	}
	
	//method used to write the whole hanging man image in to the console.	
	public static final Object hanger() {
		String h = "  ___" + "___" + "\n |      " + "|" + "\n |      " + "O" + "\n |" + "     /|\\" + "\n |    " + " / \\" + "\n |" + "\n/|\\";
		return h;
	}	
}
