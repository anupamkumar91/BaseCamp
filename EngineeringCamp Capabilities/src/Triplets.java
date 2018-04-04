

import java.util.Scanner;

public class Triplets {
	static void triplets(int[] arr, int n) {

		for (int i = 0; i < n; i++) {

			int temp = arr[i];
			for (int j = 0; j < n; j++) {

				int temp2 = arr[j];

				for (int k = j + 1; k < n; k++) {
					int sum = 0;

					sum = temp2 + arr[k];
					if (temp == sum) {
						System.out.println(arr[i] + "" + arr[j] + "" + arr[k]);
					}

				}

			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter how many number:");
		int n = sc.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter the number:");
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		triplets(arr, n);

	}

}
