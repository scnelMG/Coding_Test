import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static boolean[][][] grid; // 격자 정보 [행][열][충전소 번호]
	static int[][] AP_info;
	static int[] move_A, move_B;
	static int M, A;

	// 이동 방향: 1(상), 2(우), 3(하), 4(좌)
	static int[] dc = { 0, 0, 1, 0, -1 }; // 열 (x)
	static int[] dr = { 0, -1, 0, 1, 0 }; // 행 (y)

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 총 이동시간 입력
			A = Integer.parseInt(st.nextToken()); // 충전소 개수

			// 사용자 A, B의 이동 정보 저장 배열
			move_A = new int[M];
			move_B = new int[M];

			// 사용자 A, B의 이동 정보 입력
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				move_A[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				move_B[i] = Integer.parseInt(st.nextToken());
			}

			// 충전소 정보 입력
			AP_info = new int[A][4];
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				AP_info[i][0] = Integer.parseInt(st.nextToken()); // 열, c, X
				AP_info[i][1] = Integer.parseInt(st.nextToken()); // 행, r, Y
				AP_info[i][2] = Integer.parseInt(st.nextToken()); // 충전 범위
				AP_info[i][3] = Integer.parseInt(st.nextToken()); // 성능
			}

			// A개의 충전소 정보를 저장할 수 있도록 3차원 배열 생성
			// 각 격자에 어떤 충전소의 범위가 겹쳤는지 확인 -> boolean이면 충분
			grid = new boolean[11][11][A];

			// 모든 충전소의 범위 그리기
			for (int ap_num = 0; ap_num < A; ap_num++) {
				draw_area(ap_num);
			}

			// 이동하며 충전량 계산
			int result = move();
			System.out.println("#" + tc + " " + result);
		}
	}

	// 충전소의 범위 그리는 함수
	private static void draw_area(int ap_num) {
		int c = AP_info[ap_num][0]; // x좌표 -> 아 헷갈리네... 기존에 하는 방식이 아니라..
		int r = AP_info[ap_num][1]; // y좌표
		int len = AP_info[ap_num][2]; // 충전 범위

		for (int i = r - len; i <= r + len; i++) {
			for (int j = c - len; j <= c + len; j++) {
				// 지도 밖으로 나가는 범위 패스
				if (i <= 0 || j <= 0 || i > 10 || j > 10)
					continue;

				// 거리가 범위 내에 있다면 true
				if (Math.abs(r - i) + Math.abs(c - j) <= len) {
					grid[i][j][ap_num] = true;
				}
			}
		}
	}

	// 사용자 A, B의 이동 구현
	private static int move() {
		int total = 0; // 최종 return 값
		int r_A = 1, c_A = 1; // A의 출발점
		int r_B = 10, c_B = 10; // B의 출발점

		// 0초부터 M초까지 이동
		for (int t = 0; t <= M; t++) {
			// 현재 위치에서 가능한 최대 충전량 탐색
			total += getMaxCharge(r_A, c_A, r_B, c_B);

			// 다음 위치로 이동
			// 마지막에는 이동할 필요 없음 -> t<M
			if (t < M) {
				r_A += dr[move_A[t]];
				c_A += dc[move_A[t]];
				r_B += dr[move_B[t]];
				c_B += dc[move_B[t]];
			}
		}
		return total;
	}

	// 각 격자 별 최대값을 구하는 함수
	private static int getMaxCharge(int rA, int cA, int rB, int cB) {
		int maxV = 0;

		// 모든 영역에 대한 경우의 수 계산
		for (int i = 0; i < A; i++) {
			for (int j = 0; j < A; j++) {
				// 각 사용자가 특정 충전소 번호(i, j)의 영역 안에 있는지 확인
				// A * A 경우의 수 보기
				boolean a_in = grid[rA][cA][i];
				boolean b_in = grid[rB][cB][j];

				int curV = 0;

				// a, b 모두 충전소 영역에 있는 경우에
				if (a_in && b_in) {
					if (i == j) {
						// 같은 충전소인 경우 하나 값만
						curV = AP_info[i][3];
					} else {
						// 다른 충전소인 경우 둘 다 더함
						curV = AP_info[i][3] + AP_info[j][3];
					}
				} else if (a_in) { // a만 충전소 영역에 있는 경우
					curV = AP_info[i][3];
				} else if (b_in) { // b만 충전소 영역에 있는 경우
					curV = AP_info[j][3];
				}

				// 최대값 갱신
				maxV = Math.max(maxV, curV);
			}
		}
		return maxV;
	}
}