import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int N = sc.nextInt();
        int[] arr = new int[L + 1];
        int expectMax_v = 0;
        int expectMaxIdx = 0;
        int realMax_v = 0;
        int realMaxIdx = 0;

        for (int i = 1; i <= N; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            if (expectMax_v < e - s) {
                expectMax_v = (e - s);
                expectMaxIdx = i;
            }
            int cnt = 0;
            for (int j = s; j <= e; j++) {
                if (arr[j] == 0) {
                    arr[j] = 1;
                    cnt++;
                }
            }
            if (realMax_v < cnt) {
                realMax_v = cnt;
                realMaxIdx = i;
            }

        }
        System.out.println(expectMaxIdx);
        System.out.println(realMaxIdx);

    }
}
