import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[102][102];

        int N = sc.nextInt();
        int cnt = 0;
        for (int n = 0; n < N; n++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            for (int i = x; i < x + 10; i++) {
                for (int j = y; j < y + 10; j++) {
                    arr[i][j] = 1;
                }
            }
        }
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (arr[i][j] == 1) {
                    if (arr[i + 1][j] == 0)
                        cnt++;
                    if (arr[i - 1][j] == 0)
                        cnt++;
                    if (arr[i][j + 1] == 0)
                        cnt++;
                    if (arr[i][j - 1] == 0)
                        cnt++;
                }
            }
        }

        System.out.println(cnt);

    }
}
