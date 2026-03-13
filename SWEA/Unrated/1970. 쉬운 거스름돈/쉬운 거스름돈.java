import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        int[] moneys = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };
        int[] scaledMoneys = { 5000, 1000, 500, 100, 50, 10, 5, 1 };

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            
            int target = N / 10; 

            int[] dp = new int[target + 1];
            int[] choice = new int[target + 1];
            
            Arrays.fill(dp, 987654321);
            dp[0] = 0;

            // N 대신 target 사용, moneys 대신 scaledMoneys 사용
            for (int curMoney = 1; curMoney <= target; curMoney++) {
                for (int mIdx = 0; mIdx < scaledMoneys.length; mIdx++) {
                    if (curMoney >= scaledMoneys[mIdx]) {
                        if (dp[curMoney - scaledMoneys[mIdx]] + 1 < dp[curMoney]) {
                            dp[curMoney] = dp[curMoney - scaledMoneys[mIdx]] + 1;
                            choice[curMoney] = mIdx;
                        }
                    }
                }
            }

            int[] res = new int[moneys.length];
            while (target > 0) {
                int coinIdx = choice[target];
                res[coinIdx]++;
                target -= scaledMoneys[coinIdx]; // 스케일링된 화폐 단위로 빼기
            }
            
            System.out.println("#" + tc);
            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }
}