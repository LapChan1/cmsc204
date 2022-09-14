package application;

public class UnmatchedException extends Exception{
	public UnmatchedException() {
		super("The passwords doesn't match.");
	}

}
