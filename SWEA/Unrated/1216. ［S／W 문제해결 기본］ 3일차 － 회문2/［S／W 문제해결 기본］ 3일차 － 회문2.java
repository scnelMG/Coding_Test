import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = sc.nextInt();
			int N = 100;

			// 배열에 문자 할당
			char[][] arr = new char[N][N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.next().toCharArray();
			}

			int max_len = 1;

			// 행에서 회문 탐색
			for (int row = 0; row < N; row++) {
				for (int i = 100; i > 1; i--) { // i : 탐색하는 회문 길이
					for (int j = 0; j < N - i + 1; j++) { // j : 길이에 대해서 하나식 옮겨가면서 회문 체크
						Boolean isPal = true;
						for (int k = 0; k < i / 2; k++) {
							if (arr[row][j + k] != arr[row][j + i - 1 - k]) {
								isPal = false;
								break;
							}
						}
						if (isPal && i > max_len) {
							max_len = i;

						}

					}

				}

			}

			// 열에서 회문 탐색
			for (int col = 0; col < N; col++) {
				for (int i = 100; i > 1; i--) { // i : 탐색하는 회문 길이
					for (int j = 0; j < N - i + 1; j++) { // j : 길이에 대해서 하나식 옮겨가면서 회문 체크
						Boolean isPal = true;
						for (int k = 0; k < i / 2; k++) {
							if (arr[j + k][col] != arr[j + i - 1 - k][col]) {
								isPal = false;
								break;
							}
						}
						if (isPal && i > max_len) {
							max_len = i;

						}

					}

				}

			}
			System.out.println("#" + T + " " + max_len);

		}
	}
}