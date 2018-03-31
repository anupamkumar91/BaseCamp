package com.mindtree.multithreading;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ThreadClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		// Counter co = new Counter();
		System.out.println("enter no.of threads");
		Creation c = new Creation();

		try {
			int threads = scan.nextInt();

			Creation[] thread = new Creation[threads];

			for (int i = 0; i < threads; i++) {
				thread[i] = new Creation("A");
				System.out.println("Enter thread name as your wish:");
				String name = scan.next();
				thread[i].setName(name);
			}
			for (int i = 0; i < threads; i++) {
				thread[i].start();
				thread[i].join();

			}

			Thread.sleep(1000);

			System.out.println("Final incremented count value is:" + c.getCount());
		} catch (InputMismatchException ie) {
			System.out.println("InputMismatchException : Enter valid integer type value:");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
