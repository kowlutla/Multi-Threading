package demo1;
//by extending thread

class MyThread extends Thread {

	public MyThread(String string) {
		super(string);
	}

	@Override
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

public class ThreadStarting {

	public static void main(String[] args) {

		MyThread t1 = new MyThread("First Thread");

		MyThread t2 = new MyThread("Second Thread");
		t1.start();
		t2.start();
	}

}
