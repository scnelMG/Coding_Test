import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) { // 테스트 케이스 입력
			int N = sc.nextInt();
			int M = sc.nextInt();
			int max_v, min_v; // N과 M 중 뭐가 큰지 확인
			if (N >= M) {
				max_v = N; // 둘 중 뭐가 큰 값이고 작은 값인지 저장해두기
				min_v = M;
			} else {
				max_v = M;
				min_v = N;
			}
			int[] A = new int[N]; // N개 만큼 저장받는 배열 A
			int[] B = new int[M]; // M개 만큼 저장받는 배열 B

			for (int i = 0; i < N; i++) { // 값 저장
				A[i] = sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				B[i] = sc.nextInt();
			}

			int res = 0; // 최대값 저장 변수
			for (int i = 0; i <= (max_v - min_v); i++) { // 한칸씩 이동하면서 곱하기
				int sum = 0; // 각 요소끼리 곱한 결과 더하는 변수
				if (N >= M) { // N이 M보다 크면 A의 배열의 값을 한칸씩 움직임
					for (int j = 0; j < min_v; j++)
						sum += A[i + j] * B[j];
				} else { // M이 N보다 크면 B의 배열의 값을 한칸씩 움직임
					for (int j = 0; j < min_v; j++)
						sum += B[i + j] * A[j];
				}
				if (sum > res) // 최대값 구하기
					res = sum;
			}
			System.out.println("#" + tc + " " + res);

		}
	}

}
