import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();

        int[] arr = new int[N];

        int idx = 0;
        int cnt = 0;
        arr[idx]++;
        while (true) {
            if (arr[idx] == M)
                break;
            if (arr[idx] % 2 != 0)
                idx = (idx + L) % N;
            else {
                idx = (N + (idx - L)) % N;
            }
            arr[idx]++;
            cnt++;
        }
        System.out.println(cnt);

    }
}