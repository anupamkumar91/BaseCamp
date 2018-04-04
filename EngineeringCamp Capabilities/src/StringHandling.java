
import java.util.Scanner;

public class StringHandling {

	static void stringHandling(String str) {

		int n = str.length();
		String[] strArray = new String[10];
		String str1 = str.toUpperCase();
		int index = 0;
		for (int i = 0; i < n - 1; i++) {
			String res = "";
			int k = (int) str1.charAt(i);
			int p = (int) str1.charAt(i + 1);
			int count = 0;
			if (p - k == 1) {

				count = count + 1;
				res = res + str1.charAt(i) + str1.charAt(i + 1);
				strArray[index] = res;
				index++;

			}

		}

		for (int j = 0; j < index; j++) {
			int counter = 1;
			if (strArray[j] != null) {
				for (int k = j + 1; k < index; k++) {

					if (strArray[j].equalsIgnoreCase(strArray[k])) {
						counter++;
						strArray[k] = " ";
					}
				}
				System.out.println(strArray[j] + " " + counter);
				strArray[j] = " ";
			}
			// System.out.println(strArray[j]);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string:");
		String str = sc.nextLine();
		stringHandling(str);

	}

}
