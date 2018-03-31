package com.mindtree.multithreading;

public class Creation extends Thread {
	public static int count = 0;
	String inc;

	public Creation(String inc) {
		this.inc = inc;
	}

	public Creation() {

	}

	@Override
	public void run() {
		{
			increment();
		}
	}

	void increment() {

		for (int i = 0; i < 10; i++) {
			System.out.println(" running " + Thread.currentThread().getName() + (i + 1));
			++count;
		}

	}

	public int getCount() {
		return count;
	}
}
