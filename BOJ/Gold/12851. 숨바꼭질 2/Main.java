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

		while (!q.isEmpty()) {
			int size = q.size();
			cnt++;
			boolean isFind = false;
			for (int i = 0; i < size; i++) {
				int cur = q.poll();

				if (cur + 1 <= 100000) {
					if (cur + 1 == K)
						isFind = true;
					if (position[cur + 1] == 0 || position[cur + 1] == cnt) {
						position[cur + 1] = cnt;
						q.add(cur + 1);
					}
				}
				if (cur - 1 >= 0) {
					if (cur - 1 == K)
						isFind = true;
					if (position[cur - 1] == 0 || position[cur - 1] == cnt) {
						position[cur - 1] = cnt;
						q.add(cur - 1);
					}
				}
				if (cur * 2 <= 100000) {
					if (cur * 2 == K)
						isFind = true;
					if (position[cur * 2] == 0 || position[cur * 2] == cnt) {
						position[cur * 2] = cnt;
						q.add(cur * 2);
					}
				}

			}

			if (isFind)
				break;

		}
		System.out.println(cnt - 1);
		int ways = 0;
		while (!q.isEmpty()) {
			if (q.poll() == K) {
				ways++;
			}
		}
		System.out.println(ways);
	}
}