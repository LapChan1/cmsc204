package a1;

public class WeakPasswordException extends Exception{
	public WeakPasswordException() {
		super("This password is weak.");
	}

}
