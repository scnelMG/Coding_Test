import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int res = 0;

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            String input = sc.next();
            for (int j = 0; j < M; j++) {
                if (input.charAt(j) == 'O')
                    cnt++;
                else
                    cnt--;
            }
            if (cnt > 0)
                res++;

        }
        System.out.println(res);
    }
}