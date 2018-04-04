import java.util.Scanner;

class Multithreading implements Runnable {
	static int counter = 0;

	public void run() {

		counter++;
		System.out.println(counter);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter how many thread you want:");
		int x = sc.nextInt();
		Thread[] threads = new Thread[x];
		for (int i = 0; i < threads.length; i++) {

			threads[i] = new Thread(new Multithreading());
			threads[i].start();
		}
		// System.out.println("counter:"+);
	}

}
