package a1;

public class UnmatchedException extends Exception{
	public UnmatchedException() {
		super("The passwords doesn't match.");
	}

}
