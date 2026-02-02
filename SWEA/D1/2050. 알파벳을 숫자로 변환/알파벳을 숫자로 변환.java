import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		String st = sc.next();
		for (int i = 0; i < st.length(); i++) {
			System.out.print((int) st.charAt(i) - 64 + " ");

		}

	}
}