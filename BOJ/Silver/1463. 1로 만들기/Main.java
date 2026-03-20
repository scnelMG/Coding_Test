import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[] isVisited = new boolean[1000001];

		Queue<Integer> q = new ArrayDeque<>();
		q.add(N);
		isVisited[N] = true;
		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			boolean isGood = false;

			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				if (cur == 1) {
					isGood = true;

					break;
				}

				if (cur % 3 == 0 && !isVisited[cur / 3]) {
					isVisited[cur / 3] = true;
					q.add(cur / 3);
				}

				if (cur % 2 == 0 && !isVisited[cur / 2]) {
					isVisited[cur / 2] = true;
					q.add(cur / 2);
				}
				if (!isVisited[cur - 1]) {
					isVisited[cur - 1] = true;
					q.add(cur - 1);
				}
			}

			if (isGood) {
				System.out.println(cnt);
				break;
			}
			cnt++;

		}
	}
}