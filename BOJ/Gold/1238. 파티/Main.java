import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static int N;

    static class Edge implements Comparable<Edge> {
        int to, time;

        public Edge(int to, int time) {
            this.to = to;
            this.time = time;
        }

        @Override
        public int compareTo(Edge o) {
            return this.time - o.time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        // 정방향(X -> 집)과 역방향(집 -> X) 그래프를 각각 준비합니다.
        List<Edge>[] adjList = new ArrayList[N + 1];
        List<Edge>[] adjListRev = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
            adjListRev[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            adjList[from].add(new Edge(to, time));
            adjListRev[to].add(new Edge(from, time)); // 역방향 간선 저장
        }

        // 다익스트라 2번 호출로 모든 거리 계산 완료
        int[] goDist = solve(adjListRev, X); // 집 -> X (역방향 그래프에서 X출발)
        int[] backDist = solve(adjList, X); // X -> 집 (정방향 그래프에서 X출발)

        int maxV = 0;
        for (int i = 1; i <= N; i++) {
            if (i == X)
                continue;
            // 왕복 시간의 최댓값 갱신
            if (goDist[i] != Integer.MAX_VALUE && backDist[i] != Integer.MAX_VALUE) {
                maxV = Math.max(maxV, goDist[i] + backDist[i]);
            }
        }

        // 학생 번호가 아닌 최대 소요 시간 출력!
        System.out.println(maxV);
    }

    // 단일 목적지가 아닌, 배열 전체를 반환하도록 수정
    static int[] solve(List<Edge>[] graph, int start) {
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (visited[cur.to])
                continue;
            visited[cur.to] = true;

            for (Edge e : graph[cur.to]) {
                if (!visited[e.to] && dist[cur.to] + e.time < dist[e.to]) {
                    dist[e.to] = dist[cur.to] + e.time;
                    pq.add(new Edge(e.to, dist[e.to]));
                }
            }
        }
        return dist; // 계산된 거리 배열 전체 반환
    }
}