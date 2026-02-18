import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        int R = sc.nextInt();
        int p = sc.nextInt();
        int q = R - sc.nextInt();
        int T = sc.nextInt();

        int[] dr = { -1, -1, 1, -1 };
        int[] dc = { 1, -1, -1, -1 };
        int idx = 0;
        for (int t = 0; t < T; t++) {
            if ((p >= C && q >= R) || (p >= C && q <= 0) || (p <= 0 && q >= R) || (p <= 0 && q <= 0))
                idx = (idx + 2) % 4;
            else if (p >= C || p <= 0 || q >= R || q <= 0) {
                idx = (idx + 1) % 4;

            }
            q += dr[idx];
            p += dc[idx];
        }
        System.out.println(p + " " + (R - q));

    }
}
