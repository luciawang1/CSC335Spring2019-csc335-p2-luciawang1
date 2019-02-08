package model;

/**
 * 
 * @author Lucia Wang
 *
 */
public class MastermindModel {
	// private variable(s) to store the answer
	private String answer = "";

	// Only these methods may be public - you may not create any additional
	// public methods (and NO public fields)
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
	 */
	public MastermindModel(String answer) {
		// TODO Take answer and somehow store it as your answer. Make sure the
		// getColorAt method still works
		this.answer = answer;
	}

	public char getColorAt(int index) {
		/*
		 * Return color at position index as a char (first converted if stored as a
		 * number)
		 */
		return answer.charAt(index);
	}

	// Create as many private methods as you like

}
