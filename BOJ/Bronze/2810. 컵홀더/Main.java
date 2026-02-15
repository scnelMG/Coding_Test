import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String s = sc.next();

        int cnt = 0;
        int seat = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L')
                cnt++;
        }
        seat = N + 1 - (cnt / 2);

        System.out.println(Math.min(N, seat));

    }
}
