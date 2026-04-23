import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			int maxV = -1; // 최대 높이 저장 변수

			// 길이 저장 배열
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				maxV = Math.max(maxV, arr[i]);
			}

			int odd = 0; // 1이 필요한 총 횟수 (홀수 날)
			int even = 0; // 2가 필요한 총 횟수 (짝수 날)

			for (int i = 0; i < N; i++) { // 1, 2 개수 구하기
				int diff = maxV - arr[i];
				even += diff / 2;
				odd += diff % 2;
			}

			// 2의 비중이 너무 크면, 2 하나를 1 두 개로 쪼개어 균형을 맞춤
			// 2가 1보다 2이상 많으면 쪼개는게 나음
			while (even >= odd + 2) {
				even--;
				odd += 2;
			}

			
			int res = 0;
			if (odd > even) { // 1이 더 많은 경우
				res = odd * 2 - 1; // 1 2 1 _ 1
			} else if (even > odd) { // 2가 많은 경우
				res = even * 2;	// 1 2 _ 2
			} else { // 같은 경우 -> 1 2 1 2
				res = odd * 2;
			}

			System.out.println("#" + tc + " " + res);
		}
	}
}