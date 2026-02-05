import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int T = sc.nextInt();

        int[] dr = { -1, 1, 0, 0 }; // 상하좌우
        int[] dc = { 0, 0, -1, 1 };

        int[][] grid = new int[R][C];
        int airUpper = -1; // 윗 공기청정기 위치
        int airLower = -1; // 아래 공기청정기 위치

        // 배열에 값 저장
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == -1) { // 공기청정기 위치 저장
                    if (airUpper == -1)
                        airUpper = i;
                    else
                        airLower = i;
                }
            }
        }

        for (int t = 0; t < T; t++) {
            // 먼지 확산

            // 확산 배열 생성
            int[][] grid2 = new int[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (grid[i][j] == -1) {
                        grid2[i][j] = -1; // 공기청정기 위치 넣기
                    } else if (grid[i][j] > 0) {
                        int amount = grid[i][j] / 5;
                        int cnt = 0;
                        for (int d = 0; d < 4; d++) {
                            int ni = i + dr[d];
                            int nj = j + dc[d];
                            if (ni >= 0 && ni < R && nj >= 0 && nj < C && grid[ni][nj] != -1) {
                                grid2[ni][nj] += amount;
                                cnt++;
                            }
                        }
                        grid2[i][j] += grid[i][j] - (amount * cnt); // 확산 배열에 확산 결과 추가
                    }
                }
            }
            grid = grid2; // 확산 완료된 배열로 교체

            // 2. 공기청정기 작동 (바람의 역순으로 당기기)
            // 위쪽 공기청정기 (반시계방향)
            for (int i = airUpper - 1; i > 0; i--)
                grid[i][0] = grid[i - 1][0]; // 왼쪽 아래로
            for (int j = 0; j < C - 1; j++)
                grid[0][j] = grid[0][j + 1]; // 윗쪽 왼쪽으로
            for (int i = 0; i < airUpper; i++)
                grid[i][C - 1] = grid[i + 1][C - 1]; // 오른쪽 위로
            for (int j = C - 1; j > 1; j--)
                grid[airUpper][j] = grid[airUpper][j - 1]; // 아래쪽 오른쪽으로
            grid[airUpper][1] = 0; // 먼지 제거

            // 아래쪽 공기청정기 (시계방향)
            for (int i = airLower + 1; i < R - 1; i++)
                grid[i][0] = grid[i + 1][0]; // 왼쪽 위로
            for (int j = 0; j < C - 1; j++)
                grid[R - 1][j] = grid[R - 1][j + 1]; // 아래쪽 왼쪽으로
            for (int i = R - 1; i > airLower; i--)
                grid[i][C - 1] = grid[i - 1][C - 1]; // 오른쪽 아래로
            for (int j = C - 1; j > 1; j--)
                grid[airLower][j] = grid[airLower][j - 1]; // 윗쪽 오른쪽으로
            grid[airLower][1] = 0; // 먼지 제거
        }

        // 합 계산
        int res = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] > 0) // 공기청정기 값 제외
                    res += grid[i][j];
            }
        }
        System.out.println(res);
    }
}