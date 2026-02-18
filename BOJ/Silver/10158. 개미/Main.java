import java.util.Scanner;

public class Main {

    static int reflect(int pos, int L) {
        int m = pos % (2 * L);
        if (m > L) // -방향으로 돌아가기
            // m = 2 * L - m;
            m = L - (m - L);
        return m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt();
        int h = sc.nextInt();

        int p = sc.nextInt();
        int q = sc.nextInt();

        int t = sc.nextInt();

        int x = reflect(p + t, w);
        int y = reflect(q + t, h);

        System.out.println(x + " " + y);
    }
}
