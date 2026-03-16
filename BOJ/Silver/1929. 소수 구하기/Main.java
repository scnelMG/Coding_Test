import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt();
		int N = sc.nextInt();

		boolean[] isNotPrime = new boolean[N + 1];

		// 0과 1은 소수가 아님
		isNotPrime[0] = true;
		isNotPrime[1] = true;

		// 에라토스테네스의 체 로직
		// N의 제곱근까지만 확인해도 충분
		for (int i = 2; i * i <= N; i++) {
			if (!isNotPrime[i]) {
				// i가 소수라면, i의 배수들을 모두 true(소수 아님)로 설정
				for (int j = i * i; j <= N; j += i) {
					isNotPrime[j] = true;
				}
			}
		}

		// M부터 N까지 소수(false)인 것만 출력
		StringBuilder sb = new StringBuilder();
		for (int i = M; i <= N; i++) {
			if (!isNotPrime[i]) {
				sb.append(i).append("\n");
			}
		}
		System.out.print(sb);

	}
}