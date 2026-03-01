
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] res;
    static int N;
    static int[][] grid;
    static int minV;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        minV = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        res = new boolean[N];

        choose(0, 0);
        System.out.println(minV);

    }

    static void choose(int depth, int start) {
        if (depth == N / 2) {
            int sumA = 0;
            int sumB = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (res[i] && res[j]) {
                        sumA += grid[i][j];

                    } else if (!res[i] && !res[j]) {
                        sumB += grid[i][j];
                    }
                }
            }
            int val = Math.abs(sumA - sumB);

            if (minV > val)
                minV = val;

            return;
        }
        for (int i = start; i < N; i++) {
            res[i] = true;
            choose(depth + 1, i + 1);
            res[i] = false;
        }

    }

}