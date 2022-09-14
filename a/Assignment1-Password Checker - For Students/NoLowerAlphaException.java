package application;

public class NoLowerAlphaException extends Exception{
	public NoLowerAlphaException() {
		super("Password doesn't contain lower case character.");
	}

}
