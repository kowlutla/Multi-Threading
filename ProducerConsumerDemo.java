import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumerDemo {

	public static void main(String[] args) throws Exception
	{
		ArrayBlockingQueue<Integer>q=new ArrayBlockingQueue<Integer>(10);
		Thread t1=new Thread(new Producer(q));
		Thread t2=new Thread(new Consumer(q));
		t1.start();
		t2.start();
		
	}

}
class Producer implements Runnable
{
	ArrayBlockingQueue<Integer> q;
	int i=1;
	public Producer(ArrayBlockingQueue<Integer> q) {
		super();
		this.q = q;
	}
	
	@Override
	public void run() 
	{
		while(i<=10)
		{
			Random rand=new Random();
			int data=rand.nextInt(100);
			try {
				produce(data);
				i++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void produce(int i) throws InterruptedException
	{
		System.out.println("Produced :"+i);
		q.put(i);
		Thread.sleep(1000);
	}
	
}

class Consumer implements Runnable
{
	ArrayBlockingQueue<Integer> q;
	public Consumer(ArrayBlockingQueue<Integer> q) {
		super();
		this.q = q;
	}
	@Override
	public void run()
	{
		while(true)
		{
			try {
				consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	


	public void consume() throws InterruptedException
	{
		System.out.println("Consumed :"+q.take());
		Thread.sleep(500);
	}
}



