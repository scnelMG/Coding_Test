import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[42];
        int res = 0;

        for (int i = 0; i < 10; i++) {
            int tmp = sc.nextInt();
            arr[tmp % 42] = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            res += arr[i];
        }
        System.out.println(res);

    }
}
