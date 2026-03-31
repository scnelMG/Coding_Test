import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] height = new int[N];
		st = new StringTokenizer(br.readLine());
		int maxV = -1;
		for (int i = 0; i < N; i++) {
			height[i] = Integer.parseInt(st.nextToken());
			if (maxV < height[i])
				maxV = height[i];
		}

		int res = -1;
		for (int i = maxV; i >= 0; i--) {
			int sum = 0;
			for (int h = 0; h < N; h++) {
				if (height[h] - i > 0)
					sum += (height[h] - i);
			}

			if (sum >= M) {
				res = i;
				break;
			}

		}

		System.out.println(res);

	}
}