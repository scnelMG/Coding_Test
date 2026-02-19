import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int minCnt = Integer.MAX_VALUE;
        int num_5 = 0;
        while (N >= num_5 * 5) {
            int tmp = N - num_5 * 5;
            int cnt = 0;
            if (tmp % 3 == 0) {
                cnt = tmp / 3 + num_5;
                if (cnt < minCnt)
                    minCnt = cnt;
            }
            num_5++;
        }
        if (minCnt == Integer.MAX_VALUE)
            System.out.println(-1);
        else {
            System.out.println(minCnt);
        }

    }
}
