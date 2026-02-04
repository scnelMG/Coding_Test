import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            if (a == 1) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                int res = 0;
                for (int j = s; j < e + 1; j++) {
                    res += arr[j - 1];
                }
                System.out.println(res);
                int tmp = arr[s - 1];
                arr[s - 1] = arr[e - 1];
                arr[e - 1] = tmp;

            } else {
                int s1 = sc.nextInt();
                int e1 = sc.nextInt();
                int s2 = sc.nextInt();
                int e2 = sc.nextInt();

                int res1 = 0;
                for (int j = s1; j < e1 + 1; j++) {
                    res1 += arr[j - 1];
                }

                int res2 = 0;
                for (int j = s2; j < e2 + 1; j++) {
                    res2 += arr[j - 1];
                }
                System.out.println(res1 - res2);

            }
        }

    }
}