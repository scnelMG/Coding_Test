
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int[] arr = new int[10];
            int input = sc.nextInt();
            while (input > 0) {
                arr[input % 10] = 1;
                input /= 10;
            }
            int res = 0;
            for (int j = 0; j < 10; j++) {
                res += arr[j];
            }
            System.out.println(res);

        }
    }
}