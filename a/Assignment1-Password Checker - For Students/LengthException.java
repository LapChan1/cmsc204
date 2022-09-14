package application;

public class LengthException extends Exception {
	public LengthException() {
		super("Password length is too short");
	}
}
