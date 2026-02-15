import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }
        int res = 0;
        int idx = 0;
        while (res < 100) { // 87 142
            res += arr[idx++];
        }

        if (100 - (res - arr[idx - 1]) >= res - 100)
            System.out.println(res);
        else if (100 - (res - arr[idx - 1]) < res - 100) {
            System.out.println(res - arr[idx - 1]);
        }

    }
}
