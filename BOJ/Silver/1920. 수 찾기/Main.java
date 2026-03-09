import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr1 = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int targetNum = Integer.parseInt(st.nextToken());
			boolean isGood = false;
			for (int j = 0; j < N; j++) {
				if (arr1[j] == targetNum) {
					isGood = true;
				}
			}
			if (isGood)
				System.out.println(1);
			else {
				System.out.println(0);
			}

		}

	}

}
