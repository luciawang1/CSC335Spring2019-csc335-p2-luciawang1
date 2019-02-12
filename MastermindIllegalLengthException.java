package controller;

/**
 * @author Lucia Wang
 * CS 335
 * Professor Misurda
 * Project 1: Mastermind
 */

/**
 * MastermindIllegalLengthException is the exception that is thrown when the
 * length of a guess isn't 4
 */

public class MastermindIllegalLengthException extends Exception {

	private static final long serialVersionUID = 852038914350618576L;

	/**
	 * Constructor
	 * 
	 * @param message:
	 *            string of error message
	 */
	public MastermindIllegalLengthException(String message) {
		// System.out.println("Guess must be 4 letters long");
		super(message);
	}

	/**
	 * Error message for MastermindIllegalLengthException
	 * 
	 * @return error message
	 */
	public String toString() {
		return "Invalid length. Please guess 4 colors.";
	}

}
