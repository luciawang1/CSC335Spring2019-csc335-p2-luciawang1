import java.util.Scanner;

import controller.MastermindController;
import model.MastermindModel;

/**
 * 
 * @author Lucia Wang
 *
 */
public class Mastermind {

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
			System.out.println(answer);
			System.out.println();

			// Read up to ten user inputs
			while (numGuesses <= 10) {
				System.out.println("Enter guess number " + numGuesses + ": ");
				numGuesses += 1;
				String guess = scanner.nextLine().toLowerCase();
				while (guess.length() != 4) {
					System.out.println("Invalid guess, guess again.");
					guess = scanner.nextLine().toLowerCase();
				}
				// Check whether or not the input is correct (by asking the controller)
				if (controller.isCorrect(guess)) {
					System.out.println("You win!");
					System.out.println();
					break;
				}

				// display the relevant statistics (by asking the controller)
				System.out.println("Colors in the correct place: " + controller.getRightColorRightPlace(guess));
				System.out.println(
						"Colors correct but in the wrong position: " + controller.getRightColorWrongPlace(guess));
				System.out.println();
			}

			// Determine win or loss
			if (numGuesses == 11) {
				System.out.println("You lose. The correct answer was: " + answer);
				System.out.println();
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

}
