import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int res1 = a * ((b % 100) % 10);
        int res2 = a * ((b % 100) / 10);
        int res3 = a * (b / 100);
        int res4 = a * b;

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
    }
}
