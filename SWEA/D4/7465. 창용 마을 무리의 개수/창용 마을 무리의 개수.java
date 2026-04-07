import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int[] p;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			// 부모 배열 초기화
			p = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				p[i] = i;
			}

			// M개의 관계 입력 받기
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				union(x, y);
			}
			
			// 그룹 개수 세기 -> 대표 개수를 세자!
			// 부모가 자기자신 -> 대표!
			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				if (p[i] == i)
					cnt++;
			}
			System.out.println("#" + tc + " " + cnt);

		}
	}

	static void union(int x, int y) {
		p[findSet(y)] = findSet(x);

	}

	static int findSet(int x) {
		if (x != p[x]) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}

}
