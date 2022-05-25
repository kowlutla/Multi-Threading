package runnableInterface;

public class RunnableInterfaceDemo {

	public static void main(String[] args) {
		
		Runnable obj1=new A(0);
		Runnable obj2=new B(0);
	
		Thread t1=new Thread(obj1);
		System.out.println("Thread 1 Name: "+t1.getName());
		t1.setName("A Thread ");
		System.out.println("After changing Thread 1 Name: "+t1.getName());
		Thread t2=new Thread(obj2);
		System.out.println("Thread 2 Name: "+t2.getName());
		t2.setName("B Thread ");
		System.out.println("After changing Thread 2 Name: "+t2.getName());
		t1.start();
		try{Thread.sleep(1000);}catch(Exception e) {}
		t2.start();
		

	}

}


class A implements Runnable
{
	int n;
	public A(int n)
	{
		this.n=n;
	}
	
	public void run()
	{
		for(int i=1;i<=n;i++)
		{
			System.out.println("A class "+i);
			try{Thread.sleep(1000);}catch(Exception e) {};
		}
	}
}

class B implements Runnable
{
	int n;
	public B(int n)
	{
		this.n=n;
	}
	
	public void run()
	{
		for(int i=1;i<=n;i++)
		{
			System.out.println("B class "+i);
			try{Thread.sleep(1000);}catch(Exception e) {};
		}
	}
}


