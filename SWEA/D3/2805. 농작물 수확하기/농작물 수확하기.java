import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) { // 테스트 케이스 입력
			int N = sc.nextInt();
			int[][] grid = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = sc.next();
				for (int j = 0; j < N; j++) {
					grid[i][j] = s.charAt(j) - '0';
				}
			}

			int mid = N / 2; // 배열 크기의 중간값
			int res = 0; // 결과 더하는 변수
			for (int i = 0; i < mid; i++) { // 중간 전까지 하나씩 개수 늘리면서 더하기
				for (int j = mid - i; j <= mid + i; j++) {
					res += grid[i][j];
				}
			}
			for (int i = mid; i < N; i++) { // 중간값일 때는 전체 길이로, 그 뒤로부터는 하나씩 줄이면서 더하기
				for (int j = mid - (N - 1 - i); j <= mid + (N - 1 - i); j++) {
					res += grid[i][j];
				}
			}

			System.out.println("#" + tc + " " + res);

		}
	}

}
