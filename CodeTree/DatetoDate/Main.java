package 박민규.CodeTree.DatetoDate;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        int[] days = { 31, 28, 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31 };

        int res = 0;

        if (m1 == m2) {
            res = d2 - d1 + 1;
        } else {
            res += days[m1 - 1] - d1 + 1;

            for (int i = m1 + 1; i < m2; i++) {
                res += days[i - 1];
            }

            res += d2;
        }

        System.out.println(res);
    }
}
