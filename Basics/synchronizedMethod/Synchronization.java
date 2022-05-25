package synchronizedMethod;

public class Synchronization {

	public static void main(String[] args) throws Exception
	{
		Counter c=new Counter();
		A obj1=new A(c);
		B obj2=new B(c);
		
//		Thread t1=new Thread(obj1);
//		Thread t2=new Thread(obj2);
		obj1.start();
		obj2.start();
		obj1.join();
		obj2.join();
		
		System.out.println("Count: "+c.count);
	}

}


//class A implements Runnable
class A extends Thread
{
	Counter counter;
	public A(Counter counter)
	{
		this.counter=counter;
	}
	
	public void run()
	{
		for(int i=1;i<=1000;i++)
		{
			counter.increment();
		}
	}
}

//class B implements Runnable
class B extends Thread
{
	Counter counter;
	public B(Counter counter)
	{
		this.counter=counter;
	}
	
	public void run()
	{
		for(int i=1;i<=1000;i++)
		{
			counter.increment();
		}
	}
}


class Counter
{
	int count;
	public synchronized void increment()
	{
		count++;
	}
	
	
}
