package a1;

public class NoLowerAlphaException extends Exception{
	public NoLowerAlphaException() {
		super("Password doesn't contain lower case character.");
	}

}
