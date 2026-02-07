
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean up = true;
        boolean res = true;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        if (arr[0] >= arr[1]) {
            System.out.println("NO");
            return;
        }

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] == arr[i]) {
                res = false;
                break;
            }
            if (up && arr[i - 1] > arr[i]) {
                up = false;
            }
            if (!up && arr[i - 1] < arr[i]) {
                res = false;
                break;
            }
        }
        if (res)
            System.out.println("YES");
        else {
            System.out.println("NO");
        }

    }
}