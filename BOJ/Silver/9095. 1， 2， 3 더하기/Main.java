import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < N; tc++) {
			int num = Integer.parseInt(br.readLine());
			System.out.println(solve(num));
		}
	}

	static int solve(int n) {
		int res = 0;

		// 3의 개수(cnt3)는 최대 n/3개까지 가능합니다.
		for (int cnt3 = 0; cnt3 <= n / 3; cnt3++) {

			// 2의 개수(cnt2)는 최대 n/2개까지 가능합니다.
			for (int cnt2 = 0; cnt2 <= n / 2; cnt2++) {

				int sum = (cnt3 * 3) + (cnt2 * 2);

				// 3과 2를 더한 값이 n보다 작거나 같다면, 남은 빈자리는 1로 채웁니다.
				if (sum <= n) {
					int cnt1 = n - sum;
					// 작성하신 순열 계산 메서드를 호출하여 결과에 더합니다.
					res += cal_perm(cnt1, cnt2, cnt3);
				}
			}
		}

		return res;
	}

	static int cal_perm(int cnt1, int cnt2, int cnt3) {
		int res = fac(cnt1 + cnt2 + cnt3) / (fac(cnt1) * fac(cnt2) * fac(cnt3));
		return res;
	}

	static int fac(int num) {
		if (num <= 1)
			return 1;
		return fac(num - 1) * num;
	}
}