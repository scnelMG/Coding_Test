import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N;
		N = sc.nextInt();
		int res = 0;
		while (N > 0) {
			res += N % 10;
			N /= 10;
		}
		System.out.println(res);

	}
}
