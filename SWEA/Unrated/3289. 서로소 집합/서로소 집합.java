import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] p;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			p = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				p[i] = i;
			}

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (op == 0) {
					union(a, b);
				} else {
					sb.append(isInclude(a, b));
				}
			}
			System.out.println("#" + tc + " " + sb.toString());
		}
	}

	static void union(int a, int b) {
		p[findSet(b)] = findSet(a);
	}

	static int isInclude(int a, int b) {
		if (findSet(a) == findSet(b)) {
			return 1;
		}
		return 0;

	}

	static int findSet(int x) {
		if (x != p[x])
			p[x] = findSet(p[x]);
		return p[x];
	}

}
