import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 0; tc < T; tc++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            char[][] grid = new char[H][W];
            for (int i = 0; i < H; i++) {
                String temp = sc.next();
                for (int j = 0; j < W; j++) {
                    grid[i][j] = temp.charAt(j);
                }
            }

            for (int i = 0; i < H; i++) {
                for (int j = W - 1; j >= 0; j--) {
                    System.out.print(grid[i][j]);
                }
                System.out.println();
            }
        }

    }
}