package a1;

public class NoUpperAlphaException extends Exception{
	public NoUpperAlphaException() {
		super("Password doesn't contain upper case character.");
	}
}
