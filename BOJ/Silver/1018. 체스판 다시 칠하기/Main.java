import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] grid = new char[N][M];

		for (int i = 0; i < N; i++) {
			grid[i] = br.readLine().toCharArray();
		}

		int minV = Integer.MAX_VALUE;

		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				int cnt = 0;

				// 시작점을 W이라고 가정
				for (int r = 0; r < 8; r++) {
					for (int c = 0; c < 8; c++) {
						// r과 c의 합이 짝수면 시작점과 같은 색(W), 홀수면 다른 색(B)
						if ((r + c) % 2 == 0) {
							if (grid[r + i][c + j] != 'W')
								cnt++;
						} else {
							if (grid[r + i][c + j] != 'B')
								cnt++;
						}
					}
				}

				// W로 시작 경우와 B로 시작 경우 중 더 작은 값을 선택
				cnt = Math.min(cnt, 8 * 8 - cnt);

				if (cnt < minV)
					minV = cnt;

			}
		}

		System.out.println(minV);
	}
}