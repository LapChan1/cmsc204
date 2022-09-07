package a1;

public class NoDigitException extends Exception{
	public NoDigitException() {
		super("Password doesn't contain digit.");
	}

}
