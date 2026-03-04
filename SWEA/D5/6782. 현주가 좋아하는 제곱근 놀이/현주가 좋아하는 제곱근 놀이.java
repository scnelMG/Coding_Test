import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			long N = sc.nextLong();
			long cnt = 0;

			while (N > 2) {
				if (Math.sqrt(N) == (long) Math.sqrt(N)) { // 제곱수인지 확인
					N = (long) Math.sqrt(N); // 제곱수 이면 루트한 값으로 대체
					cnt++;
				} else { // N이 제곱수가 아니라면
					// N보다 큰 제곱수 중 가장 작은 수를 찾기
					long nextNum = (long) Math.sqrt(N) + 1;
					nextNum *= nextNum;
					cnt += (nextNum - N); // 그 제곱수에 도달하기 위해 필요한 연산 횟수
					N = nextNum; // 해당 재곱수로 갱신
				}

			}
			System.out.println("#" + tc + " " + cnt);

		}
	}
}
