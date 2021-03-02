package work;

public class work1_2 {
	public static void main(String[] args) {
		Object obj = new Object();
		for (int i = 0; i < 3; i++) {
			new Thread(new myThreads(obj, "" + (char) (i + 65), i)).start();
		}
	}
}

class myThreads implements Runnable {
	private Object obj;
	private String name;
	private int i;

	private static int count = 0;

	public myThreads(Object obj, String name, int i) {
		this.obj = obj;
		this.name = name;
		this.i = i;
	}

	@Override
	public void run() {
		synchronized (obj) {
			for (int n = 0; n < 10; ) {

				if ((count) % 3 != i) {
					try {
						obj.wait();
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				} else {

					if (count % 3 == i) {
						System.out.print(name);
						count++;
						n++;
						obj.notifyAll();
					}

				}
			}
		}
	}

}