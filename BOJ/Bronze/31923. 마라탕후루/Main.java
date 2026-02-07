
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int P = sc.nextInt();
        int Q = sc.nextInt();

        int[][] fruits = new int[2][N];
        int[] res = new int[N];
        boolean isGood = true;

        for (int t = 0; t < 2; t++) {
            for (int n = 0; n < N; n++) {
                fruits[t][n] = sc.nextInt();
            }
        }

        for (int n = 0; n < N; n++) {
            if ((fruits[0][n] - fruits[1][n] == 0)) {
                continue;
            }
            if (P - Q == 0) {
                isGood = false;
                break;
            }

            if ((fruits[0][n] - fruits[1][n]) * (P - Q) > 0) {
                isGood = false;
                break;
            }
            if (Math.abs(fruits[0][n] - fruits[1][n]) < Math.abs(P - Q)) {
                isGood = false;
                break;
            }

            res[n] = Math.abs(fruits[0][n] - fruits[1][n]) / Math.abs(P - Q);
        }
        if (isGood) {
            System.out.println("YES");
            for (int i = 0; i < N; i++) {
                System.out.print(res[i] + " ");
            }
        } else {
            System.out.println("NO");
        }

    }
}