
import java.util.Scanner;

class Solution {
    static int N;
    static int[][] grid;
    static boolean[] selected;
    static int minV;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();

            grid = new int[N][N];
            selected = new boolean[N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            minV = Integer.MAX_VALUE;
            comb(0, 0);
            System.out.println("#" + tc + " " + minV);

        }
    }

    static void comb(int cnt, int start) {
        if (cnt == N / 2) {
            int sumA = 0;
            int sumB = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (selected[i] && selected[j])
                        sumA += grid[i][j];
                    else if (!selected[i] && !selected[j])
                        sumB += grid[i][j];
                }
            }
            int res = Math.abs(sumA - sumB);
            if (minV > res)
                minV = res;

            return;
        }
        for (int i = start; i < N; i++) {
            selected[i] = true;
            comb(cnt + 1, i + 1);
            selected[i] = false;
        }
    }

}
