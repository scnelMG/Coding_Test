import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int[][] arr = new int[5][2];
        int[] dup = new int[2];
        int dupCnt = 0;
        for (int i = 0; i < 6; i++) {
            int d = sc.nextInt(); // 1 2 3 4 (동서남북)
            int len = sc.nextInt();
            if (arr[d][0] == 0)
                arr[d][0] = len;
            else {
                arr[d][1] = len;
                dup[dupCnt++] = d;
            }
        }
        int height = Math.max(arr[3][0], arr[4][0]);
        int width = Math.max(arr[1][0], arr[2][0]);
        int smallBox = arr[dup[0]][1] * arr[dup[1]][0];
        int res = (height * width - smallBox) * K;
        System.out.println(res);

    }
}
