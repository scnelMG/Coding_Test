import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		if (N == K) {
			System.out.println(0);
			System.out.println(1);
			return;
		}

		int[] position = new int[100001];
		Queue<Integer> q = new ArrayDeque<>();

		q.add(N);
		int cnt = 1;
		position[N] = cnt;
		int ways = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			cnt++;
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				int[] nexts = { cur + 1, cur - 1, cur * 2 };
				for (int next : nexts) {
					if (next < 0 || next > 100000)
						continue;

					if (next == K)
						ways++;

					if (position[next] == 0 || position[next] == cnt) {
						position[next] = cnt;
						q.add(next);
					}
				}
			}
			if (ways > 0)
				break;

		}
		System.out.println(cnt - 1);
		System.out.println(ways);
	}
}