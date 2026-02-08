import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            String input = sc.next();
            int cnt = 0;
            int res = 0;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == 'O') {
                    res += (++cnt);
                } else {
                    cnt = 0;
                }
            }
            System.out.println(res);
        }

    }
}
