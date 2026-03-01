package 박민규.CodeTree.등산로공사;

import java.util.*;

public class Main {
    static int N, K;
    static int[][] map;
    static int[][] originalMap; // 초기 최고봉 보호용
    static boolean[][] visited;
    static int maxH, answer;

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        map = new int[N][N];
        originalMap = new int[N][N];
        maxH = 0;

        // 지도 입력 및 최고 높이 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                originalMap[i][j] = map[i][j];
                if (map[i][j] > maxH)
                    maxH = map[i][j];
            }
        }

        answer = 0;
        visited = new boolean[N][N];

        // 모든 최고 봉우리에서 시작
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == maxH) {
                    visited[i][j] = true;
                    dfs(i, j, maxH, K, 1);
                    visited[i][j] = false; // 백트래킹
                }
            }
        }

        // 결과만 출력
        System.out.println(answer);
    }

    static void dfs(int r, int c, int currentH, int kRem, int length) {
        answer = Math.max(answer, length);

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            // 경계 검사 및 방문 여부 확인
            if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc])
                continue;

            // 1. 공사 없이 이동 가능
            if (map[nr][nc] < currentH) {
                visited[nr][nc] = true;
                dfs(nr, nc, map[nr][nc], kRem, length + 1);
                visited[nr][nc] = false;
            }
            // 2. 공사가 필요한 경우 (현재 높이보다 높거나 같음)
            else {
                // 원본 지도가 최고봉이 아닐 때만 깎기 가능
                if (originalMap[nr][nc] != maxH) {
                    int need = map[nr][nc] - currentH + 1;

                    // 남은 K 이내로 깎을 수 있고, 결과 높이가 1 이상이어야 함
                    if (need <= kRem && (currentH - 1) >= 1) {
                        visited[nr][nc] = true;
                        // 다음 칸을 현재 칸보다 1 낮게 설정 (가장 효율적인 공사)
                        dfs(nr, nc, currentH - 1, kRem - need, length + 1);
                        visited[nr][nc] = false;
                    }
                }
            }
        }
    }
}