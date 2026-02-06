import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {

			int T = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println("#" + test_case + " " + myPow(a, b));

		}
	}

	static int myPow(int a, int b) {
		if (b < 1) { // 0 이하일때는 1 리턴 -> 재귀 끝
			return 1;
		}
		return a * myPow(a, b - 1);
	}
}