import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[101][101];

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
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[i][j] == 1)
                    cnt++;
            }
        }

        System.out.println(cnt);

    }
}
