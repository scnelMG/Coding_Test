import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextInt();
        double b = sc.nextInt();
        double c = sc.nextInt();
        double d = sc.nextInt();

        double[] arr = new double[4];

        arr[0] = a / c + b / d;
        arr[1] = a / b + c / d;
        arr[2] = c / a + d / b;
        arr[3] = b / a + d / c;

        double max_v = 0;
        int maxIdx = 0;

        for (int i = 0; i < 4; i++) {
            if (max_v < arr[i]) {
                max_v = arr[i];
                maxIdx = i;
            }

        }
        System.out.println(maxIdx);

    }
}
