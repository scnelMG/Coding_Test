import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int total = 0;
        int maxV = 0;
        for (int i = 0; i < N; i++) {
            int tmp = sc.nextInt();
            total += tmp;
            if (maxV < tmp)
                maxV = tmp;
        }
        double res = (((double) total / maxV) * 100) / N;
        System.out.println(res);

    }
}
