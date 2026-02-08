import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int[] res = new int[10];
        int num = A * B * C;
        while (num > 0) {
            res[num % 10]++;
            num /= 10;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(res[i]);
        }
    }
}
