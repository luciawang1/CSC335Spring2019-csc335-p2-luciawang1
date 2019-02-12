package controller;

import model.MastermindModel;

/**
 * 
 * @author Lucia Wang CS 335 Professor Misurda Project 2: Mastermind MVC:
 *         MastermindController is controller: determines if a guess is correct
 *         by comparing it to the correct answer Tells you how many are right
 *         color right place and right color wrong place
 *
 */
public class MastermindController {

	private MastermindModel model = new MastermindModel();

	/**
	 * Constructor
	 * 
	 * @param MastermindModel
	 *            object with answer
	 */
	public MastermindController(MastermindModel model) {
		this.model = model;
	}

	/**
	 * determines if a guess is correct meaning all the characters in guess match
	 * the answer
	 * 
	 * @param guess:
	 *            a string that represents the user's guess
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
		int i = 0;
		int j;
		int correct = 0;

		int[] checked = new int[4];
		// checked so we can track right color right place and right color wrong place
		// without counting duplicates
		while (i < 4) {
			if (guess.charAt(i) != this.model.getColorAt(i)) {
				j = 0;
				while (j < 4) {
					if (checked[j] == 0) {
						if (guess.charAt(i) == this.model.getColorAt(j)
								&& guess.charAt(j) != this.model.getColorAt(j)) {
							correct++;
							checked[j] = 1;
							break;
						}
					}
					j++;
				}
			} else {
				checked[i] = 1;
			}
			i++;
		}
		return correct;
	}
}
