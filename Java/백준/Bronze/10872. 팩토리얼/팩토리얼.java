
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(fac(N));

    }

    public static int fac(int N){
        if (N <= 1) return 1;
        return fac(N-1) * N;
    }
}