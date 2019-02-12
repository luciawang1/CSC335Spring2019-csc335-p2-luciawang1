package controller;

/**
 * @author Lucia Wang
 * CS 335
 * Professor Misurda
 * Project 1: Mastermind
 */

/**
 * MastermindIllegalColorException is the exception that is thrown when the user
 * guesses an illegal color
 * 
 * legal colors: r, o, y, g, b, p
 */

public class MastermindIllegalColorException extends Exception {

	private static final long serialVersionUID = -8290218765279439675L;

	/**
	 * Constructor
	 * 
	 * @param message:
	 *            String representing error message
	 */
	public MastermindIllegalColorException(String message) {
		// System.out.println("Invalid color. Guess again");
		super(message);
	}

	/**
	 * error message
	 * 
	 * @returns error message
	 */
	public String toString() {
		return "Contains invalid colors. Valid colors are r, o, y, g, b, and p. " + getMessage();
	}

}
