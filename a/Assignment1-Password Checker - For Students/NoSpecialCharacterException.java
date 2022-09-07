package a1;

public class NoSpecialCharacterException extends Exception{
	public NoSpecialCharacterException() {
		super("Password doesn't contain special character.");
	}

}
