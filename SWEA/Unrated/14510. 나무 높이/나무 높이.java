import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] heights = new int[N];

			int maxV = -1; // 입력 받으면서 최대값 구하기
			for (int i = 0; i < N; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
				if (maxV < heights[i])
					maxV = heights[i];
			}

			// 1의 개수랑 2의 개수 세기
			int cnt1 = 0;
			int cnt2 = 0;
			for (int i = 0; i < N; i++) {
				int targetNum = maxV - heights[i]; // 최대값과 각 원소의 값 차이
				cnt2 += targetNum / 2; // 일단 다 2로
				cnt1 += targetNum % 2; // 2로 안되는거를 1로
			}

			// 2가 1보다 2개 이상 많을 때만 쪼개는게 이득
			// 0 2 0 2 0 2 (1 : 0개, 2 : 3개)
			// 1 2 1 2 -> 아래처럼바꾸는게 이득
			// 1 2 0 2 -> (1 : 1개, 2 : 2개)
			// 1 2 1 0 1 -> 손해

			while (cnt2 >= cnt1 + 2) {
				cnt2--;
				cnt1 += 2;
			}

			int days = 0;

			// 1의 개수가 많으면 -> 1의 개수 * 2 -1
			// 1 1 1 2 -> 1 2 1 0 1
			if (cnt1 > cnt2)
				days = cnt1 * 2 - 1;
			// 2의 개수가 많거나 같으면 -> 2의 개수 * 2
			// 1 1 2 2 2 -> 1 2 1 2 0 2
			else
				days = cnt2 * 2;

			System.out.println("#" + tc + " " + days);

		}

	}
}
