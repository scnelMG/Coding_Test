import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        Set<Integer> set = new HashSet<>();

        int goal = N * (N * N + 1) / 2;
        boolean isGood = true;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
                set.add(arr[i][j]);
            }
        }

        if (set.size() != N * N)
            isGood = false;

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += arr[i][j];
            }
            if (sum != goal) {
                isGood = false;
                break;
            }
        }

        for (int j = 0; j < N; j++) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += arr[i][j];
            }
            if (sum != goal) {
                isGood = false;
                break;
            }
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i][i];
        }
        if (sum != goal) {
            isGood = false;
        }

        sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[N - 1 - i][i];
        }
        if (sum != goal) {
            isGood = false;
        }

        if (isGood)
            System.out.println("TRUE");
        else
            System.out.println("FALSE");

    }
}