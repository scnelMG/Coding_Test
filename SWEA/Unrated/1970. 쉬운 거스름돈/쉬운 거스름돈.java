import java.util.Scanner;
 
public class Solution {
    static int[] change = { 10, 50, 100, 500, 1000, 5000, 10000, 50000 }; // 돈 종류 8개
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
 
            int[] dp = new int[N + 1];
            int[] numC = new int[8];
            for (int i = 1; i <= N; i++) {
                int minCnt = dp[i - 1] + 1;
 
                for (int j = 0; j < 8; j++) {
 
                    if (i >= change[j]) {
                        minCnt = Math.min(dp[i - change[j]] + 1, minCnt);
                        if (i == N) { // 배수 관계에 있을 때만 가능
                            numC[j] = i / change[j];
                            if (j > 0) {
                                numC[j - 1] = numC[j - 1] - numC[j] * (change[j] / change[j - 1]);
                            }
                        }
                    }
 
                    dp[i] = minCnt;
                }
            }
            System.out.println("#" + tc);
            for (int i = 7; i >= 0; i--) {
                System.out.print(numC[i] + " ");
            }
            System.out.println();
        }
    }
}