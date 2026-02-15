import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt() - 1;

        int res = 1;
        while (N > 0) {
            N -= (res * 6); // res=1일 때 6, res=2일 때 12 ...
            res++;
        }
        System.out.println(res);
    }
}
