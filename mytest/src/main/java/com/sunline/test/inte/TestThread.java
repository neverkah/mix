package com.sunline.test.inte;

public class TestThread {

	private int count = 0;

	private synchronized void doEx(final String s, final int mod) {

		while (count < 30) {

			if (count % 3 == mod) {
				System.out.println(s);
				count++;
				notifyAll();
			} else {
				try {
					wait();
					System.out.println(Thread.currentThread().getName() +"  wait --");
				} catch (InterruptedException e) {

					e.printStackTrace();

				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		TestThread testThread = new TestThread();

		Thread threadA = testThread.genThread("A", 0);
		Thread threadB = testThread.genThread("B", 1);
		Thread threadC = testThread.genThread("C", 2);

		threadA.start();
		threadB.start();
		threadC.start();

	}

	public Thread genThread(final String s, final int mod) throws Exception {
		Thread threadA = new Thread(new Runnable() {

			@Override
			public void run() {
				doEx(s, mod);
			}

		});

		return threadA;
	}

}
