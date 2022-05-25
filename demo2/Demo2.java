package demo2;

import java.util.Scanner;

class MyThread extends Thread {
	private volatile boolean running = true;

	public void run() {
		while (running) {
			System.out.println("Hello ");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void shutDown() {
		this.running = false;
	}
}

public class Demo2 {

	public static void main(String[] args) {

		MyThread t1 = new MyThread();
		t1.start();
		System.out.println("Press enter to stop....");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		t1.shutDown();
		System.out.println("\n* * * Thank you for using* * * *");
	}

}
