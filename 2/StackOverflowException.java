package a2;
/**
 * 
 * @author Lap Wu
 *
 */
public class StackOverflowException extends Exception{
	public StackOverflowException() {
		super("Stack is full.");
	}
}
