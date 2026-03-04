import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[][] grid;
    // 0: 상, 1: 우, 2: 하, 3: 좌
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static int[][] warmHole;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            grid = new int[N][N];
            warmHole = new int[11][4]; // 6~10번 웜홀 좌표 저장

            for (int i = 6; i <= 10; i++) {
                for (int j = 0; j < 4; j++) warmHole[i][j] = -1;
            }

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    grid[i][j] = num;
                    if (num >= 6 && num <= 10) {
                        if (warmHole[num][0] == -1) {
                            warmHole[num][0] = i;
                            warmHole[num][1] = j;
                        } else {
                            warmHole[num][2] = i;
                            warmHole[num][3] = j;
                        }
                    }
                }
            }

            int maxV = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] == 0) { // 빈 공간에서만 시작
                        for (int d = 0; d < 4; d++) {
                            maxV = Math.max(maxV, game(i, j, d));
                        }
                    }
                }
            }
            System.out.println("#" + tc + " " + maxV);
        }
    }

    static int game(int sr, int sc, int d) {
        int cnt = 0;
        int r = sr;
        int c = sc;

        while (true) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            // 1. 벽에 부딪히는 경우 (점수 +1, 방향 반대)
            if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                cnt++;
                d = (d + 2) % 4;
                r = nr; c = nc; // 벽 밖의 좌표를 일단 할당 (다음 이동에서 돌아옴)
                continue;
            }

            // 2. 종료 조건: 시작 위치로 돌아오거나 블랙홀(-1)을 만남
            if ((nr == sr && nc == sc) || grid[nr][nc] == -1) {
                return cnt;
            }

            // 3. 블록을 만나는 경우
            if (grid[nr][nc] >= 1 && grid[nr][nc] <= 5) {
                cnt++;
                d = changeDir(grid[nr][nc], d);
                r = nr; c = nc;
            }
            // 4. 웜홀을 만나는 경우
            else if (grid[nr][nc] >= 6) {
                int num = grid[nr][nc];
                if (nr == warmHole[num][0] && nc == warmHole[num][1]) {
                    r = warmHole[num][2];
                    c = warmHole[num][3];
                } else {
                    r = warmHole[num][0];
                    c = warmHole[num][1];
                }
                // 진행 방향은 그대로 유지
            }
            // 5. 빈 공간인 경우
            else {
                r = nr; c = nc;
            }
        }
    }

    // 블록 번호와 현재 방향에 따른 다음 방향 반환
    static int changeDir(int block, int d) {
        if (block == 1) {
            if (d == 0) return 2; // 상 -> 하
            if (d == 1) return 3; // 우 -> 좌
            if (d == 2) return 1; // 하 -> 우
            return 0;             // 좌 -> 상
        } else if (block == 2) {
            if (d == 0) return 1; // 상 -> 우
            if (d == 1) return 3; // 우 -> 좌
            if (d == 2) return 0; // 하 -> 상
            return 2;             // 좌 -> 하
        } else if (block == 3) {
            if (d == 0) return 3; // 상 -> 좌
            if (d == 1) return 2; // 우 -> 하
            if (d == 2) return 0; // 하 -> 상
            return 1;             // 좌 -> 우
        } else if (block == 4) {
            if (d == 0) return 2; // 상 -> 하
            if (d == 1) return 0; // 우 -> 상
            if (d == 2) return 3; // 하 -> 좌
            return 1;             // 좌 -> 우
        } else { // 5번 블록 (정사각형)
            return (d + 2) % 4; // 반대 방향
        }
    }
}