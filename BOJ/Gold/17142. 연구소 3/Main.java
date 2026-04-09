import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, emptyCnt;
	static List<int[]> virus, sel;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] grid;
	static int minV = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 연구소 크기
		M = Integer.parseInt(st.nextToken()); // 활성화 가능한 바이러스 수

		grid = new int[N][N]; // 연구소 정보 저장 배열
		virus = new ArrayList<>(); // 바이러스 위치 저장 리스트
		sel = new ArrayList<>(); // 전체 중 M개의 활성화 대상 바이러스 위치 리스트
		emptyCnt = 0; // 빈 칸 개수 변수 -> 다 감염했는지 확인하는 용도

		// 연구서 상태 정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if (grid[i][j] == 2) // 바이러스인 경우 -> 해당 좌표를 List에 저장
					virus.add(new int[] { i, j });
				else if (grid[i][j] == 0) { // 빈 칸 개수 세기
					emptyCnt++;
				}
			}
		}

		// 빈칸이 없으면 그냥 0 출력하고 끝
		if (emptyCnt == 0) {
			System.out.println(0);
			return;
		}

		// 조합 후 bfs로 계산하는 함수
		comb(0, 0);

		// 갱신이 한 번도 안됨 -> 다 감염시킨 경우가 없었다 -> -1 출력
		if (minV == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else { // 갱신이 됐으면 최소값 출력
			System.out.println(minV);
		}

	}

	static void comb(int idx, int depth) {
		if (depth == M) { // 다 뽑은 경우 -> BFS 진행

			Queue<int[]> q = new ArrayDeque<>();
			// 방문처리를 위한 배열
			boolean[][] visited = new boolean[N][N];

			// 활성화 시키기로 한 바이러스 좌표를 q에 넣음
			for (int i = 0; i < M; i++) {
				int[] tmp = sel.get(i);
				q.add(tmp);
				visited[tmp[0]][tmp[1]] = true; // q에 넣고 방문처리
			}

			int time = 0; // 소요되는 시간
			int goodCnt = 0; // 감염시킨 빈 칸 개수

			while (!q.isEmpty()) {

				// 모든 빈칸을 감염 시켰으면 최소값 갱신
				if (goodCnt == emptyCnt) {
					minV = Math.min(minV, time);
					return;
				}

				// 레벨 단위로 묶어서 bfs 진행
				int size = q.size();
				for (int i = 0; i < size; i++) {
					int[] cur = q.poll(); // 현재 좌표
					int r = cur[0];
					int c = cur[1];

					for (int d = 0; d < 4; d++) { // 네방향 탐색
						int nr = r + dr[d];
						int nc = c + dc[d];

						// 범위 체크
						if (nr < 0 || nc < 0 || nr >= N || nc >= N)
							continue;

						// 방문을 안했고, 해당 칸이 벽이 아니면 -> 해당 칸을 q에 넣고 방문처리하고, 감염개수 늘리기
						if (!visited[nr][nc] && grid[nr][nc] != 1) { // 벽이 아닌 경우에 대해서 -> 빈칸뿐 아니라 바이러스가 있어도 지나갈 수 이씀
							q.add(new int[] { nr, nc }); // q에 넣기
							visited[nr][nc] = true; // 방문처리
							if (grid[nr][nc] == 0)
								goodCnt++; // 감염개수 +1
						}
					}
				}
				time++; // 그 다음 레벨로
			}

		}

		// 조합 구현 -> 바이러스 개수 중 M개 봅기
		for (int i = idx; i < virus.size(); i++) {
			sel.add(virus.get(i)); // i, j가 담긴 배열을 리스트에 저장
			comb(i + 1, depth + 1); //
			sel.remove(sel.size() - 1); // 백트래킹
		}

	}
}
