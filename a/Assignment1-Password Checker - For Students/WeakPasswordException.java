package application;

public class WeakPasswordException extends Exception{
	public WeakPasswordException() {
		super("This password is weak.");
	}

}
