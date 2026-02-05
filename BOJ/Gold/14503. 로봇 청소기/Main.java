import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        java.util.Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int[] dr = { -1, 0, 1, 0 }; // 북동남서
        int[] dc = { 0, 1, 0, -1 };
        int dIdx = d;
        int[][] grid = new int[N + 2][M + 2];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        r++;
        c++;

        int cnt = 0;
        grid[r][c] = 2; // 청소
        cnt++;

        while (true) {
            if ((grid[r + 1][c] != 0) && (grid[r][c + 1] != 0) && (grid[r - 1][c] != 0) && (grid[r][c - 1] != 0)) {
                r += dr[(dIdx + 2) % 4]; // 후진
                c += dc[(dIdx + 2) % 4];
                if (grid[r][c] == 1) {
                    break;
                }
                if (grid[r][c] != 2) {
                    grid[r][c] = 2; // 청소
                    cnt++;
                }

            } else {
                dIdx = (dIdx + 3) % 4; // 반시계 90도 회전

                if (grid[r + dr[dIdx]][c + dc[dIdx]] == 0) {
                    r += dr[dIdx];
                    c += dc[dIdx];
                    if (grid[r][c] != 2) {
                        grid[r][c] = 2; // 청소
                        cnt++;
                    }

                }
            }
        }
        System.out.println(cnt);
    }
}
