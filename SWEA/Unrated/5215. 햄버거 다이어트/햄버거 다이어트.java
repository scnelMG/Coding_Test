import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) { // 테스트 케이스 입력
			int N = sc.nextInt(); // 들어올 재료 개수
			int L = sc.nextInt(); // 제한 칼로리 값
			int[][] arr = new int[N][2]; // 재료의 점수와 칼로리를 저장하는 배열
			int maxScore = 0; // 최대 점수 저장 변수

			for (int i = 0; i < N; i++) { // 재료의 점수와 칼로리 입력받기
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
			}

			for (int i = 0; i < (1 << N); i++) { // 부분집합 구하기
				int sumKcal = 0; // 부분집합의 칼로리 합계
				int sumScore = 0; // 부분집합의 점수 합계
				for (int j = 0; j < N; j++) { // 부분집합 별로 칼로리 합, 점수 합 구하기
					if ((i & (1 << j)) != 0) {
						sumScore += arr[j][0]; 
						sumKcal += arr[j][1];
					}
				}
				if (sumKcal <= L && sumScore > maxScore) // 칼로리 합이 제한 칼로리 이하이면서, 기존 최대값 보다 크면 
					maxScore = sumScore; // 최대값 경신
			}

			System.out.println("#" + tc + " " + maxScore);

		}
	}

}
