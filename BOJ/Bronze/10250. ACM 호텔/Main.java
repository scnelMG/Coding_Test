import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 0; tc < T; tc++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();
            if ((((N - 1) / H) + 1) < 10)
                System.out.println((((N - 1) % H) + 1) + "0" + (((N - 1) / H) + 1));
            else
                System.out.println((((N - 1) % H) + 1) + "" + (((N - 1) / H) + 1));
        }
    }
}
