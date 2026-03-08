
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
    static int[][] grid;
    static int N;
    static List<int[]> list;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static int maxV;
    static int minLength;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            grid = new int[N][N];
            list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                    if (i != 0 && j != 0 && i != N - 1 && j != N - 1) {
                        if (grid[i][j] == 1) {
                            list.add(new int[] { i, j });
                        }
                    }
                }
            }

            maxV = -1;
            minLength = Integer.MAX_VALUE;
            solve(0, 0, 0);
            System.out.println("# " + tc + " " + minLength);

        }

    }

    static void solve(int idx, int connectNum, int totalLength) {
        if (idx == list.size()) {
            if (maxV < connectNum) {
                maxV = connectNum;
                minLength = totalLength;
            } else if (maxV == connectNum) {
                if (minLength > totalLength)
                    minLength = totalLength;
            }
            return;
        }

        int targetR = list.get(idx)[0];
        int targetC = list.get(idx)[1];

        for (int d = 0; d < 4; d++) {
            int r = targetR;
            int c = targetC;
            boolean isConnect = false;
            int length = 0;
            while (true) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                    isConnect = true;
                    break;
                }
                if (grid[nr][nc] != 0) {
                    break;
                }
                r = nr;
                c = nc;
                length++;
            }
            if (isConnect) {
                connectNum++;
                totalLength += length;
                draw(d, length, targetR, targetC);
            }
            solve(idx + 1, connectNum, totalLength);
            if (isConnect) {
                remove_draw(d, length, targetR, targetC);
                connectNum--;
                totalLength -= length;
            }
        }
    }

    static void draw(int d, int length, int targetR, int targetC) {
        for (int i = 1; i <= length; i++) {
            grid[targetR + i * dr[d]][targetC + i * dc[d]] = 2;
        }
    }

    static void remove_draw(int d, int length, int targetR, int targetC) {
        for (int i = 1; i <= length; i++) {
            grid[targetR + i * dr[d]][targetC + i * dc[d]] = 0;
        }
    }

}