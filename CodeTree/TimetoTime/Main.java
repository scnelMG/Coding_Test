package 박민규.CodeTree.TimetoTime;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        // Please write your code here.
        int res = 0;
        if (d < c) {
            res += 60 + (d - b);
            res += 60 * (c - a - 1);
        } else {
            res += (d - b);
            res += 60 * (c - a);
        }
        System.out.println(res);
    }
}
