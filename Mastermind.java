package View;
import java.util.Scanner;

import controller.MastermindController;
import controller.MastermindIllegalColorException;
import controller.MastermindIllegalLengthException;
import model.MastermindModel;

/**
 * 
 * @author Lucia Wang CS 335 Professor Misurda Project 1: Mastermind MVC:
 *         Mastermind class represents view of Mastermind
 */

public class Mastermind {

	/**
	 * main method
	 * 
	 * Asks user if they want to play no causes system to exit, anything else means
	 * yes
	 * 
	 * User has 10 tries to guess the right answer each answer has to have 4
	 * characters that are r, o ,y, g, b, p
	 * 
	 * For each guess, they are told right color right place and right color wrong
	 * place Keeps going until user guesses answer, or they've reached 10 guesses
	 * 
	 * User can keep playing until they say "no"
	 *
	 */

	public static void main(String[] args) {
		// This class represents the view, it should be how uses play the game
		System.out.println("Welcome to Mastermind!");
		System.out.print("Would you like to play? ");
		int numGuesses = 1;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String play = scanner.nextLine().toLowerCase();

		// play = no
		if (play.equals("no")) {
			System.out.println("bye!");
			System.exit(0);
		}

		// while the user wants to play:
		while (play != "no") {

			// Construct the model (whose constructor builds the secret answer)
			MastermindModel model = new MastermindModel();
			String answer = "";
			for (int i = 0; i < 4; i++) {
				answer += model.getColorAt(i);
			}

			// Construct the controller, passing in the model
			MastermindController controller = new MastermindController(model);
			// System.out.println(answer);
			System.out.println();

			// Read up to ten user inputs
			while (numGuesses <= 10) {
				System.out.println("Enter guess number " + numGuesses + ": ");
				String guess = scanner.nextLine().toLowerCase();
				try {

					validate(guess);

					// catch illegal length exception
				} catch (MastermindIllegalLengthException e) {
					System.out.println("invalid length. Guess again.");
					guess = scanner.nextLine().toLowerCase();
					continue;

					// catch illegal color exception
				} catch (MastermindIllegalColorException e) {
					System.out.println("Your guess contains invalid colors.");
					for (int i = 0; i < 4; i++) {
						if (guess.charAt(i) != 'r' && guess.charAt(i) != 'o' && guess.charAt(i) != 'y'
								&& guess.charAt(i) != 'g' && guess.charAt(i) != 'b' && guess.charAt(i) != 'p') {
							System.out.println(guess.charAt(i) + " is an invalid color.");
						}
					}
					System.out.println("Guess again.");
					guess = scanner.nextLine().toLowerCase();
					continue;

				}

				// win
				if (controller.isCorrect(guess)) {
					System.out.println("You win!");
					System.out.println();
					break;
				}

				// lose
				if (numGuesses == 10 && !controller.isCorrect(guess)) {
					System.out.println("You lose. The correct answer was: " + answer);
					System.out.println();
				}

				// display the relevant statistics (by asking the controller)
				System.out.println("Colors in the correct place: " + controller.getRightColorRightPlace(guess));
				System.out.println(
						"Colors correct but in the wrong position: " + controller.getRightColorWrongPlace(guess));
				System.out.println();
				numGuesses++;
			}

			// allow the user to play the game multiple times
			System.out.println("Welcome to Mastermind!");
			System.out.print("Would you like to play? ");
			play = scanner.nextLine().toLowerCase();
			if (play.equals("no")) {
				System.out.println("bye!");
				System.exit(0);
			} else {
				numGuesses = 0;
			}
		}

	}

	public static void validate(String guess) throws MastermindIllegalLengthException, MastermindIllegalColorException {
		// illegal length exception
		if (guess.length() != 4) {
			throw new MastermindIllegalLengthException("");
		}
		// illegal color exception
		for (int i = 0; i < 4; i++) {
			if (guess.charAt(i) != 'r' && guess.charAt(i) != 'o' && guess.charAt(i) != 'y' && guess.charAt(i) != 'g'
					&& guess.charAt(i) != 'b' && guess.charAt(i) != 'p') {
				throw new MastermindIllegalColorException("");
			}
		}
	}

}
