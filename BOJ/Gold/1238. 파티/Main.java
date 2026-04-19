import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static int N; // 노드 개수

    // Edge 클래스 지정
    static class Edge implements Comparable<Edge> {
        int to, time;

        public Edge(int to, int time) {
            this.to = to;
            this.time = time;
        }

        // PQ 이용한 다익스트라를 위한 Comparable
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

        // 인접 리스트로 그래프 정보 입력 (정방향만 사용)
        List<Edge>[] adjList = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 그래프 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            adjList[from].add(new Edge(to, time)); // 정방향만 저장
        }

        // 1. X -> 집 (X에서 출발하는 다익스트라 1번 수행)
        int[] backDist = solve(adjList, X);

        // 최대 시간 저장 변수
        int maxV = 0;
        
        // 2. 집 -> X (각 노드 i에서 출발하는 다익스트라 N번 수행)
        for (int i = 1; i <= N; i++) {
            if (i == X)
                continue;
                
            // 노드 i에서 출발하는 다익스트라 수행
            int[] goDist = solve(adjList, i); 
            
            // i에서 출발해 X로 가는 거리(goDist[X]) + X에서 i로 돌아오는 거리(backDist[i])
            maxV = Math.max(maxV, goDist[X] + backDist[i]);
        }

        // 최대 시간 출력
        System.out.println(maxV);
    }

    // 다익스트라 후 -> 거리 배열 리턴 함수
    static int[] solve(List<Edge>[] graph, int start) {

        boolean[] visited = new boolean[N + 1]; // 방문 확인 배열
        int[] dist = new int[N + 1]; // 최단 거리 저장 배열

        // 다익스트라를 위한 초기값 설정
        for (int i = 0; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0; // 출발 위치는 0으로

        // PQ를 이용한 다익스트라
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0)); // 출발점 넣기

        while (!pq.isEmpty()) {
            Edge cur = pq.poll(); // PQ에서 하나 꺼냄

            if (visited[cur.to]) // 방문했었으면 패스
                continue;
            visited[cur.to] = true; // 방문 처리

            for (Edge e : graph[cur.to]) { // 꺼낸 간선이 향하는 노드들에 대해서
                if (!visited[e.to] && dist[cur.to] + e.time < dist[e.to]) {
                    dist[e.to] = dist[cur.to] + e.time; // 거리 배열에 업데이트
                    pq.add(new Edge(e.to, dist[e.to])); // PQ에 해당 간선 추가
                }
            }
        }
        return dist; // 계산된 거리 배열 전체 반환
    }
}