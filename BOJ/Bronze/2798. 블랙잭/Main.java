import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int targetV = -1;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sumV = arr[i] + arr[j] + arr[k];
                    if (sumV > M)
                        continue;
                    if (M - sumV < M - targetV) {
                        targetV = sumV;
                    }
                }
            }
        }
        System.out.println(targetV);

    }
}
