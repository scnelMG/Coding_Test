
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String input = sc.next();
        sb.append(input);
        sb.reverse();
        if (input.equals(sb.toString())) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }
}