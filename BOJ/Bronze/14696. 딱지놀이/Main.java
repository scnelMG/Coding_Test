import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 별, 동그라미, 네모, 세모 -> 4, 3, 2, 1
        for (int n = 0; n < N; n++) {
            int a = sc.nextInt();
            int[] aArr = new int[a];
            for (int i = 0; i < a; i++) {
                aArr[i] = sc.nextInt();
            }
            int b = sc.nextInt();
            int[] bArr = new int[b];
            for (int i = 0; i < b; i++) {
                bArr[i] = sc.nextInt();
            }
            boolean isGood = true;
            for (int i = 4; i >= 1; i--) {
                int cntA = 0;
                int cntB = 0;

                for (int j = 0; j < a; j++) {
                    if (aArr[j] == i)
                        cntA++;
                }
                for (int j = 0; j < b; j++) {
                    if (bArr[j] == i)
                        cntB++;
                }
                if (cntA > cntB) {
                    System.out.println('A');
                    isGood = false;
                    break;
                } else if (cntA < cntB) {
                    System.out.println('B');
                    isGood = false;
                    break;
                }
            }
            if (isGood)
                System.out.println('D');
        }

    }
}
