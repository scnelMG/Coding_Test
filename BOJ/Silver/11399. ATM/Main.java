import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer[] arr = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        int res = 0;
        for (int i = 0; i < N; i++) {
            res += arr[i] * (i + 1);
        }
        System.out.println(res);

    }
}
