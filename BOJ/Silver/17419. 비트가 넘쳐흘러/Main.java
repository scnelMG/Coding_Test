import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();

        int res = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '1')
                res++;
        }
        System.out.println(res);
    }
}