import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            if (A == 0 & B == 0 & C == 0)
                break;

            if (A > B && A > C) {
                if (C * C + B * B == A * A)
                    System.out.println("right");
                else
                    System.out.println("wrong");
            }

            else if (B > A && B > C) {
                if (C * C + A * A == B * B)
                    System.out.println("right");
                else
                    System.out.println("wrong");
            }

            else {
                if (A * A + B * B == C * C)
                    System.out.println("right");
                else
                    System.out.println("wrong");
            }

        }

    }
}
