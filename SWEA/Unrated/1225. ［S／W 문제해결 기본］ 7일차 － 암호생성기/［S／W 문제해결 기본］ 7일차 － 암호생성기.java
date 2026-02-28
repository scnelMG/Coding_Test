import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int T = sc.nextInt();
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < 8; i++) {
                q.offer(sc.nextInt());
            }

            int minus = 1;
            while (true) {

                int moveNum = q.poll() - minus;
                if (moveNum <= 0) {
                    moveNum = 0;
                    q.offer(moveNum);
                    break;
                }
                q.offer(moveNum);
                minus = minus % 5 + 1;

            }
            System.out.print("#" + tc + " ");
            for (int i = 0; i < 8; i++) {
                System.out.print(q.poll() + " ");
            }
            System.out.println();

        }

    }
}