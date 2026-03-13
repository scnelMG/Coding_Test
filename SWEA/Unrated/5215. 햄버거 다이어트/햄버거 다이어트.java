import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			int[] dp = new int[L + 1];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int score = Integer.parseInt(st.nextToken());
				int kcal = Integer.parseInt(st.nextToken());

				
				// 한번만 사용하기 위해 뒤에서 부터 채우기
				// 앞에서 부터 채우면 똑같은 걸로 계속 채우는 경우 발생
				for (int k = L; k >= kcal; k--) {
					dp[k] = Math.max(dp[k], dp[k - kcal] + score);
				}
			}

			System.out.println("#" + tc + " " + dp[L]);
		}

	}

}
