import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int C = s.length();
        int R = 1;
        int bestR = 1;
        int bestC = C;

        while (R * R <= C) { // R은 sqrt(N)까지만 보면 됨
            if (C % R == 0) { // R이 약수면
                bestR = R; // R이 커질수록 더 정사각형에 가까움
                bestC = C / R;
            }
            R++;
        }

        char[][] arr = new char[bestR][bestC];
        int idx = 0;
        for (int j = 0; j < bestC; j++) {
            for (int i = 0; i < bestR; i++) {
                arr[i][j] = s.charAt(idx++);

            }
        }

        for (int i = 0; i < bestR; i++) {
            for (int j = 0; j < bestC; j++) {
                System.out.print(arr[i][j]);
            }
        }

    }
}
