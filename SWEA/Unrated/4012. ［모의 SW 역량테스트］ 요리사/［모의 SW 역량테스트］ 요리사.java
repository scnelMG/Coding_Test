import java.util.Scanner;

public class Solution {
	static int N;
	static int[][] grid; // 시너지 정보를 저장할 2차원 배열
	static boolean[] isSelected;
	static int min_v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 수

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			grid = new int[N][N]; // 시너지 저장 배열
			isSelected = new boolean[N]; // A음식 재료인지 체크할 배열 (true: A, false: B)
			min_v = 1000000000; // 최소값 저장하는 변수

			for (int i = 0; i < N; i++) { // 시너지 입력 받기
				for (int j = 0; j < N; j++) {
					grid[i][j] = sc.nextInt();
				}
			}

			// 조합 시작
			combination(0, 0);

			System.out.println("#" + tc + " " + min_v);
		}
	}

	public static void combination(int idx, int sidx) {
		// 종료 부분
		// N/2개를 모두 뽑았을 -> 선택 완료
		// 그럼 시너지 계산하기
		if (sidx == N / 2) {
			int sumA = 0; // A 시너지
			int sumB = 0; // B 시너지

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) { // 시너지 배열 돌면서
					// 자기 자신과의 시너지는 없으므로 패스 (문제에서 0으로 주어짐)
					if (i == j)
						continue;

					// i(세로줄)와 j(가로줄) 재료가 모두 A에 선택됐으면(모두 true) -> A음식의 시너지 계산
					if (isSelected[i] && isSelected[j]) {
						sumA += grid[i][j];
					}

					// i(세로줄)와 j(가로줄) 재료가 모두 B에 선택됐으면(모두 false) -> B음식의 시너지 계산
					else if (!isSelected[i] && !isSelected[j]) {
						sumB += grid[i][j];
					}
				}
			}

			// A, B 시너지의 절댓값 계산
			int res = Math.abs(sumA - sumB);

			// 최솟값 갱신
			if (res < min_v)
				min_v = res;

			return;
		} // 선택 완료 조건문 끝

		// 더 이상 고려할 식재료가 없을 때
		if (idx == N)
			return;

		// 재귀 부분
		// 현재 인덱스(idx)의 재료를 A음식으로 선택
		isSelected[idx] = true;
		combination(idx + 1, sidx + 1);

		// 현재 인덱스(idx)의 재료를 A음식으로 선택 안함 -> B음식
		isSelected[idx] = false;
		combination(idx + 1, sidx);
	}
}