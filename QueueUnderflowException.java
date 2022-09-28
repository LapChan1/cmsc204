package a2;
/**
 * 
 * @author Lap Wu
 *
 */
public class QueueUnderflowException extends Exception{
	public QueueUnderflowException  () {
		super("Queue is empty.");
	}
}
