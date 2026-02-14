import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            int max_v = 0;
            for (int j = 0; j < N; j++) {
                int tmp = sc.nextInt();
                if (max_v < tmp)
                    max_v = tmp;

            }
            arr[i] = max_v;
        }
        int max_v = 0;
        int maxIdx = -1;
        for (int i = 0; i < 9; i++) {
            if (max_v < arr[i]) {
                max_v = arr[i];
                maxIdx = i;
            }
        }
        String[] clubArr = { "PROBRAIN", "GROW", "ARGOS", "ADMIN", "ANT", "MOTION", "SPG", "COMON", "ALMIGHTY" };
        System.out.println(clubArr[maxIdx]);
    }
}
