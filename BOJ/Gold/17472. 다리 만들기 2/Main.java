import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] grid;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    // ❌ Edge 클래스 삭제!

    static int islandId;
    static int totalIslands;
    // 다리 정보를 int[] 배열로 관리: {출발섬, 도착섬, 길이}
    static List<int[]> edgeList;
    static List<int[]> selectedEdges;
    static int minTotalLength;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // ==========================================
        // 1. 섬 이름표 붙이기 (BFS)
        // ==========================================
        islandId = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1) {
                    markIsland(i, j, islandId);
                    islandId++;
                }
            }
        }
        totalIslands = islandId - 2;

        // ==========================================
        // 2. 지을 수 있는 모든 다리 찾기
        // ==========================================
        int[][] adjMatrix = new int[islandId][islandId];
        for (int i = 2; i < islandId; i++) {
            for (int j = 2; j < islandId; j++) {
                adjMatrix[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] > 1) {
                    findBridges(i, j, grid[i][j], adjMatrix);
                }
            }
        }

        // 중복을 제거하고 다리 후보들을 int[] 배열 형태로 리스트에 담기
        edgeList = new ArrayList<>();
        for (int i = 2; i < islandId; i++) {
            for (int j = i + 1; j < islandId; j++) {
                if (adjMatrix[i][j] != Integer.MAX_VALUE) {
                    // {출발섬, 도착섬, 다리길이}
                    edgeList.add(new int[] { i, j, adjMatrix[i][j] });
                }
            }
        }

        // ==========================================
        // 3. 백트래킹으로 최적의 다리 조합 찾기
        // ==========================================
        minTotalLength = Integer.MAX_VALUE;
        selectedEdges = new ArrayList<>();

        dfs(0, 0); // 백트래킹 시작!

        // 출력
        if (minTotalLength == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minTotalLength);
        }
    }

    // [핵심] 백트래킹
    static void dfs(int idx, int currentLength) {
        // [가지치기]
        if (currentLength >= minTotalLength) {
            return;
        }

        if (selectedEdges.size() >= totalIslands - 1) {
            if (checkConnected()) {
                minTotalLength = currentLength;
            }
        }

        if (idx == edgeList.size()) {
            return;
        }

        // 1번 선택: 현재 다리를 건설한다
        selectedEdges.add(edgeList.get(idx));
        // edgeList.get(idx)[2] 는 해당 다리의 '길이'를 의미합니다.
        dfs(idx + 1, currentLength + edgeList.get(idx)[2]);
        selectedEdges.remove(selectedEdges.size() - 1); // 원상복구

        // 2번 선택: 현재 다리를 건설하지 않고 건너뛴다
        dfs(idx + 1, currentLength);
    }

    // 선택된 다리들만 썼을 때, 모든 섬이 하나로 이어지는지 확인
    static boolean checkConnected() {
        if (selectedEdges.isEmpty())
            return false;

        List<Integer>[] adj = new ArrayList[islandId];
        for (int i = 2; i < islandId; i++) {
            adj[i] = new ArrayList<>();
        }

        // 배열 인덱스 0번(출발섬), 1번(도착섬)을 이용해 연결 상태 만들기
        for (int[] e : selectedEdges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        boolean[] visited = new boolean[islandId];
        Queue<Integer> q = new LinkedList<>();

        q.add(2);
        visited[2] = true;
        int count = 1;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int next : adj[curr]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    count++;
                }
            }
        }

        return count == totalIslands;
    }

    static void markIsland(int r, int c, int id) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { r, c });
        grid[r][c] = id;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && grid[nr][nc] == 1) {
                    grid[nr][nc] = id;
                    queue.add(new int[] { nr, nc });
                }
            }
        }
    }

    static void findBridges(int r, int c, int startIsland, int[][] adjMatrix) {
        for (int d = 0; d < 4; d++) {
            int nr = r;
            int nc = c;
            int length = 0;

            while (true) {
                nr += dr[d];
                nc += dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M)
                    break;
                if (grid[nr][nc] == startIsland)
                    break;

                if (grid[nr][nc] > 1) {
                    if (length >= 2) {
                        int targetIsland = grid[nr][nc];
                        adjMatrix[startIsland][targetIsland] = Math.min(adjMatrix[startIsland][targetIsland], length);
                    }
                    break;
                }
                length++;
            }
        }
    }
}