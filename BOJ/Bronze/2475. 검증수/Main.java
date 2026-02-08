import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int res = 0;
        for (int i = 0; i < 5; i++) {
            int tmp = sc.nextInt();
            res += tmp * tmp;
        }
        System.out.println(res % 10);
    }
}
