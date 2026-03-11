import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int[] price = new int[4];
	static int[] month = new int[13];
	static int minV;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}

			minV = price[3]; // 최소값 초기화를 1년짜리로
			solve(1, 0);
			System.out.println("#"+tc + " " + minV);
		}
	}

	static void solve(int idx, int cSum) {
		if (idx >= 13) {
			if (cSum < minV)
				minV = cSum;
			return;
		}
		if (month[idx] == 0)
			solve(idx + 1, cSum);
		else {
			solve(idx + 1, cSum + month[idx] * price[0]); // 하루짜리 사용

			solve(idx + 1, cSum + price[1]); // 한달짜리 사용

			solve(idx + 3, cSum + price[2]); // 세달짜리 사용 -> idx + 3
		}

	}
}