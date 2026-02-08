import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            while (N >= 2) {
                if (N == 2) {
                    if (arr[0] > arr[1])
                        System.out.println("Case #" + tc + ": Alice");
                    else {
                        System.out.println("Case #" + tc + ": Bob");
                    }
                    break;
                }

                for (int i = 0; i < (int) Math.ceil((float) N / 2); i++) {
                    arr[i] = arr[i] + arr[N - 1 - i];
                }
                N = (int) Math.ceil((float) N / 2);

            }

        }
    }
}