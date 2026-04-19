import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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

        // 인접 행렬(2차원 배열) 1개만 선언
        int[][] graph = new int[N + 1][N + 1];
        
        // 연결되지 않은 상태를 표현하기 위해 무한대(또는 -1)로 초기화
        for (int i = 1; i <= N; i++) {
            Arrays.fill(graph[i], -1); 
        }

        // 그래프 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            // 2차원 배열에 저장 (단일 배열)
            graph[from][to] = time; 
        }

        // 다익스트라로 최단거리 구하기 (배열 하나로 방향만 다르게)
        int[] goDist = solve(graph, X, true);  // 집 -> X (역방향: graph[to][from] 조회)
        int[] backDist = solve(graph, X, false); // X -> 집 (정방향: graph[from][to] 조회)

        int maxV = 0;
        for (int i = 1; i <= N; i++) {
            if (i == X) continue;
            maxV = Math.max(maxV, goDist[i] + backDist[i]);
        }

        System.out.println(maxV);
    }

    // isReverse가 true면 역방향 탐색, false면 정방향 탐색
    static int[] solve(int[][] graph, int start, boolean isReverse) {
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (visited[cur.to]) continue;
            visited[cur.to] = true;

            // 1부터 N까지 모든 노드를 확인 (인접 리스트와 다른 부분)
            for (int nxt = 1; nxt <= N; nxt++) {
                // 역방향이면 graph[nxt][cur], 정방향이면 graph[cur][nxt] 값을 확인
                int time = isReverse ? graph[nxt][cur.to] : graph[cur.to][nxt];

                // 연결되어 있고(-1이 아님), 아직 방문하지 않았으며, 거리가 더 짧아진다면 갱신
                if (time != -1 && !visited[nxt] && dist[cur.to] + time < dist[nxt]) {
                    dist[nxt] = dist[cur.to] + time;
                    pq.add(new Edge(nxt, dist[nxt]));
                }
            }
        }
        return dist;
    }
}