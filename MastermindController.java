package controller;

import model.MastermindModel;

/**
 * 
 * @author Lucia Wang
 * CS 335
 * Professor Misurda
 * Project 2: Mastermind
 * MVC: MastermindController is controller: determines if a guess is correct
 * by comparing it to the correct answer
 * Tells you how many are right color right place and right color wrong place
 *
 */
public class MastermindController {

	private MastermindModel model = new MastermindModel();

	/**
	 * Constructor
	 * @param MastermindModel object with answer
	 */
	public MastermindController(MastermindModel model) {
		this.model = model;
	}
	
	
	/**
	 * determines if a guess is correct meaning all the characters in guess 
	 * match the answer
	 * @param guess: a string that represents the user's guess
	 * @return true if guess is correct, false if not
	 */
	public boolean isCorrect(String guess) {

		for (int i = 0; i < 4; i++) {
			if (model.getColorAt(i) != guess.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * counts the number of guesses that are the right color and in the right place
	 * increments count when the 2 chars match
	 * 
	 * @param guess
	 *            A string that represents the four color guess
	 * @returns count An int that represents the number of guesses that are right
	 *          place right color
	 */
	public int getRightColorRightPlace(String guess) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			if (model.getColorAt(i) == guess.charAt(i)) {
				count += 1;
			}
		}
		return count; // Just something for now to make sure the code compiles
	}

	//
	/**
	 * returns the number of guesses out of 4 that are the right color but in the
	 * wrong place. Count increments when the answer contains the char at that index
	 * 
	 * @param guess
	 *            A string that represents the four color guess
	 * @returns count An int that represents the number of guesses that are right
	 *          color wrong place
	 */
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
		}
		return count;
	}
}
