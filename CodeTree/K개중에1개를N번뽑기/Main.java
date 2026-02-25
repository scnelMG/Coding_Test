package 박민규.CodeTree.K개중에1개를N번뽑기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int K;
	static int N;
	static int[] arr;
	static int[] res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		arr = new int[K];
		res = new int[N];
		for (int i = 0; i < K; i++) {
			arr[i] = i + 1;
		}
		permutation(0);

	}

	public static void permutation(int depth) {
		if (depth == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < K; i++) {
			res[depth] = arr[i];
			permutation(depth + 1);
		}
	}
}
