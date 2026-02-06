import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		char[] A = s1.toCharArray();
		char[] B = s2.toCharArray();

		int[][] dp = new int[A.length + 1][B.length + 1];
		for (int i = 1; i < A.length + 1; i++) {
			for (int j = 1; j < B.length + 1; j++) {
				if (A[i - 1] == B[j - 1]) { // 문자가 같으면
					dp[i][j] = dp[i - 1][j - 1] + 1; // dp 테이블의 대각선 왼쪽 위 값 가져오기
					// 그 직전까지 같았던 개수
					// (그 직전까지 같았다면,a, b 문자열 각각 동시에 하나씩 증가하면서 비교하기 때문)
				} else { // 문자가 같지 않았다면
					// 그 이전까지 같았던 개수 중 최댓값 가져오기
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		System.out.println(dp[A.length][B.length]);
	}
}
