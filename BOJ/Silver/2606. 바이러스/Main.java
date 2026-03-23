import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] adjArr = new int[N + 1][N + 1];
		int comNum = Integer.parseInt(br.readLine());
		for (int i = 0; i < comNum; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjArr[a][b] = 1;
		}
		Queue<Integer> q = new ArrayDeque<>();
		q.add(1);
		int cnt = 0;

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 1; i <= N; i++) {
				if (adjArr[cur][i] == 1) {
					q.add(i);
					cnt++;
					for (int j = 1; j <= N; j++) {
						adjArr[j][i] = 0;
					}
				}
			}

		}
		System.out.println(cnt);

	}
}