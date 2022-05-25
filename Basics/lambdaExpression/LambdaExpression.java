package lambdaExpression;

//Multi-threading using lambda Expression

public class LambdaExpression {

	public static void main(String[] args) throws Exception {

		System.out.println(Thread.currentThread().getName());
		Thread t1=new Thread()
				{
					public void run()
					{
						for(int i=1;i<=5;i++)
						{
							System.out.println("Thread1 : "+i);
						}
					}
				};
		
		Thread t2=new Thread(()->
		{
			for(int i=1;i<=5;i++)
			{
				System.out.println("Thread 2: "+i);
				try {Thread.sleep(100);}catch(Exception e) {}
			}
		});
		System.out.println("Thread 1 Alive: "+t1.isAlive());
		System.out.println("Thread 2 Alive: "+t2.isAlive());
		t1.start();
		t2.start();
		System.out.println("Thread 1 Alive: "+t1.isAlive());
		System.out.println("Thread 2 Alive: "+t2.isAlive());
		t1.join();
		t2.join();
		System.out.println("Thread 1 Alive: "+t1.isAlive());
		System.out.println("Thread 2 Alive: "+t2.isAlive());
//		System.out.println("Thread 1 pri: "+t1.getPriority());
//		System.out.println("Thread 2 pri: "+t2.getPriority());
		System.out.println("Main Thread Id: "+Thread.currentThread().getId());
		System.out.println("ID1: "+t1.getId());
		System.out.println("ID2: "+t2.getId());
	}

}
