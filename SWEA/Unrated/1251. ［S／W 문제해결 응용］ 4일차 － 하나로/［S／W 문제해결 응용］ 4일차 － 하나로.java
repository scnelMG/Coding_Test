import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine().trim());

			// x, y 좌표 저장 배열
			long[] x = new long[N];
			long[] y = new long[N];

			// x 좌표 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				x[i] = Long.parseLong(st.nextToken());
			}

			// y 좌표 입력
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				y[i] = Long.parseLong(st.nextToken());
			}

			// 세율 E 입력
			double E = Double.parseDouble(br.readLine());

			// 모든 가능한 간선 생성 (2차원 배열 사용)
			// 간선의 총 개수: N * (N - 1) / 2
			int edgeCount = N * (N - 1) / 2;
			long[][] edges = new long[edgeCount][3];
			int idx = 0;

			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					// 거리의 제곱(L^2) 계산
					long distSq = (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]);
					edges[idx][0] = i; // from
					edges[idx][1] = j; // to
					edges[idx][2] = distSq; // cost
					idx++;
				}
			}

			// 가중치(cost) 기준으로 오름차순 정렬 (람다식 활용)
			Arrays.sort(edges, new Comparator<long[]>() {
				@Override
				public int compare(long[] a, long[] b) {
					// a[2]와 b[2]는 각각 두 간선의 가중치(cost)
					return Long.compare(a[2], b[2]);
				}
			});

			// 부모 정보 배열 초기화
			p = new int[N];
			for (int i = 0; i < N; i++) {
				p[i] = i;
			}

			// 크루스칼 알고리즘 수행
			long totalWeight = 0; // 선택된 간선들의 L^2 합
			int pick = 0; // 선택한 간선의 수

			for (int i = 0; i < edgeCount; i++) {
				int from = (int) edges[i][0];
				int to = (int) edges[i][1];
				long cost = edges[i][2];

				// 싸이클이 발생하지 않는 경우에만 선택 (루트가 다를 때)
				if (findSet(from) != findSet(to)) {
					union(from, to);
					totalWeight += cost;
					pick++;
				}
				// N-1개의 간선을 모두 골랐다면 종료 (최소 신장 트리 완성)
				if (pick == N - 1)
					break;
			}

			// 최종 계산 및 반올림
			long ans = Math.round(E * totalWeight);

			System.out.println("#" + tc + " " + ans);
		}
	}

	// 두 집합 합치기
	static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}

	// 대표 찾기
	static int findSet(int x) {
		if (x != p[x]) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}
}