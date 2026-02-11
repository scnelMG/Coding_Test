import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int cnt;
        int res = 0;
        // 1 2 2 3 3 3 4
        cnt = 0;
        for (int i = 1; cnt < B; i++) {
            for (int j = 0; j < i && cnt < B; j++) {
                res += i;
                cnt++;
            }

        }

        cnt = 0;
        for (int i = 1; cnt < A - 1; i++) {
            for (int j = 0; j < i && cnt < A - 1; j++) {
                res -= i;
                cnt++;
            }
        }
        System.out.println(res);

    }
}