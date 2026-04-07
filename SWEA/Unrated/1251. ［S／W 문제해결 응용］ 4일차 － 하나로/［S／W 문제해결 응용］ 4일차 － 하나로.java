import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	static int[] p;

	// 간선 정보를 담을 클래스 (가중치 기준 오름차순 정렬)
	static class Edge implements Comparable<Edge> {
		int from, to;
		long cost;

		public Edge(int from, int to, long cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", cost=" + cost + "]";
		}

		// 오름차순 정렬
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.cost, o.cost);
		}

	}

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

			// 모든 가능한 간선 생성 - N개의 섬에서 2개를 고르는 모든 경우의 수
			ArrayList<Edge> edges = new ArrayList<>();
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					// 거리의 제곱(L^2) 계산
					long distSq = (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]);
					edges.add(new Edge(i, j, distSq));
				}
			}

			// 가중치 기준으로 오름차순 정렬
			Collections.sort(edges);

			// 부모 정보 배열 초기화
			p = new int[N];
			for (int i = 0; i < N; i++) {
				p[i] = i;
			}

			// 크루스칼 알고리즘 수행
			long totalWeight = 0; // 선택된 간선들의 L^2 합
			int pick = 0; // 선택한 간선의 수

			for (Edge edge : edges) {
				// 싸이클이 발생하지 않는 경우에만 선택 (루트가 다를 때)
				if (findSet(edge.from) != findSet(edge.to)) {
					union(edge.from, edge.to);
					totalWeight += edge.cost;
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