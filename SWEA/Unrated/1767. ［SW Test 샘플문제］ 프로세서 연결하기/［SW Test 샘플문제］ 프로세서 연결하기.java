import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
	static int[][] grid;
	static List<int[]> list = new ArrayList<>();
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, minLength, maxCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			grid = new int[N][N];
			list = new ArrayList<>();

			for (int i = 0; i < N; i++) { // 격자 속 정보 입력
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
					if (!(i == 0 || j == 0 || i == N - 1 || j == N - 1)) { // 모서리가 아니고,
						if (grid[i][j] == 1) { // 코어이면, 그 좌표를 List에 저장ㄴ
							list.add(new int[] { i, j });
						}
					}
				}
			}
			// 코어 개수 초기화
			maxCnt = -1;
			// 최소 길이 초기화
			minLength = Integer.MAX_VALUE;
			solve(0, 0, 0);
			System.out.println("#" + tc + " " + minLength);
		}

	}

	static void solve(int idx, int coreCnt, int totalLength) {
		if (coreCnt + (list.size() - idx) < maxCnt) { // 최대값과 비교해서, 현재 나머지 모든 코어를 연결해도 최대값을 못 넘으면 가지치기
			return;
		}

		if (idx == list.size()) {
			if (coreCnt > maxCnt) { // 코어 개수 최대 확인
				maxCnt = coreCnt;
				minLength = totalLength; // 코어 개수가 최대값을 갱신했으면, 그 때의 길이로 최소 길이 변경
			} else if (coreCnt == maxCnt) { // 코어 개수가 같을 땐, 최소 길이 갱신
				if (totalLength < minLength) {
					minLength = totalLength;
				}
			}
			return;
		}

		for (int d = 0; d < 4; d++) {
			int r = list.get(idx)[0]; // idx번째의 코어 좌표
			int c = list.get(idx)[1];
			int length = 0; // 그일 전선의 길이
			boolean isOkay = true; // 전선을 그을 수 있는지 확인
			while (true) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N) { // 격자 밖이면 연결 완
					break;
				}
				if (grid[nr][nc] != 0) { // 그 다음이 빈칸이 아니면 회로를 그을 수 없음
					isOkay = false;
					break;
				}
				length++; // 전선 길이 + 1
				r = nr; // 그다음으로 진행
				c = nc;
			}

			if (isOkay) { // 연결이 됐으면
				draw(d, length, idx); // 격자에 표시
				totalLength += length; // 전체 길이에 추가
				coreCnt++; // 코어 개수 추가
			}

			solve(idx + 1, coreCnt, totalLength);

			// 다시 원상태로
			if (isOkay) {
				remove_draw(d, length, idx);
				coreCnt--;
				totalLength -= length;
			}
		}

	}

	static void draw(int d, int length, int idx) {
		int r = list.get(idx)[0];
		int c = list.get(idx)[1];
		for (int i = 1; i <= length; i++) {
			grid[r + i * dr[d]][c + i * dc[d]] = 2;
		}

	}

	static void remove_draw(int d, int length, int idx) {
		int r = list.get(idx)[0];
		int c = list.get(idx)[1];
		for (int i = 1; i <= length; i++) {
			grid[r + i * dr[d]][c + i * dc[d]] = 0;
		}

	}

}