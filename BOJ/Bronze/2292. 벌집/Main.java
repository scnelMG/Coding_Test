import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt() - 1;
        // 1 7 19 37 -> 0, 6, 18, 36,
        // 6 12 18
        int res = 1;
        while (N > (res - 1) * 6) {
            N -= (res - 1) * 6;
            res++;

        }
        System.out.println(res);

    }
}
