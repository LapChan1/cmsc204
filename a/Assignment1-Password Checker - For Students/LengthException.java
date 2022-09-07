package a1;

public class LengthException extends Exception {
	public LengthException() {
		super("Password length is too short");
	}
}
