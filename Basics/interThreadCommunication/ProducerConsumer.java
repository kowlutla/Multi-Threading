package interThreadCommunication;

public class ProducerConsumer {
	public static void main(String[] args) {
		
		// A a=new A();
		Item item = new Item(10);
		new Producer(item);
		new Consumer(item);

		// if(System.out.printf("Hello kowlutla")==null) {}
	}
}

class Producer implements Runnable {
	Item item;
	public Producer(Item item) {
		this.item = item;
		Thread t1 = new Thread(this, "Producer");
		t1.start();
	}
	public void run() {
		int i = 1;
		while (i <= item.items) {
			item.put(i++);
		}
	}
}

class Consumer implements Runnable {
	Item item;

	public Consumer(Item item) {
		this.item = item;
		Thread t = new Thread(this, "Consumer");
		t.start();
	}

	public void run() {
		int i = 1;
		while (i <= item.items) {
			item.get();
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
			}
			i++;
		}
	}
}

class Item {
	
	int items;
	int i = 1;
	boolean isSet = false;

	public Item(int items) {
		this.items = items;
	}

	public synchronized void put(int i) {
		while (isSet) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		System.out.println("Put: " + i);
		this.i = i;
		try {
			Thread.sleep(1500);
		} catch (Exception e) {
		}
		isSet = true;
		notify();
	}

	public synchronized void get() {
		while (!isSet) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		System.out.println("Get: " + i);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		isSet = false;
		notify();
	}
}