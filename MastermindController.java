package controller;

import model.MastermindModel;

/**
 * 
 * @author Lucia Wang
 *
 */
public class MastermindController {

	// Only these methods may be public - you may not create any additional
	// public methods (and NO public fields)

	private MastermindModel model = new MastermindModel();

	public MastermindController(MastermindModel model) {
		this.model = model;
	}

	public boolean isCorrect(String guess) {

		int correctGuesses = 0;
		for (int i = 0; i < 4; i++) {
			if (model.getColorAt(i) == guess.charAt(i)) {
				correctGuesses += 1;
			}
		}
		if (correctGuesses == 4) {
			return true;
		} else {
			return false;
		}
	}

	// counts the number of guesses that are the right color and in the right place
	// increments count when the 2 chars match
	public int getRightColorRightPlace(String guess) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			if (model.getColorAt(i) == guess.charAt(i)) {
				count += 1;
			}
		}
		return count; // Just something for now to make sure the code compiles
	}

	// returns the number of guesses out of 4 that are the right color but in the
	// wrong place
	// count increments when the answer contains the char at that index
	public int getRightColorWrongPlace(String guess) {
		// use 2d array
		char[][] colors = new char[4][2];
		int count = 0;

		// answer
		String a = "";
		for (int i = 0; i < 4; i++) {
			a = a + "" + model.getColorAt(i);
		}

		// populate 2d array: column 1 = answer, column 2 = guess
		for (int i = 0; i < 4; i++) {
			
			
			// prevent it from counting right color right place;
			if (guess.charAt(i) == model.getColorAt(i)) {
				colors[i][0] = 'z';
				colors[i][0] = 'x';
			} else {
				
				colors[i][0] = model.getColorAt(i);
				colors[i][1] = guess.charAt(i);
			}
	
		}

		// count right color wrong place
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (colors[i][0] == colors[j][1]) {
					count += 1;
					break;
				}
			}
			//if (a.contains(Character.toString(guess.charAt(i)))) {
			//	count += 1;
			//}
		}
		return count;
	}

	// Create as many private methods as you like

}
