import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && (s.charAt(i) == 'c' && s.charAt(i + 1) == '=')) {
                res++;
                i++;
            } else if (i < s.length() - 1 && (s.charAt(i) == 'c' && s.charAt(i + 1) == '-')) {
                res++;
                i++;
            } else if (i < s.length() - 2 && (s.charAt(i) == 'd' && s.charAt(i + 1) == 'z' && s.charAt(i + 2) == '=')) {
                res++;
                i += 2;
            } else if (i < s.length() - 1 && (s.charAt(i) == 'd' && s.charAt(i + 1) == '-')) {
                res++;
                i++;
            } else if (i < s.length() - 1 && (s.charAt(i) == 'l' && s.charAt(i + 1) == 'j')) {
                res++;
                i++;
            } else if (i < s.length() - 1 && (s.charAt(i) == 'n' && s.charAt(i + 1) == 'j')) {
                res++;
                i++;
            } else if (i < s.length() - 1 && (s.charAt(i) == 's' && s.charAt(i + 1) == '=')) {
                res++;
                i++;
            } else if (i < s.length() - 1 && (s.charAt(i) == 'z' && s.charAt(i + 1) == '=')) {
                res++;
                i++;
            } else {
                res++;
            }

        }
        System.out.println(res);

    }
}
