import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            System.out.print("#" + tc + " ");
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] arr = new int[N + M + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    arr[i + j]++;
                }
            }

            int maxV = 0;
            for (int i = 2; i < arr.length; i++) {
                if (maxV < arr[i])
                    maxV = arr[i];
            }

            for (int i = 2; i < arr.length; i++) {
                if (maxV == arr[i])
                    System.out.print(i + " ");
            }
            System.out.println();

        }

    }
}