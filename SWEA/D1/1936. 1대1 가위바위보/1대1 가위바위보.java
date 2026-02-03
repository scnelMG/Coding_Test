import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		if ((a == 1 && b == 3) || (a == 2 && b == 1) || (a == 3 && b == 2)) {
			System.out.println("A");
		} else {
			System.out.println("B");
		}

	}
}