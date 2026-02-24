package 박민규.CodeTree.쌓인숫자의순차적이동;

import java.util.*;

public class Main {
	static int N, M;
	// 3차원 리스트 구조: 행 -> 열 -> 쌓인 숫자들
	static ArrayList<ArrayList<ArrayList<Integer>>> grid = new ArrayList<>();
	// 숫자의 위치를 빠르게 찾기 위한 좌표 배열
	static int[] posR, posC;

	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		posR = new int[N * N + 1];
		posC = new int[N * N + 1];

		// 1. 3차원 리스트 초기화 및 데이터 입력
		for (int i = 0; i < N; i++) {
			grid.add(new ArrayList<>()); // 행 추가
			for (int j = 0; j < N; j++) {
				grid.get(i).add(new ArrayList<>()); // 열 추가
				int num = sc.nextInt();
				grid.get(i).get(j).add(num); // 숫자 추가
				posR[num] = i;
				posC[num] = j;
			}
		}

		// 2. 이동 명령 수행
		for (int i = 0; i < M; i++) {
			int targetNum = sc.nextInt();
			move(targetNum);
		}

		// 3. 결과 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ArrayList<Integer> cell = grid.get(i).get(j);
				if (cell.isEmpty()) {
					sb.append("None\n");
				} else {
					// 가장 위(리스트 끝)부터 아래(리스트 앞) 방향으로 출력
					for (int k = cell.size() - 1; k >= 0; k--) {
						sb.append(cell.get(k)).append(" ");
					}
					sb.append("\n");
				}
			}
		}
		System.out.print(sb.toString());
	}

	static void move(int num) {
		int r = posR[num];
		int c = posC[num];

		// 현재 숫자가 있는 칸의 스택
		ArrayList<Integer> currentCell = grid.get(r).get(c);

		int maxVal = -1;
		int targetR = -1;
		int targetC = -1;

		// 8방향 탐색해서 인접한 칸 중 가장 큰 숫자가 있는 칸 찾기
		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				ArrayList<Integer> neighbor = grid.get(nr).get(nc);
				for (int val : neighbor) {
					if (val > maxVal) {
						maxVal = val;
						targetR = nr;
						targetC = nc;
					}
				}
			}
		}

		// 이동할 대상 칸이 있다면
		if (targetR != -1) {
			int idx = currentCell.indexOf(num);

			// 이동할 숫자들 (num부터 그 위까지) 따로 복사
			List<Integer> toMove = new ArrayList<>(currentCell.subList(idx, currentCell.size()));

			// 기존 칸에서 제거
			// 뒤에서부터 지워야 인덱스 오류가 안 납니다.
			int removeCount = currentCell.size() - idx;
			for (int i = 0; i < removeCount; i++) {
				currentCell.remove(currentCell.size() - 1);
			}

			// 새로운 칸에 통째로 추가 및 위치 정보 갱신
			for (int movingNum : toMove) {
				grid.get(targetR).get(targetC).add(movingNum);
				posR[movingNum] = targetR;
				posC[movingNum] = targetC;
			}
		}
	}
}