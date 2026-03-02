
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[][] grid;
    static int N, M;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solve());

    }

    static int solve() {
        int[][] dist = new int[N][M];
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                if (grid[i][j] == 1) {
                    q.offer(new int[] { i, j });
                }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M)
                    continue;

                if (grid[nr][nc] == 0 && dist[nr][nc] == 0) {
                    dist[nr][nc] = dist[r][c] + 1;
                    grid[nr][nc] = 1;
                    q.offer(new int[] { nr, nc });
                }
            }
        }
        int maxV = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 0)
                    return -1;
                if (dist[i][j] > maxV)
                    maxV = dist[i][j];
            }
        }
        return maxV;

    }

}