import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int gender = sc.nextInt();
            int num = sc.nextInt();
            if (gender == 1) {
                for (int j = 1; j <= N; j++) {
                    if (j % num == 0)
                        arr[j] = 1 - arr[j];
                }
            } else {
                arr[num] = 1 - arr[num];
                for (int j = 1; j + num <= N && num - j > 0; j++) {
                    if (arr[num + j] == arr[num - j]) {
                        arr[num + j] = 1 - arr[num + j];
                        arr[num - j] = 1 - arr[num - j];
                    }

                }
            }
        }

        for (int i = 0; i <= (N - 1) / 20; i++) {
            for (int j = 1; j <= (N - 1) % 20 + 1; j++) {
                System.out.print(arr[i * 20 + j] + " ");
            }
        }
    }
}
