package threadLab;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class CarQueue implements Runnable{
	private Queue<Integer> Q;
	private Random rand=new Random();
	
	public void run() {
		for(int i=0;i<100;i++)
			try {
				Q.add(rand.nextInt(4));
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public CarQueue() {
		Q=new LinkedList<Integer>();
		
		Q.add(rand.nextInt(4));
		Q.add(rand.nextInt(4));
		Q.add(rand.nextInt(4));
		Q.add(rand.nextInt(4));
		System.out.println(Q.toString());
	}
	
	
	public void addToQueue() {
		Runnable r=new CarQueue();
		Thread t = new Thread(r);
		
		t.start();
	}
	
	public synchronized int deleteQueue() {
		if(Q.isEmpty())
			return rand.nextInt(4);
		return Q.remove();
	}
}
