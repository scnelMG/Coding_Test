import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 0;

        // 세로 길이
        for (int h = 1; h <= n; h++) {

            // 가로 길이
            for (int w = h; w <= n; w++) {

                // 필요한 정사각형 개수
                int need = h * w;

                if (need <= n) {
                    cnt++;
                } else {
                    break; // 더 커지면 의미 없음
                }
            }
        }

        System.out.println(cnt);
    }
}
