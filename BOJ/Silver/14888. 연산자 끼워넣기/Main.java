import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int N, plus, minus, mul, div;
	static int minV = Integer.MAX_VALUE;
	static int maxV = -1 * Integer.MAX_VALUE;
	static int[] numArr, opers;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numArr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		plus = Integer.parseInt(st.nextToken());
		minus = Integer.parseInt(st.nextToken());
		mul = Integer.parseInt(st.nextToken());
		div = Integer.parseInt(st.nextToken());
		opers = new int[] { plus, minus, mul, div };

		solve(1, numArr[0]);
		System.out.println(maxV);
		System.out.println(minV);

	}

	static void solve(int idx, int res) {
		if (idx == N) {
			if (res < minV)
				minV = res;
			if (res > maxV)
				maxV = res;
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (opers[i] == 0)
				continue;
			opers[i]--;
			switch (i) {
			case 0:
				solve(idx + 1, res + numArr[idx]);
				break;
			case 1:
				solve(idx + 1, res - numArr[idx]);
				break;
			case 2:
				solve(idx + 1, res * numArr[idx]);
				break;
			case 3:
				solve(idx + 1, res / numArr[idx]);
				break;
			}
			opers[i]++;
		}
	}
}