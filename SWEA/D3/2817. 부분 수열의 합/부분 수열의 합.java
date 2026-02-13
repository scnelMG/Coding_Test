import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) { // 테스트 케이스 입력
			int N = sc.nextInt(); // 수열의 길이
			int K = sc.nextInt(); // 부분 수열의 합이 되어야하는 값

			int[] arr = new int[N]; // 수열 입력 받는 배열
			int cnt = 0; // 부분 수열의 합이 K랑 같은 경우의 개수

			for (int i = 0; i < N; i++) { // 수열 입력 받기
				arr[i] = sc.nextInt();
			}

			for (int i = 0; i < (1 << N); i++) { // 비트 연산자로 계산 0~ 2의 N승 -1 까지
				int sum = 0; // 부분집합의 합을 계산할 변수
				for (int j = 0; j < N; j++) {
					if ((i & (1 << j)) != 0) { // 0001, 0010, 0100, 1000 이렇게 지나가면서 계산
						// &연산 -> 둘 다 1이면 2^j 도출
						sum += arr[j]; // 부분집합의 원소 값 더하기
					}
				}
				if (sum == K) // 부분집합 합과 K가 같으면 개수 추가
					cnt++;
			}
			System.out.println("#" + tc + " " + cnt);

		}
	}

}
