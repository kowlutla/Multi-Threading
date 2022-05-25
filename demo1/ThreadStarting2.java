package demo1;

class MyThread1 implements Runnable {

	public void run() {

		for (int i = 1; i <= 10; i++) {
			System.out.println(Thread.currentThread().getName() + " : Hello " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadStarting2 {

	public static void main(String args[]) {
		Thread t1 = new Thread(new MyThread1(), "First Thread");
		t1.start();
		Thread t2 = new Thread(new MyThread1(), "Secoond Thread");
		t2.start();
	}

}
