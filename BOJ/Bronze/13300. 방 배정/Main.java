import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] grid = new int[2][7];
        for (int i = 0; i < N; i++) {
            int S = sc.nextInt();
            int Y = sc.nextInt();
            grid[S][Y]++;
        }

        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    cnt += ((grid[i][j] - 1) / K + 1);
                }
            }
        }
        System.out.println(cnt);

    }
}
