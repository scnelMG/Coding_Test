import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        int[] arr = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                -1, -1, -1, -1, -1, -1, };
        for (int i = 0; i < S.length(); i++) {
            int idx = S.charAt(i) - 'a';
            if (arr[idx] == -1)
                arr[idx] = i;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
