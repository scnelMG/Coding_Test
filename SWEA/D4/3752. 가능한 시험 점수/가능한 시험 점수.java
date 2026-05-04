import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int maxV = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				maxV += arr[i];
			}

			boolean[] dp = new boolean[maxV + 1];

			dp[0] = true;  // 시작점 역할
			int cnt = 1; // 0점도 하나의 경우의 수

			for (int i = 0; i < N; i++) { // 각 문제에 대해서
				for (int j = maxV - arr[i]; j >= 0; j--) { // 뒤에서 부터 돈다 -> 앞에서 부터 하면 똑같은 문제를 여러번 사용하기 때문
                    // j + arr[i]가 maxV를 안넘도록 시작 값을 설정(넘으면 dp배열에서 outofbound 에러)
					if (dp[j] && !dp[j + arr[i]]) { // j 점을 만들 수 있고  j점에 해당 문제의 점수를 추가한 것이 체크 안되어 있으면
						dp[j + arr[i]] = true; // j 점에 해당 문제의 점수를 추가한 점수도 가능 체크
						cnt++; // 개수 세기
					}
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}