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

		// 이진 탐색
		int low = 0;
		int high = maxV;
		int res = 0;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			long sum = 0;

			for (int i = 0; i < N; i++) {
				if (height[i] - mid > 0)
					sum += (height[i] - mid);
			}

			if (sum >= M) {
				res = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		System.out.println(res);

	}
}