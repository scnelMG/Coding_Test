import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String res;

		for (int test_case = 1; test_case <= T; test_case++) {
			String date = sc.next();
			int y = Integer.parseInt(date.substring(0, 4));
			int m = Integer.parseInt(date.substring(4, 6));
			int d = Integer.parseInt(date.substring(6, 8));
			if (m > 12 || m < 0)
				res = "-1";

			if (d > days[m] || d < 0)
				res = "-1";
			else {
				res = date.substring(0, 4) + "/" + date.substring(4, 6) + "/" + date.substring(6, 8);
			}
			System.out.println("#" + test_case + " " + res);

		}
	}
}