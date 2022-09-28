package a2;
/**
 * 
 * @author Lap Wu
 *
 */
public class StackUnderflowException extends Exception{
	public StackUnderflowException() {
		super("The stack is empty.");
	}
}
