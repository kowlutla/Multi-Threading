package threadClassdemo;

public class ThreadClassDemo {

	public static void main(String[] args) 
	{
		
		A a=new A(1);
		B b=new B(1);
		System.out.println(a.getName());
		a.start();
		b.start();

	}

}

class A extends Thread
{
	int n;
	public A(int n)
	{
		this.n=n;
	}
	
	public void run()
	{
	
		for(int i=0;i<n;i++)
		{
			System.out.println("A class ");
			
			try{Thread.sleep(1000);}catch(Exception e) {};
		}
	}
}

class B extends Thread
{
	int n;
	public B(int n)
	{
		this.n=n;
	}
	
	public void run()
	{
	
		for(int i=0;i<n;i++)
		{
			System.out.println("B class ");
			try{Thread.sleep(1000);}catch(Exception e) {};

		}
	}
}
