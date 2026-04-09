import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int[][] film;
	static int D, W, K, ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			film = new int[D][W];

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ans = K;

			makeFilm(0, 0);

			System.out.println("#" + tc + " " + ans);
		}
	}

	static void makeFilm(int idx, int cnt) {
		if (cnt >= ans)
			return;

		if (idx == D) {
			if (test()) {
				ans = Math.min(ans, cnt);
			}
			return;
		}

		// 원본 복사
//		int[] tmp = film[idx]; // 얕은복사 -> 이러면 곤란...
		int[] tmp = new int[W];
		for (int j = 0; j < W; j++) {
			tmp[j] = film[idx][j];
		} // 깊은 복사

		// 주입X
		makeFilm(idx + 1, cnt);

		// idx자리에 약품 A 주입
		for (int j = 0; j < W; j++) {
			film[idx][j] = 0;
		}
		makeFilm(idx + 1, cnt + 1);

		// idx자리에 약품 B 주입
		for (int j = 0; j < W; j++) {
			film[idx][j] = 1;
		}
		makeFilm(idx + 1, cnt + 1);

		// 원상 복구
		for (int j = 0; j < W; j++) {
			film[idx][j] = tmp[j];
		}

		// film[idx] = tmp; // 이거 가능

	}

	static boolean test() {
		// 열 고정, 행 증가시키면서 검사 K이상
		for (int c = 0; c < W; c++) {
			int cnt = 1; // 연속된 값
			boolean isOkay = false;
			for (int r = 1; r < D; r++) {
				if (film[r][c] == film[r - 1][c])
					cnt++;
				else
					cnt = 1;

				if (cnt >= K) {
					isOkay = true;
					break;
				}
			}
//			isOkay -> false
			if (!isOkay)
				return false; // 해당 열은 테스트 기준을 통과 못해서 무의미
		}
		return true;
	}
}