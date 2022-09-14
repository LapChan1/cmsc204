package application;

public class NoDigitException extends Exception{
	public NoDigitException() {
		super("Password doesn't contain digit.");
	}

}
