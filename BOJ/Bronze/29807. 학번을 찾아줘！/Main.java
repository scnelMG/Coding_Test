import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] scores = new int[5];
        int res = 0;

        for (int i = 0; i < T; i++) {
            scores[i] = sc.nextInt();
        }

        if (scores[0] > scores[2]) {
            res += (scores[0] - scores[2]) * 508;
        } else {
            res += (scores[2] - scores[0]) * 108;
        }

        if (scores[1] > scores[3]) {
            res += (scores[1] - scores[3]) * 212;
        } else {
            res += (scores[3] - scores[1]) * 305;
        }
        res += scores[4] * 707;
        res *= 4763;
        System.out.println(res);

    }
}