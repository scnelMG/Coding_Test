import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int res[] = new int[n];
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = i + 1;
        }
        arr = res.clone();

        for (int tc = 0; tc < m; tc++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            for (int idx = 0; idx <= j - i; idx++) {
                res[j - 1 - idx] = arr[i - 1 + idx];
            }
            arr = res.clone();
        }
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }

    }
}