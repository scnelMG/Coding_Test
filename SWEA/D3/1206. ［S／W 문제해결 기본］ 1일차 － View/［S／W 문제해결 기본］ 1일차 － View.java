import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			int res = 0;

			for (int i = 2; i < N - 2; i++) {
				int max_neighbor = arr[i - 1];
				if (arr[i - 2] > max_neighbor)
					max_neighbor = arr[i - 2];
				if (arr[i + 1] > max_neighbor)
					max_neighbor = arr[i + 1];
				if (arr[i + 2] > max_neighbor)
					max_neighbor = arr[i + 2];

				if (arr[i] - max_neighbor > 0)
					res += (arr[i] - max_neighbor);

			}
			System.out.println("#" + test_case + " " + res);
		}
	}
}