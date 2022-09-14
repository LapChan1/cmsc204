package application;

public class InvalidSequenceException extends Exception{
	public InvalidSequenceException() {
		super("Password contain has a sequence of 3 characters that are the same.");
	}

}
