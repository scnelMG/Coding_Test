import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Arrays.sort(arr, (o1, o2) -> {
			if (o1[1] == o2[1]) {
				return Integer.compare(o1[0], o2[0]);
			}
			return Integer.compare(o1[1], o2[1]);
		});

		int cnt = 0;
		int lastEnd = -1;

		for (int i = 0; i < N; i++) {
			int start = arr[i][0];
			int end = arr[i][1];

			if (start > lastEnd) {
				cnt++;
				lastEnd = end;
			}
		}
		System.out.println(cnt);

	}

}