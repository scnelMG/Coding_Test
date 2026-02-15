import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        Arrays.sort(arr);

        int idxA = 0, idxB = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    idxA = i;
                    idxB = j;
                    break;
                }

            }
        }
        for (int i = 0; i < 9; i++)
            if (i != idxA && i != idxB)
                System.out.println(arr[i]);

    }
}
