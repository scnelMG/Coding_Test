import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int res = 0;
		for (int i = 1; i<=N; i++) {
			res+= i;
		}
		System.out.println(res);
	}
}