import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();

        int[] dir = new int[6];
        int[] len = new int[6];

        int maxW = 0, maxH = 0;
        int idxW = -1, idxH = -1;

        for (int i = 0; i < 6; i++) {
            dir[i] = sc.nextInt();
            len[i] = sc.nextInt();

            if (dir[i] == 1 || dir[i] == 2) { // 동/서 = 가로
                if (len[i] > maxW) {
                    maxW = len[i];
                    idxW = i;
                }
            } else { // 남/북 = 세로
                if (len[i] > maxH) {
                    maxH = len[i];
                    idxH = i;
                }
            }
        }

        int smallH = Math.abs(len[(idxW + 5) % 6] - len[(idxW + 1) % 6]);
        int smallW = Math.abs(len[(idxH + 5) % 6] - len[(idxH + 1) % 6]);
        int smallArea = smallW * smallH;

        int area = maxW * maxH - smallArea;
        System.out.println(area * K);
    }
}
