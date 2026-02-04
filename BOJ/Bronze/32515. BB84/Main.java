
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String s1 = sc.next();
        String s2 = sc.next();
        String s3 = sc.next();
        String s4 = sc.next();

        String res = "";
        boolean isD = false;
        for (int i = 0; i < N; i++) {
            if (s1.charAt(i) == s3.charAt(i)) {
                if (s2.charAt(i) == s4.charAt(i)) {
                    res += s2.charAt(i);
                } else {
                    isD = true;
                    break;
                }
            }
        }
        if (isD) {
            System.out.println("htg!");
        } else {
            System.out.println(res);
        }
    }

}