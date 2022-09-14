package application;

public class NoSpecialCharacterException extends Exception{
	public NoSpecialCharacterException() {
		super("Password doesn't contain special character.");
	}

}
