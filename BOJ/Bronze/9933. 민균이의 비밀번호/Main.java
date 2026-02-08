import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }

        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(arr[i]);
            sb.reverse();
            for (int j = 0; j < N; j++) {
                if (arr[j].equals(sb.toString())) {
                    int len = arr[j].length();
                    System.out.println(len + " " + arr[j].charAt(len / 2));
                    return;

                }
            }
        }

    }
}