import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] grid = new int[10][10]; // 전체 종이 (10 * 10)
	static List<int[]> ones = new ArrayList<>(); // 1이 적힌 위치가 저장된 리스트(개수가 안정해져있어서 리스트 사용)
	static int[] paperCnt = { 0, 5, 5, 5, 5, 5 }; // 색종이 크기 별 개수 확인 배열 -> 각 크기별로 최대 5개 사용 가능
	static int minV = Integer.MAX_VALUE; // 최소 색종이 개수 저장하는 변수

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 전체 종이 정보 입력 받기
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if (grid[i][j] == 1) { // 1이 적힌 위치를 리스트에 저장
					ones.add(new int[] { i, j });
				}
			}
		}

		// 재귀 시작
		solve(0, 0);

		// 한번도 최소값을 갱신 못했다 -> 모두 덮는 것이 불가능
		if (minV == Integer.MAX_VALUE)
			System.out.println(-1);
		else {
			System.out.println(minV); // 최소값 출력
		}

	}

	//
	static void solve(int idx, int usedCnt) {
		if (usedCnt >= minV)
			return;

		if (idx == ones.size()) { // idx가 1만 담긴 리스트의 길이와 같다 -> 모든 1을 다 탐색했다! -> 마무리
			if (minV > usedCnt) // 최소값 갱신
				minV = usedCnt;
			return;
		}

		// idx번째 1에 접근
		int x = ones.get(idx)[0];
		int y = ones.get(idx)[1];

		if (grid[x][y] == 1) { // 접근한 1이 방문처리 안된거(그냥 1인 경우)
			for (int size = 5; size > 0; size--) { // 사이즈 5 -> 1로 확인
				if (paperCnt[size] > 0 && isGood(x, y, size)) { // 해당 사이즈의 색종이가 남아있고, 그 종이로 딱 1만 덮을 수 있으면
					draw(x, y, size, 2); // 방문처리한다 -> 2로 칠함
					paperCnt[size]--; // 해당 크기의 색종이 사용 처리

					solve(idx + 1, usedCnt + 1); // 사용한 색종이 개수 +1하고 그 다음으로

					paperCnt[size]++; // 재귀 끝났으니 해당 크기의 색종이 사용 복구
					draw(x, y, size, 1); // 방문처리한거 복구 -> 다시 1로 칠하기
				}
			}

		} else if (grid[x][y] == 2) { // 접근한 1이 방문처리가 되었다(2로 표시)
			solve(idx + 1, usedCnt); // 그럼 색종이 안덮고 그 다음 1로
		}

	}

	// 해당 위치부터 size 크기의 색종이를 덮을 수 있는지 확인하는 함수
	static boolean isGood(int x, int y, int size) {
		if (x + size - 1 >= 10 || y + size - 1 >= 10) // 범위 벗어나면 false
			// 색종이 덮는건 x, y 위치부터 덮기 때문에 x + size - 1로 구해야함
			return false;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (grid[x + i][y + j] != 1) { // 1이 아닌 값이 있으면 false
					return false;
				}
			}
		}
		return true; // 무사 통과하면 true
	}

	// state 값으로, x y부터 size 크기만큼 칠하는 함수
	static void draw(int x, int y, int size, int state) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				grid[x + i][y + j] = state;
			}
		}
	}

}