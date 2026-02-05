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
        int[][] grid = new int[N + 2][M + 2]; // 배열을 상하좌우로 한줄씩 더 만들어서 배열 벗어남 방지

        // 배열에 값 넣기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        // 배열을 늘렸어서 시작점도 변경
        r++;
        c++;

        // 젤 처음 위치 청소 하고 시작
        grid[r][c] = 2; // 청소 -> 2로 표기
        int cnt = 1;

        while (true) {
            if ((grid[r + 1][c] != 0) && (grid[r][c + 1] != 0) && (grid[r - 1][c] != 0) && (grid[r][c - 1] != 0)) {
                r += dr[(dIdx + 2) % 4]; // 뒷걸음질 -> 뒤로 돌아서 가는게 아님.!!!
                c += dc[(dIdx + 2) % 4];

                if (grid[r][c] == 1) { // 벽으로 막히면 중단
                    break;
                }
                if (grid[r][c] != 2) { // 청소 안한 곳이면
                    grid[r][c] = 2; // 청소
                    cnt++;
                }

            } else {
                dIdx = (dIdx + 3) % 4; // 반시계 90도 회전

                if (grid[r + dr[dIdx]][c + dc[dIdx]] == 0) {
                    r += dr[dIdx]; // 직진
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
