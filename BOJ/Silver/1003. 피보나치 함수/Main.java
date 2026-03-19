import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	static int cnt0, cnt1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int[] zero = new int[41];
		int[] one = new int[41];

		zero[0] = 1;
		zero[1] = 0;
		one[0] = 0;
		one[1] = 1;
		for (int i = 2; i <= 40; i++) {
			zero[i] = zero[i - 1] + zero[i - 2];
			one[i] = one[i - 1] + one[i - 2];
		}

		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(zero[N] + " " + one[N]);
		}
	}

}