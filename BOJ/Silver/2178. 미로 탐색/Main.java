
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static char[][] grid;
    static int N, M;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new char[N][M];
        for (int i = 0; i < N; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        System.out.println(solve(0, 0));

    }

    static int solve(int sr, int sc) {
        int[][] dist = new int[N][M];
        Deque<int[]> q = new ArrayDeque<>();

        q.offer(new int[] { sr, sc });
        dist[sr][sc] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            if (r == N - 1 && c == M - 1)
                return dist[r][c];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M)
                    continue;

                if (grid[nr][nc] == '0')
                    continue;
                if (dist[nr][nc] == 0) {
                    dist[nr][nc] = dist[r][c] + 1;
                    q.offer(new int[] { nr, nc });
                }
            }

        }
        return -1;

    }

}