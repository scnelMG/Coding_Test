import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N, X, M;
	static int[][] info;
	static int[] arr;
	static int[] res;
	static int maxV;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N];
			res = new int[N];
			info = new int[M][3];
			maxV = -1;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int l = Integer.parseInt(st.nextToken()) - 1;
				int r = Integer.parseInt(st.nextToken()) - 1;
				int s = Integer.parseInt(st.nextToken());
				info[i] = new int[] { l, r, s };
			}

			solve(0, 0);

			if (maxV == -1) {
				System.out.println("#" + tc + " -1");
			} else {
				System.out.print("#" + tc + " ");
				for (int i = 0; i < N; i++) {
					System.out.print(res[i] + " ");
				}
				System.out.println();
			}
			

		}

	}

	static void solve(int idx, int cSum) {
		if (idx == N) { // 모든 군집의 개수를 다 정했으면
			if (check()) { // 조건 만족하는지 확인
				if (cSum > maxV) { // 조건 만족하고, 해당 경우의 합이 최대를 갱신하면
					maxV = cSum; // 최대값 갱신
					for (int i = 0; i < N; i++) {
						res[i] = arr[i]; // 결과 군집 정보 갱신
					}
				}
			}
			return;
		}

		for (int i = 0; i <= X; i++) { // 0부터 군집이 가질 수 있는 최대값 X까지 반복문 돌기
			arr[idx] = i;
			solve(idx + 1, cSum + i);
		}

	}

	// 조건 만족하는지 확인하는 함수
	static boolean check() {
		for (int i = 0; i < M; i++) {
			int l = info[i][0]; // 시작 군집
			int r = info[i][1]; // 종료 군집
			int s = info[i][2]; // l~s까지의 만족해야하는 합

			int sum = 0; // arr에 담긴 실제 합 구하기
			for (int j = l; j <= r; j++) {
				sum += arr[j];
			}
			if (sum != s) // 조건 속 합과 실제 합이 다르면 false
				return false;

		}
		return true;
	}
}