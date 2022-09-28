package a2;
/**
 * 
 * @author Lap Wu
 *
 */
public class QueueOverflowException extends Exception{
	public QueueOverflowException () {
		super("Queue is full.");
	}
}
