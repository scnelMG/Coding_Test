import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] grid = new int[1001][1001];
        for (int n = 1; n <= N; n++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();

            for (int i = a; i < a + c; i++) {
                for (int j = b; j < b + d; j++) {
                    grid[i][j] = n;
                }
            }
        }

        for (int n = 1; n <= N; n++) {
            int cnt = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == n)
                        cnt++;
                }
            }
            System.out.println(cnt);
        }

    }
}
