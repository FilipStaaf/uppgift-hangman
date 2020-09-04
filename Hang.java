package fruits;

import java.util.*;

public class Hang {
	private static Scanner select = new Scanner(System.in);
//integer that store the attempts done by the user & a boolean used for the while loop in main. 
	public static Integer tries = 0;
	static boolean win = true;

//initiate a new char array that gets one under dash per index, relative to the length of the secret word.
	public void game() {

		SW.L = new char[SW.GAMEWORD.length()];
		for (int i = 0; i < SW.L.length; i++) {
			SW.L[i] = '_';
		}

	}

//method takes the input from the user & compares it with the secret word.
//if the letter exists in the secret word, it fills the char array with that letter in the same position as the character have in the secret word.
//if the character doesn't exist in the secret word, the number of tries will increase.
	public void userGuess(String letter) {
		if (!SW.GAMEWORD.contains(letter)) {
			tries++;
		}
		if (SW.GAMEWORD.contains(letter)) {
			int index = SW.GAMEWORD.indexOf(letter);
			while (index >= 0) {
				SW.L[index] = letter.charAt(0);
				index = SW.GAMEWORD.indexOf(letter, index + 1);
			}
		}

	}

//method that takes the letters stored in the char array & displays them at their current spot in the array index.
	private Object LContains() {
		StringBuilder currentIndex = new StringBuilder();
		for (int i = 0; i < SW.L.length; i++) {
			currentIndex.append(SW.L[i]);
			if (i < SW.L.length - 1) {
				currentIndex.append(" ");
			}
		}
		return currentIndex.toString();

	}

//method to get user input & it only takes the first letter from the input, if the user writes more than one letter.
	public void play() {

		String g = select.next().toLowerCase();
		if (g.length() > 1) {
			g = g.substring(0, 1);
		}
		userGuess(g);
	}

//method to get user input, were the user can guess the whole word, if user guess right it's a win. if user guess wrong it's a lose.
	public void wholeWord() {
		String WW = select.next().toLowerCase();
		if (!SW.GAMEWORD.contains(WW)) {			
			System.out.println(SW.hanger());
			System.out.println("Sorry you guessed the wrong word, you lose!\n the secret word was" + SW.GAMEWORD);
			win = false;
		} else if (SW.GAMEWORD.contains(WW)) {
			System.out.println("Congratulations you guessed the word right, you win!");
			win = false;
		}
	}
	
	public static void main(String[] args) {
		SW sClass = new SW();
		Hang hangman = new Hang();
		hangman.game();
		sClass.draw();		
		System.out.println("Welcome to hangman fruit edition, the game is to guess the name of a fruit!");
		while (win) {
            //string initialized with the full index of the charArray.
			//later used as a boolean to stop the game if it's equal to the secret word.
			String gWin = new String(SW.L).toString();
			//integer initialized with the total remainder of the maximum tries allowed for each run.
			int attemptsLeft = SW.MAX_TRY - tries;			
			System.out.println(
					"\nSelect a game option:\n(1)to guess a letter:\n(2)guess the whole word:\n(3)Game status:");
			try {
				//if statement that handles the exception of inputs that is something else than an integer
				if(select.hasNextInt())				
				{
				int choise = Integer.parseInt(select.next());			
				switch (choise) {
				case 1:
					hangman.play();
					System.out.println("\nCurrent progress:" + hangman.LContains());
					System.out.println(SW.H.get(tries-1));
					break;
				case 2:
					System.out.println("\nOBS! if you guess the wrong word you lose!" + "\n:");
					hangman.wholeWord();
					break;
				case 3:
					System.out.println("You have guessed wrong " + tries + " times! " + "\nYou have " + attemptsLeft + " attempts left!");
					break;
				}
				}
				else{
					System.out.println("You have to select one of the alternativs 1 , 2 or 3!");
					select.next();					
				}
			} catch (Exception e) {
				
			}
			if (tries >= 6) {
				System.out.println("Sorry you guessed the letters to many times, you lose!\n the secret word was " + SW.GAMEWORD);
				win = false;				
			}
			if(gWin.equals(SW.GAMEWORD)) {				
				System.out.println("Congratulations you guessed the whole word right, you win!");
				win = false;
			}
		}
	}
}
