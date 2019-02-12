package model;

import controller.MastermindIllegalColorException;
import controller.MastermindIllegalLengthException;

/**
 * 
 * @author Lucia Wang 
 * Professor Misurda
 * CS 335
 * Project 1: Mastermind 
 * In MVC, MastermindModel is model
 *
 */
public class MastermindModel {
	// private variable(s) to store the answer
	private String answer = "";

	// Only these methods may be public - you may not create any additional
	// public methods (and NO public fields)

	/**
	 * constructor to generate a random solution w the 6 letters. 
	 * possible colors =
	 * "r", "o", "y", "g", "b", "p"
	 * 
	 */
	public MastermindModel() {
		// TODO Make the answer
		for (int i = 0; i < 4; i++) {
			int random = (int) (Math.random() * 6);
			if (random == 0) {
				answer = answer + "" + 'r';
			} else if (random == 1) {
				answer = answer + "" + 'o';
			} else if (random == 2) {
				answer = answer + "" + 'y';
			} else if (random == 3) {
				answer = answer + "" + 'g';
			} else if (random == 4) {
				answer = answer + "" + 'b';
			} else {
				answer = answer + "" + 'p';
			}
		}
	}

	/**
	 * This method is a special constructor to allow us to use JUnit to test our
	 * model.
	 * 
	 * Instead of creating a random solution, it allows us to set the solution from
	 * a String parameter.
	 * 
	 * 
	 * @param answer
	 *            A string that represents the four color solution
	 * @throws MastermindIllegalColorException
	 * @throws MastermindIllegalLengthException
	 */
	public MastermindModel(String answer) throws MastermindIllegalColorException, MastermindIllegalLengthException {
		// Takes answer and stores it as your answer. Make sure the
		// getColorAt method still works

		this.answer = answer;
	}

	/**
	 * * Return color at position index as a char (first converted if stored as a
	 * number)
	 * 
	 * @param answer
	 *            A string that represents the four color solution
	 * @returns char at index index
	 */
	public char getColorAt(int index) {
		return answer.charAt(index);
	}
}
